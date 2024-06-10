DESCRIPTION = "Host modem manager for wvdial"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = " \
    file://host-modem-m.sh \
    file://host-modem-m.service \
    file://onomondo-wvdial.conf \
"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "host-modem-m.service"
RDEPENDS:${PN} = "bash wvdial"

do_install() {

    install -d ${D}${systemd_unitdir}/system
    install -m 644 ${WORKDIR}/host-modem-m.service ${D}${systemd_unitdir}/system/${PN}.service
    
    install -d ${D}/opt/
    install -d ${D}/opt/host-modem-m
    install -m 744 ${WORKDIR}/host-modem-m.sh ${D}/opt/host-modem-m/host-modem-m.sh
    install -m 644 ${WORKDIR}/onomondo-wvdial.conf ${D}/opt/host-modem-m/onomondo-wvdial.conf

}

FILES:${PN} += "/opt/host-modem-m/host-modem-m.sh /opt/host-modem-m/onomondo-wvdial.conf"