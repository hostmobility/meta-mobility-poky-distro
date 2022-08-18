SUMMARY = "Expand the rootfs to the full size of its partion"
DESCRIPTION = "Script to expand the rootfs to the full size of its partion, started as a systemd service which removes itself once finished"
LICENSE = "PD"
PR = "r3"

RRECOMMENDS_${PN} = "e2fsprogs-resize2fs"

SRC_URI =  " \
    file://resizefs.sh \
    file://resizefs.service \
    file://COPYING \
"

LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=1c3a7fb45253c11c74434676d84fe7dd"

do_compile () {
}

do_install () {
    install -d ${D}/${sbindir}
    install -m 0755 ${WORKDIR}/*.sh ${D}/${sbindir}

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/resizefs.service ${D}${systemd_unitdir}/system
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "resizefs.service"

inherit allarch systemd