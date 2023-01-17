#!/bin/sh

ID_PATH="/etc/opt/host-insight-client/identity-fallback.toml"

# Get the serial number of the device.
if [ "$(cat /etc/platform-system-type)" = "c61" ]; then
  # Sleep until we know that pic_upgrade is complete
  sleep 30
  echo "uid = \"$(cat /opt/hm/pic_attributes/ctrl_serial_nr)\"" > $ID_PATH
else
  echo "uid = \"$(cat /proc/device-tree/chosen/serial-number)\"" > $ID_PATH
fi

# Set fallback domain
echo "domain = \"deploy.hostmobility.org\"" >> $ID_PATH

systemctl disable host-insight-client-helper
