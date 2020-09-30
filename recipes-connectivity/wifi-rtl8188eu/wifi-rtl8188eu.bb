DESCRIPTION = "Wifi drivers for rtl8188eu"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/lwfinger/rtl8188eu.git;protocol=https;branch=${SRCBRANCH}"
SRCBRANCH = "v5.2.2.4"
SRCREV = "ddd5974ad2e042394334b83107e10a792bab7702"
PR = "r1"

S = "${WORKDIR}/git"

inherit module

EXTRA_OEMAKE += "KSRC=${STAGING_KERNEL_DIR} MODDESTDIR=${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}"

do_install () {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -p -m 644 8188eu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -d ${D}${nonarch_base_libdir}/firmware
    install -p -m 644 ${S}/rtl8188eufw.bin ${D}${nonarch_base_libdir}/firmware/rtl8188eufw.bin
}

FILES_${PN} += "${nonarch_base_libdir}/firmware/rtl8188eufw.bin"

RPROVIDES_${PN} += "kernel-module-rtl8188eu"