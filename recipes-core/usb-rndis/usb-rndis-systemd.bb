SECTION = "network"
SUMMARY = "RNDIS usb client configuration and startup"

RDEPENDS_${PN} += "bash"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r1"

inherit allarch systemd

SRC_URI = " \
    file://hm-usb.sh \
    file://usb-rndis.service \
"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${WORKDIR}/hm-usb.sh ${D}/${bindir}/hm-usb.sh

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/usb-rndis.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += " \
    ${systemd_unitdir}/system \
"

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "usb-rndis.service"

