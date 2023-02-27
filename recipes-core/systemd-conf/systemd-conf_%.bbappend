FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "\
	file://eth0.network \
	file://eth1.network \
	file://eth2.network \
	file://eth3.network \
	file://usb1.network \
	file://wlan0.network \
	file://can0.network \
	file://can1.network \
	file://can2.network \
	file://can3.network \
	file://can4.network \
	file://can5.network \
	file://can6.network \
"

do_install:append() {
	install -D -m0644 ${WORKDIR}/eth0.network ${D}${systemd_unitdir}/network/80-eth0.network
	install -D -m0644 ${WORKDIR}/eth1.network ${D}${systemd_unitdir}/network/80-eth1.network
	install -D -m0644 ${WORKDIR}/eth2.network ${D}${systemd_unitdir}/network/80-eth2.network
	install -D -m0644 ${WORKDIR}/eth3.network ${D}${systemd_unitdir}/network/80-eth3.network

	if ${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'true', 'false', d)}; then
	install -D -m0644 ${WORKDIR}/wlan0.network ${D}${systemd_unitdir}/network/80-wlan0.network
	fi

	if ${@bb.utils.contains('MACHINE_FEATURES', 'usbgadget', 'true', 'false', d)}; then
		install -D -m0644 ${WORKDIR}/usb1.network ${D}${systemd_unitdir}/network/10-usb.network
	fi

# Example files for can0 to 6: (does not do anything but if you remove # for
# BitRate=500K and RestartSec=100ms it will start CAN controller(s) on next
# reboot or use 'networkctl reload' on interface named can0 to 6). 

	install -D -m0644 ${WORKDIR}/can0.network ${D}${systemd_unitdir}/network/80-can0.network
	install -D -m0644 ${WORKDIR}/can1.network ${D}${systemd_unitdir}/network/80-can1.network
	install -D -m0644 ${WORKDIR}/can2.network ${D}${systemd_unitdir}/network/80-can2.network
	install -D -m0644 ${WORKDIR}/can3.network ${D}${systemd_unitdir}/network/80-can3.network
	install -D -m0644 ${WORKDIR}/can4.network ${D}${systemd_unitdir}/network/80-can4.network
	install -D -m0644 ${WORKDIR}/can5.network ${D}${systemd_unitdir}/network/80-can5.network
	install -D -m0644 ${WORKDIR}/can6.network ${D}${systemd_unitdir}/network/80-can6.network

}
