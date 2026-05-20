FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "\
	file://journald.conf \
    file://timesyncd.conf \
"

do_install:append() {
    install -m 0644 ${WORKDIR}/journald.conf ${D}/${sysconfdir}/systemd/journald.conf
    install -m 0644 ${WORKDIR}/timesyncd.conf ${D}/${sysconfdir}/systemd/timesyncd.conf
    install -m 0644 ${WORKDIR}/journald.conf ${D}/${sysconfdir}/systemd/journald-custom.conf
}
