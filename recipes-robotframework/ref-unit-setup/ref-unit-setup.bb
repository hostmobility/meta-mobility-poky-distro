SUMMARY = "Tools for Hostmobility Production ref units"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV = "265944b5d428e8da36e851c1e2631a897f6142c4"
PV = "1.0"

SRC_URI[md5sum] = "009c73c6e18970d201b3168158cff2f3"
SRC_URI[sha256sum] = "0fa00df5e70e3044b294b41c6f1d1d28254997bbe0c2b9fbfacaf62493f4e769"
SRC_URI = " \
	gitsm://git@gitlab.com/hostmobility/test-toolkit.git;protocol=ssh;branch=main; \
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

SYSTEMD_SERVICE:${PN} = "ref_unit.service ref_unit_setup.service monitor_connections.service client_macaddress.service client.service"
RDEPENDS:${PN} = "bash"


do_install() {
	install -d ${D}${systemd_unitdir}
	install -d ${D}${systemd_unitdir}/system
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/ssh
	install -d ${D}/opt/hm/
	install -d ${D}/opt/hm/HostMobilityProductionTest
	install -d ${D}/opt/hm/HostMobilityProductionTestGUI
	install -d ${D}/opt/hm/HostMobilityProductionDatabaseClient
	install -d ${D}/opt/hm/HostMobilityProductionDatabaseClient/client_logs

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

	# install monitor connections 
	install -m 0644 ${WORKDIR}/git/HostMobilityProductionTestGUI/monitor_connections.service ${D}${systemd_unitdir}/system/monitor_connections.service
	install -m 0755 ${WORKDIR}/git/HostMobilityProductionTestGUI/monitor_connections.py ${D}/opt/hm/monitor_connections.py

	# install databse services
	install -m 0644 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/client.service ${D}${systemd_unitdir}/system/client.service
	install -m 0644 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/client_macaddress.service ${D}${systemd_unitdir}/system/client_macaddress.service
	install -m 0755 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/client.py ${D}/opt/hm/HostMobilityProductionDatabaseClient/client.py
	install -m 0755 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/client_macaddress.py ${D}/opt/hm/HostMobilityProductionDatabaseClient/client_macaddress.py
	install -m 0755 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/mobilityproduction_db.json ${D}/opt/hm/HostMobilityProductionDatabaseClient/mobilityproduction_db.json
	install -m 0755 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/production_tables.py ${D}/opt/hm/HostMobilityProductionDatabaseClient/production_tables.py

	# ssh config to allow none strict host access to DUT.
	install -m 0644 ${WORKDIR}/ref_unit_ssh_config ${D}${sysconfdir}/ssh/ref_unit_ssh_config

	cp -r ${WORKDIR}/git/HostMobilityProductionTest ${D}/opt/hm/
	cp -r ${WORKDIR}/git/HostMobilityProductionTestGUI ${D}/opt/hm/
}

FILES:${PN} = "\
    /opt/hm/ref_unit_setup.bash \
    /opt/hm/ref_unit.bash \
    /opt/hm/monitor_connections.py \
    ${systemd_unitdir}/system/ref_unit_setup.service \
    ${systemd_unitdir}/system/ref_unit.service \
    ${systemd_unitdir}/system/monitor_connections.service \
    ${systemd_unitdir}/system/client.service \
    ${systemd_unitdir}/system/client_macaddress.service \
    ${systemd_unitdir}/network/81-eth0.network \
    ${systemd_unitdir}/network/81-eth1.network \
    ${systemd_unitdir}/network/81-eth2.network \
    ${systemd_unitdir}/network/81-eth3.network \
    ${systemd_unitdir}/network/80-can.network \
	${sysconfdir}/ssh/ref_unit_ssh_config \
	/opt/hm/HostMobilityProductionTest \
	/opt/hm/HostMobilityProductionTestGUI \
	/opt/hm/HostMobilityProductionDatabaseClient/client.py \
	/opt/hm/HostMobilityProductionDatabaseClient/client_macaddress.py \
	/opt/hm/HostMobilityProductionDatabaseClient/mobilityproduction_db.json \
	/opt/hm/HostMobilityProductionDatabaseClient/production_tables.py \
	/opt/hm/HostMobilityProductionDatabaseClient/client_logs \
"