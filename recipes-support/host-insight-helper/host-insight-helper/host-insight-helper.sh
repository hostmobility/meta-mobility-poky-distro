#!/bin/sh

ID_PATH="/etc/opt/host-insight-client/identity-fallback.toml"
CLIENT_UPGRADE="/tmp/host-insight/client_upgrade"  # Client creates this file

upgrade_client()
{
  client="host-insight-client"
  systemctl stop $client
  read -r new < "$CLIENT_UPGRADE"
  echo "Upgrading $client to version $new..."
  opkg update
  opkg remove "$client"
  if ! opkg install "$client$new"; then
    echo "Failed to upgrade to version $new."
    echo "Falling back to installing the available $client."
    opkg install "$client"
  fi
  rm "$CLIENT_UPGRADE"
  systemctl start $client
}

assign_uid_and_fallback_domain()
{
  # Get the serial number of the device.
  if [ "$(cat /etc/platform-system-type)" = "c61" ]; then
    if command -v pgrep >/dev/null 2>&1; then
      while pgrep -f "/opt/hm/pic_upgrade.sh" >/dev/null 2>&1; do
        # pic_upgrade is still running
        sleep 1
      done
    else
      # Sleep until we suspect that pic_upgrade is complete
      sleep 30
    fi
    echo "uid = \"$(cat /opt/hm/pic_attributes/ctrl_serial_nr)\"" > "$ID_PATH"
  else
    echo "uid = \"$(cat /proc/device-tree/chosen/serial-number)\"" > "$ID_PATH"
  fi

  # Set fallback domain
  echo "domain = \"deploy.hostmobility.org\"" >> $ID_PATH
  systemctl disable host-insight-helper
}

if [ -e "$CLIENT_UPGRADE" ]; then
  upgrade_client
else
  assign_uid_and_fallback_domain
fi
