PACKAGECONFIG:append = " gnutls modemmanager"

FILESEXTRAPATHS:prepend := "${THISDIR}/connection-profiles:"

SRC_URI += " \
    file://onomondo.nmconnection \
    file://fallback-cxn.nmconnection \
"

do_install:append() {
    install -d ${D}${sysconfdir}/NetworkManager/system-connections
    install -m 0600 ${WORKDIR}/onomondo.nmconnection \
        ${D}${sysconfdir}/NetworkManager/system-connections/onomondo.nmconnection
    install -m 0600 ${WORKDIR}/fallback-cxn.nmconnection \
        ${D}${sysconfdir}/NetworkManager/system-connections/fallback-cxn.nmconnection
    install -d ${D}${sysconfdir}/NetworkManager/conf.d
}

FILES:${PN} += " \
    ${sysconfdir}/NetworkManager/system-connections/*.nmconnection \
    ${sysconfdir}/NetworkManager/conf.d/*.conf \
"

SYSTEMD_AUTO_ENABLE:${PN} = "enable"