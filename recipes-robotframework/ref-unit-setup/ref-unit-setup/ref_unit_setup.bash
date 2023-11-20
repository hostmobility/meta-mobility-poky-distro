#!/usr/bin/env bash

# Copyright (c) 2023 Host Mobility

#Setup a reference unit for production rigs

# stop usb service let the dut setup the network.
systemctl stop usb-rndis
systemctl disable usb-rndis

mv -f /lib/systemd/network/81-eth0.network /lib/systemd/network/80-eth0.network
mv -f /lib/systemd/network/81-eth1.network /lib/systemd/network/80-eth1.network
mv -f /lib/systemd/network/81-eth2.network /lib/systemd/network/80-eth2.network
mv -f /lib/systemd/network/81-eth3.network /lib/systemd/network/80-eth3.network

rm /lib/systemd/network/80-can0.network
rm /lib/systemd/network/80-can1.network
rm /lib/systemd/network/80-can2.network
rm /lib/systemd/network/80-can3.network
rm /lib/systemd/network/80-can4.network
rm /lib/systemd/network/80-can5.network


#install tools that is not in poky when we have internet access.
while true; do
    # Check network connectivity
    if ping -c 1 1.1.1.1 &> /dev/null; then
        break
    fi
    sleep 1
done

set -e

pip3 install robotframework-sshlibrary
pip3 install pyodbc
pip3 install robotframework-requests
pip3 install sqlalchemy
pip3 install sqlalchemy.orm
pip3 install prettytable
pip3 install psycopg2-binary

python3 -m pip install "python-can"

set +e
# use our ssh/config (maybe unneded if we not remote direct to the DUT unit)
cp -f /etc/ssh/ssh_config /etc/ssh/ssh/ssh_config_old
cp -f /etc/ssh/ref_unit_ssh_config /etc/ssh/ssh_config
# reload ip address
networkctl reload
set -e

#Set host name
serial_number=0
serial_number=$(cat /proc/device-tree/chosen/serial-number)
hostname="REF-HMX-${serial_number}"
# Update the hostname
echo "$hostname" > /etc/hostname
hostname "$hostname"

#Configure etc/hosts
cat << EOF >> /etc/hosts
192.168.1.200 dut_eth0
192.168.1.201 ref_eth0
192.168.1.20 mxv_eth0

192.168.2.200 dut_eth1_default
192.168.2.201 ref_eth1_default

192.168.3.200 dut_eth2
192.168.4.201 ref_eth2

192.168.4.200 dut_eth3
192.168.3.201 ref_eth3

192.168.250.1 dut_usb
192.168.250.2 ref_usb
EOF

set -e
# Enable printer
lpadmin -p ZebraGX430t -E -v usb://Zebra%20Technologies/ZTC%20GX430t
cupsaccept ZebraGX430t
cupsenable ZebraGX430t



# configuration is done stop this service and disable it we dont need it any more.
systemctl disable ref_unit_setup.service
systemctl stop ref_unit_setup.service

echo "Done, reboot the system!"


