FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://hostapd_custom.conf \
"
SYSTEMD_SERVICE:${PN} = "hostapd.service"
# Set this to enable if you want your bsp image to start the ap mode direct from first startup.
SYSTEMD_AUTO_ENABLE:${PN} = "disable"

do_install:append() {
    install -m 0644 ${WORKDIR}/hostapd_custom.conf ${D}${sysconfdir}/hostapd_custom.conf
}

FILES:${PN} += "${sysconfdir}/hostapd_custom.conf"