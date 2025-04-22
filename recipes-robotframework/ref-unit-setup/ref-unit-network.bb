DESCRIPTION="Network setup for Hostmobility Production ref units"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "1.0"

SRC_URI = " \
	file://ref_eth0.network \
	file://ref_eth1.network \
	file://ref_eth2.network \
	file://ref_eth3.network \
    file://ref_can.network \
    file://ref_unit_ssh_config \
"

do_install() {
	# setup a ref network that is on same network as dut.
	install -d ${D}${systemd_unitdir}/network
	install -m 0644 ${WORKDIR}/ref_eth0.network ${D}${systemd_unitdir}/network/81-eth0.network
	install -m 0644 ${WORKDIR}/ref_eth1.network ${D}${systemd_unitdir}/network/81-eth1.network
	install -m 0644 ${WORKDIR}/ref_eth2.network ${D}${systemd_unitdir}/network/81-eth2.network
	install -m 0644 ${WORKDIR}/ref_eth3.network ${D}${systemd_unitdir}/network/81-eth3.network
	#Setup all CAN on 500k bitrate.
	install -m 0644 ${WORKDIR}/ref_can.network ${D}${systemd_unitdir}/network/80-can.network

    # ssh config to allow none strict host access to DUT.
	install -d ${D}${sysconfdir}/ssh
	install -m 0644 ${WORKDIR}/ref_unit_ssh_config ${D}${sysconfdir}/ssh/ref_unit_ssh_config
}

FILES:${PN} = " \
    ${systemd_unitdir}/network/81-eth0.network \
    ${systemd_unitdir}/network/81-eth1.network \
    ${systemd_unitdir}/network/81-eth2.network \
    ${systemd_unitdir}/network/81-eth3.network \
    ${systemd_unitdir}/network/80-can.network \
    ${sysconfdir}/ssh/ref_unit_ssh_config \
"