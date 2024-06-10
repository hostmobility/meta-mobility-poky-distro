DESCRIPTION = "host-insight modem manager for wvdial"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = " \
    file://host-insight-m.sh \
    file://host-insight-m.service \
    file://onomondo-wvdial.conf \
"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "host-insight-m.service"
RDEPENDS:${PN} = "bash wvdial"

do_install() {

    install -d ${D}${systemd_unitdir}/system
    install -m 644 ${WORKDIR}/host-insight-m.service ${D}${systemd_unitdir}/system/${PN}.service
    
    install -d ${D}/opt/
    install -d ${D}/opt/host-insight-m
    install -m 744 ${WORKDIR}/host-insight-m.sh ${D}/opt/host-insight-m/host-insight-m.sh
    install -m 644 ${WORKDIR}/onomondo-wvdial.conf ${D}/opt/host-insight-m/onomondo-wvdial.conf

}

FILES:${PN} += "/opt/host-insight-m/host-insight-m.sh /opt/host-insight-m/onomondo-wvdial.conf"