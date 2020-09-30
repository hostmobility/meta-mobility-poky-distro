SUMMARY = "cpulimit"
DESCRIPTION = "Cpulimit is a tool which limits the CPU usage of a process (expressed in percentage, not in CPU time)"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=86c1c0d961a437e529db93aa3bb32dc4"

SRC_URI = "https://github.com/opsengine/cpulimit/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "ac86cd54173251223fb89b14a73ae37c"
SRC_URI[sha256sum] = "64312f9ac569ddcadb615593cd002c94b76e93a0d4625d3ce1abb49e08e2c2da"

S = "${WORKDIR}/${PN}-${PV}"

do_compile () {
   oe_runmake  
}

do_install() {
    install -d ${D}${base_sbindir}
    install -m 744 ${B}/src/cpulimit ${D}${base_sbindir}/cpulimit
}
