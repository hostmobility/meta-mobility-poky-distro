SUMMARY = "Bredbandskollen CLI"
DESCRIPTION = "A command-line version of Bredbandskollen CLI: A bandwidth measurement tool."
HOMEPAGE = "https://github.com/dotse/bbk"
LICENSE = "GPLv2-or-later"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

SRC_URI = "git://github.com/dotse/bbk.git;branch=master;protocol=https"
SRCREV = "cfb7bb634e1bf2179ac4a2f1fb0e1e5abb4eebd7"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CC="${CC}" CXX="${CXX}" CFLAGS="${CFLAGS}" CXXFLAGS="${CXXFLAGS}" LDFLAGS="${LDFLAGS}" GNUTLS=1'
DEPENDS = "gnutls"

do_compile() {
    oe_runmake -C src/cli
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/src/cli/cli ${D}${bindir}/bbk-cli
}

FILES_${PN} = "${bindir}/bbk-cli"
