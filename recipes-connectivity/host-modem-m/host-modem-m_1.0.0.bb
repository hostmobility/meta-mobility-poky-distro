DESCRIPTION = "Host modem manager for wvdial"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

COMPATIBLE_MACHINE = "(mx5-pt|tegra|vf60)"

SRC_URI = "\
    file://host-modem-m.service \
    file://wvdial.conf \
    file://host-modem-m.sh \
"
inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "host-modem-m.service"
RDEPENDS:${PN} = "wvdial"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 644 ${WORKDIR}/host-modem-m.service ${D}${systemd_unitdir}/system/${PN}.service
    
    install -d ${D}/opt/
    install -d ${D}/opt/host-modem-m
    install -m 644 ${WORKDIR}/wvdial.conf ${D}/opt/host-modem-m/wvdial.conf

    install -m 744 ${WORKDIR}/host-modem-m.sh ${D}/opt/host-modem-m/host-modem-m.sh
}

FILES:${PN} += "/opt/host-modem-m/host-modem-m.sh /opt/host-modem-m/wvdial.conf"
