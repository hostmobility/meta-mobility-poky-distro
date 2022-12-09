FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://hostapd_custom.conf \
"
SYSTEMD_SERVICE:${PN} = "hostapd.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install:append() {
    install -m 0644 ${WORKDIR}/hostapd_custom.conf ${D}${sysconfdir}/hostapd_custom.conf
}

FILES:${PN} += "${sysconfdir}/hostapd_custom.conf"