SUMMARY = "file-poll"
DESCRIPTION = " Program that listents for poll() events on a file"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"

SRCREV = "fd9c7886739b1abb8a3f03998e4b73ec567fb638"

SRC_URI = "git://github.com/hostmobility/file-poll.git"
SRC_URI[md5sum] = "6d7fa154e28652230a284e9bad12d71f"
SRC_URI[sha256sum] = "2e2fe1284753e016d6bc2b0bca0c71659a10a2460f6cfb3de1a587193092a838"

S = "${WORKDIR}/git"

do_compile () {
   oe_runmake  
}

do_install() {
    install -d ${D}${bindir}
    install -m 744 ${B}/file-poll ${D}${bindir}/file-poll
}
