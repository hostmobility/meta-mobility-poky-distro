DESCRIPTION = "Host Insight helper"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = " \
    file://host-insight-helper.sh \
    file://host-insight-helper.service \
"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "host-insight-helper.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 644 ${WORKDIR}/host-insight-helper.service ${D}${systemd_unitdir}/system/${PN}.service

    install -d ${D}/opt/
    install -d ${D}/opt/host-insight-helper
    install -m 744 ${WORKDIR}/host-insight-helper.sh ${D}/opt/host-insight-helper/host-insight-helper.sh
}

FILES:${PN} += "/opt/host-insight-helper/host-insight-helper.sh"