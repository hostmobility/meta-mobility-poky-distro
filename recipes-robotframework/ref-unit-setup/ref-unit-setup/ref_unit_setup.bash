#!/usr/bin/env bash

# Copyright (c) 2023 Host Mobility

#Setup a reference unit for production rigs

# stop usb service let the dut setup the network.
systemctl stop usb-rndis
systemctl disable usb-rndis

mv -f /lib/systemd/network/81-eth3.network /lib/systemd/network/80-eth0.network
mv -f /lib/systemd/network/81-eth3.network /lib/systemd/network/80-eth1.network
mv -f /lib/systemd/network/81-eth3.network /lib/systemd/network/80-eth2.network
mv -f /lib/systemd/network/81-eth3.network /lib/systemd/network/80-eth3.network
networkctl reload

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

python3 -m pip install "python-can"

# use our ssh/config (maybe unneded if we not remote direct to the DUT unit)
cp -f /etc/ssh/config /etc/ssh/ssh/config_old
cp -f /etc/ssh/ref_unit_ssh_config /etc/ssh/ssh/config
# configuration is done stop this service and disable it we dont need it any more.
systemctl disable ref_unit_setup.service
systemctl stop ref_unit_setup.service

echo done, reboot the system!


