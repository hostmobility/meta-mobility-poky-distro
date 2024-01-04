SUMMARY = "Tools for Hostmobility Production mxv ref units"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "1.0"

SRC_URI = " \
	file://ref_mxv_eth0.network \
"

do_install() {
	install -d ${D}${systemd_unitdir}
	install -d ${D}${systemd_unitdir}/system

	# setup a ref network that is on same network as dut.
	install -D -m0644 ${WORKDIR}/ref_mxv_eth0.network ${D}${systemd_unitdir}/network/80-eth0.network
	install -D -m0644 ${WORKDIR}/ref_mxv_eth0.network ${D}${systemd_unitdir}/network/81-eth0.network
}

FILES:${PN} = "\
	${D}${systemd_unitdir}/network/80-eth0.network
	${D}${systemd_unitdir}/network/81-eth0.network
"