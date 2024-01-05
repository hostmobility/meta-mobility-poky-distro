SUMMARY = "Tools for Hostmobility Production mxv ref units"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "1.0"

SRC_URI = " \
	file://ref_mxv_eth0.network \
"

do_install() {
	install -d ${D}${systemd_unitdir}/network

	# setup a ref network that is on the same network as dut.
	install -D -m0644 ${WORKDIR}/ref_mxv_eth0.network ${D}${systemd_unitdir}/network/80-eth0.network
	install -D -m0644 ${WORKDIR}/ref_mxv_eth0.network ${D}${systemd_unitdir}/network/81-eth0.network
}

FILES:${PN} += "\
	${systemd_unitdir} \
	${systemd_unitdir}/network \
	${systemd_unitdir}/network/80-eth0.network \
	${systemd_unitdir}/network/81-eth0.network \
"