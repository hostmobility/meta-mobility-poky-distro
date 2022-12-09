SUMMARY = "Demo hostap wirless networking package group"
DESCRIPTION = "Package group bringing in packages for a auto start wlan host deamon"

inherit packagegroup

PACKAGES = "\
    packagegroup-hostmobility-hostapd \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    iperf \ 
    hostapd \
    dhcp-client \
"
#hostap-daemon
