SUMMARY = "uart-test"
DESCRIPTION = " Program that is able to send/recieve data on a serial port"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"

SRCREV = "b8a26db294b77c1d0dea83def036cb063ecdeb02"

SRC_URI = "git://github.com/hostmobility/uart-test.git"
SRC_URI[md5sum] = "6d7fa154e28652230a284e9bad12d71f"
SRC_URI[sha256sum] = "2e2fe1284753e016d6bc2b0bca0c71659a10a2460f6cfb3de1a587193092a838"

S = "${WORKDIR}/git"

do_compile () {
   oe_runmake  
}

do_install() {
    install -d ${D}${sbindir}
    install -m 744 ${B}/uart-test ${D}${sbindir}/uart-test
}
