SYSTEMD_AUTO_ENABLE:${PN} = "enable"

FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += " \
    file://modem-power-on.service \
"

do_install:append:verdin-am62-hmm() {
    install -D -m 644 ${WORKDIR}/modem-power-on.service \
        ${D}${systemd_system_unitdir}/modem-power-on.service
}

SYSTEMD_SERVICE:${PN}:append:verdin-am62-hmm = " modem-power-on.service"
FILES:${PN}:append:verdin-am62-hmm = " ${systemd_system_unitdir}/modem-power-on.service"



