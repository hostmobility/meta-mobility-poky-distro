DESCRIPTION = "Host modem manager for wvdial"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    file://host-modem-m.service \
    file://wvdial.conf \
    file://host-modem-m.sh \
"
inherit systemd

# Ensure systemd service is disabled by default. This is to allow
# fetching data over the local network before the cellular connection is
# is up.

SYSTEMD_AUTO_ENABLE:${PN} = "enable"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "host-modem-m.service"
RDEPENDS:${PN} = "wvdial ppp"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 644 ${WORKDIR}/host-modem-m.service ${D}${systemd_unitdir}/system/${PN}.service

    install -d ${D}/opt/
    install -d ${D}/opt/host-modem-m
    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/wvdial.conf ${D}/${sysconfdir}/wvdial.conf

    install -m 744 ${WORKDIR}/host-modem-m.sh ${D}/opt/host-modem-m/host-modem-m.sh
}

FILES:${PN} += "/opt/host-modem-m/host-modem-m.sh ${sysconfdir}/wvdial.conf"