DESCRIPTION = "Automatic configuration for ethX interfaces on MX-4 Board"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SRC_URI += "\
    file://ifplugd.action \
    file://ifplugd.service \
    file://ifplugd1.service \
    file://ifplugd2.service \
"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/ifplugd.service ${D}${systemd_unitdir}/system/ifplugd.service
    install -m 0644 ${WORKDIR}/ifplugd1.service ${D}${systemd_unitdir}/system/ifplugd1.service
    install -m 0644 ${WORKDIR}/ifplugd2.service ${D}${systemd_unitdir}/system/ifplugd2.service

    install -d ${D}${sysconfdir}/ifplugd
    install -m 0744 ${WORKDIR}/ifplugd.action ${D}${sysconfdir}/ifplugd/ifplugd.action
}

PACKAGES += "${PN}-systemd-eth0 ${PN}-systemd-eth1 ${PN}-systemd-eth2"

FILES:${PN}-systemd-eth0 = "${systemd_unitdir}/system/ifplugd.service"
FILES:${PN}-systemd-eth1 = "${systemd_unitdir}/system/ifplugd1.service"
FILES:${PN}-systemd-eth2 = "${systemd_unitdir}/system/ifplugd2.service"

SYSTEMD_PACKAGES = "${PN}-systemd-eth0 ${PN}-systemd-eth1 ${PN}-systemd-eth2"
SYSTEMD_SERVICE:${PN}-systemd-eth0 = "ifplugd.service"
SYSTEMD_SERVICE:${PN}-systemd-eth1 = "ifplugd1.service"
SYSTEMD_SERVICE:${PN}-systemd-eth2 = "ifplugd2.service"
