FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
  file://usb1.network \
  "

do_install_append() {
    if ${@bb.utils.contains('MACHINE_FEATURES', 'usbgadget', 'true', 'false', d)}; then
		install -D -m0644 ${WORKDIR}/usb1.network ${D}${systemd_unitdir}/network/10-usb.network
    fi
}