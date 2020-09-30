FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

RDEPENDS_${PN} += "bash"

SRC_URI += "\
	file://interfaces \
	file://mx4_down \
	file://mx4_up \
	"

do_install_append() {
    install -d ${D}${sysconfdir}/network/
    install -d ${D}${sysconfdir}/network/if-up.d
    install -d ${D}${sysconfdir}/network/if-down.d

    install -m 0755 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces
    install -m 0755 ${WORKDIR}/mx4_down ${D}${sysconfdir}/network/if-down.d/01mx4_down
    install -m 0755 ${WORKDIR}/mx4_up ${D}${sysconfdir}/network/if-up.d/01mx4_up
}

FILES_${PN} += "\
    ${sysconfdir}/network/interfaces \
    ${sysconfdir}/network/if-down.d/01mx4_down \
    ${sysconfdir}/network/if-up.d/01mx4_up \
"
