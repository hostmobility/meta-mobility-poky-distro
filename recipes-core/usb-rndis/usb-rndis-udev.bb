SECTION = "network"
SUMMARY = "RNDIS usb client configuration and startup"

RDEPENDS:${PN} += "bash"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r1"

SRC_URI = " \
    file://hm-usb.sh \
    file://99-usb-role-switch.rules \
"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${WORKDIR}/hm-usb.sh ${D}/${bindir}/hm-usb.sh

	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/99-usb-role-switch.rules ${D}${sysconfdir}/udev/rules.d/
}

