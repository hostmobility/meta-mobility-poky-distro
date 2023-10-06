FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "\
	file://journald.conf \
"

do_install:append() {
    install -m 0644 ${WORKDIR}/journald.conf ${D}/${sysconfdir}/systemd/journald.conf
    install -m 0644 ${WORKDIR}/journald.conf ${D}/${sysconfdir}/systemd/journald-custom.conf
}
