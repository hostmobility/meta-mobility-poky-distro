DESCRIPTION = "Host modem manager for wvdial"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    file://host-modem-m.service \
    file://wvdial.conf \
    file://host-modem-m.sh \
"
inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "${PN}.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

RDEPENDS:${PN} = "wvdial ppp"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 644 ${WORKDIR}/host-modem-m.service \
        ${D}${systemd_system_unitdir}/${PN}.service
    
    install -d ${D}/opt/host-modem-m
    install -m 744 ${WORKDIR}/host-modem-m.sh ${D}/opt/host-modem-m/host-modem-m.sh

    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/wvdial.conf ${D}/${sysconfdir}/wvdial.conf
}

FILES:${PN} += " \
	/opt/host-modem-m/host-modem-m.sh \
	${systemd_system_unitdir}/${PN}.service \
	${sysconfdir}/wvdial.conf \
"
