FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
  file://eth0.network \
  file://eth1.network \
  file://eth2.network \
  file://usb1.network \
  "

do_install_append() {
	install -D -m0644 ${WORKDIR}/eth0.network ${D}${systemd_unitdir}/network/80-eth0.network
	install -D -m0644 ${WORKDIR}/eth1.network ${D}${systemd_unitdir}/network/80-eth1.network
	install -D -m0644 ${WORKDIR}/eth2.network ${D}${systemd_unitdir}/network/80-eth2.network

    if ${@bb.utils.contains('MACHINE_FEATURES', 'usbgadget', 'true', 'false', d)}; then
		install -D -m0644 ${WORKDIR}/usb1.network ${D}${systemd_unitdir}/network/10-usb.network
    fi
}