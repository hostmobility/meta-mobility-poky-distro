SUMMARY = "watchdog-test"
DESCRIPTION = " Program to test Linux watchdog"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"

SRCREV = "511bc90f33d0d6ed37d03af1e91a6c5589f612ae"

SRC_URI = "git://github.com/hostmobility/watchdog-test.git"
SRC_URI[md5sum] = "6d7fa154e28652230a284e9bad12d71f"
SRC_URI[sha256sum] = "2e2fe1284753e016d6bc2b0bca0c71659a10a2460f6cfb3de1a587193092a838"

S = "${WORKDIR}/git"

do_compile () {
   oe_runmake  
}

do_install() {
    install -d ${D}${sbindir}
    install -m 744 ${B}/watchdog-test ${D}${sbindir}/watchdog-test
}
