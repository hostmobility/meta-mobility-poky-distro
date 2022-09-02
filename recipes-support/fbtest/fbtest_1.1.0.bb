SUMMARY = "fbtest"
DESCRIPTION = " This program supports displays an test image on a /dev/fb"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"



SRC_URI = "git://github.com/hostmobility/fb-test-app.git;protocol=https;branch=master"
SRC_URI[md5sum] = "da0ebecd284d7f4afcfc226be2e648b6"
SRC_URI[sha256sum] = "0019f1ab11aa8364b17727a7b6916a8a07fad25aefe23c45d33d4d4db4f7b6f1"
SRCREV = "063ec650960c2d79ac51f5c5f026cb05343a33e2"

S = "${WORKDIR}/git"

do_compile () {
   oe_runmake  
}

do_install() {
    install -d ${D}${base_sbindir}
    install -m 744 ${B}/fb-test ${D}${base_sbindir}/fb-test
}
