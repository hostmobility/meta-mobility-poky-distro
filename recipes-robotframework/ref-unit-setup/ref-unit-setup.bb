SUMMARY = "Tools for Hostmobility Production ref units"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/README.md;md5=15172a07c9a201b68c4dc6611f280362"

SRCREV = "abcbfc3470eaecf0e3f6a86873e7ccc09e2d055f"
PV = "1.2"

SRC_URI[md5sum] = "009c73c6e18970d201b3168158cff2f3"
SRC_URI[sha256sum] = "0fa00df5e70e3044b294b41c6f1d1d28254997bbe0c2b9fbfacaf62493f4e769"
SRC_URI = " \
	https://gitlab.com/hostmobility/test-toolkit.git;protocol=https;branch=main" \
	file://ref_eth0.network \
	file://ref_eth1.network \
	file://ref_eth2.network \
	file://ref_eth3.network \
	file://ref_unit_setup.bash \
	file://ref_unit_setup.service \
	file://ref_unit.bash \
	file://ref_unit.service \
	file://ref_unit_ssh_config \
	file://ref_can.network \
"

inherit systemd

DEPENDS = "virtual/kernel"

SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE:${PN} = "ref_unit.service ref_unit_setup.service"
RDEPENDS:${PN} = "bash"


do_install() {
	install -d ${D}${systemd_unitdir}
	install -d ${D}${systemd_unitdir}/system
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/ssh
	install -d ${D}/opt/hm/
	install -d ${D}/home/root/HostMobilityProductionTest
	install -d ${D}/home/root/HostMobilityProductionTestGUI

	# setup a ref network that is on same network as dut.
	install -D -m0644 ${WORKDIR}/ref_eth0.network ${D}${systemd_unitdir}/network/81-eth0.network
	install -D -m0644 ${WORKDIR}/ref_eth1.network ${D}${systemd_unitdir}/network/81-eth1.network
	install -D -m0644 ${WORKDIR}/ref_eth2.network ${D}${systemd_unitdir}/network/81-eth2.network
	install -D -m0644 ${WORKDIR}/ref_eth3.network ${D}${systemd_unitdir}/network/81-eth3.network

	#Setup all CAN on 500k bitrate.
	install -D -m0644 ${WORKDIR}/ref_can.network ${D}${systemd_unitdir}/network/80-can.network
	
	# install and disable configurations in ref
	install -m 0644 ${WORKDIR}/ref_unit_setup.service ${D}${systemd_unitdir}/system/ref_unit_setup.service
	install -m 0755 ${WORKDIR}/ref_unit_setup.bash ${D}/opt/hm/ref_unit_setup.bash
	
	# Run test GUI from startup
	install -m 0644 ${WORKDIR}/ref_unit.service ${D}${systemd_unitdir}/system/ref_unit.service
	install -m 0755 ${WORKDIR}/ref_unit.bash ${D}/opt/hm/ref_unit.bash

	# ssh config to allow none strict host access to DUT.
	install -m 0644 ${WORKDIR}/ref_unit_ssh_config ${D}${sysconfdir}/ssh/ref_unit_ssh_config

	install -m 0644 ${WORKDIR}/HostMobilityProductionTest/* ${D}/home/root/HostMobilityProductionTest
	install -m 0644 ${WORKDIR}/HostMobilityProductionTestGUI/* ${D}/home/root/HostMobilityProductionTestGUI
}

FILES:${PN} = "\
    /opt/hm/ref_unit_setup.bash \
    /opt/hm/ref_unit.bash \
    ${systemd_unitdir}/system/ref_unit_setup.service \
    ${systemd_unitdir}/system/ref_unit.service \
    ${systemd_unitdir}/network/81-eth0.network \
    ${systemd_unitdir}/network/81-eth1.network \
    ${systemd_unitdir}/network/81-eth2.network \
    ${systemd_unitdir}/network/81-eth3.network \
    ${systemd_unitdir}/network/80-can.network \
	${sysconfdir}/ssh/ref_unit_ssh_config \
	/home/root/HostMobilityProductionTest \
	/home/root/HostMobilityProductionTestGUI \
"