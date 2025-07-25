SUMMARY = "Tools for Hostmobility Production ref units"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-robotframework/common/test-toolkit.inc

SRC_URI += " \
    file://ref_unit_setup.bash \
    file://ref_unit_setup.service \
    file://ref_unit.bash \
    file://ref_opkg_update.bash \
    file://ref_opkg_update.service \
    file://set_psu.bash \
"
RDEPENDS:${PN} += "ref-unit-network"

SYSTEMD_SERVICE:${PN} = "ref_unit_setup.service client_macaddress.service client.service ref_opkg_update.service"


do_install() {
    install -d ${D}/opt/hm/HostMobilityProductionDatabaseClient/client_logs

    # install and disable configurations in ref
    install -m 0644 ${WORKDIR}/ref_unit_setup.service ${D}${systemd_unitdir}/system/ref_unit_setup.service
    install -m 0755 ${WORKDIR}/ref_unit_setup.bash ${D}/opt/hm/ref_unit_setup.bash
    install -m 0755 ${WORKDIR}/ref_unit.bash ${D}/opt/hm/ref_unit.bash
    install -m 0755 ${WORKDIR}/set_psu.bash ${D}/opt/hm/set_psu.bash

    # opkg update and upgrade during start
    install -m 0644 ${WORKDIR}/ref_opkg_update.service ${D}${systemd_unitdir}/system/ref_opkg_update.service
	install -m 0755 ${WORKDIR}/ref_opkg_update.bash ${D}/opt/hm/ref_opkg_update.bash

    # install database services
    install -m 0644 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/client.service ${D}${systemd_unitdir}/system/client.service
    install -m 0644 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/client_macaddress.service ${D}${systemd_unitdir}/system/client_macaddress.service
    install -m 0755 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/client.py ${D}/opt/hm/HostMobilityProductionDatabaseClient/client.py
    install -m 0755 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/client_macaddress.py ${D}/opt/hm/HostMobilityProductionDatabaseClient/client_macaddress.py
    install -m 0755 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/mobilityproduction_db.json ${D}/opt/hm/HostMobilityProductionDatabaseClient/mobilityproduction_db.json
    install -m 0755 ${WORKDIR}/git/HostMobilityProductionDatabaseClient/production_tables.py ${D}/opt/hm/HostMobilityProductionDatabaseClient/production_tables.py

    cp -r --no-preserve=ownership ${WORKDIR}/git/HostMobilityProductionTest ${D}/opt/hm/
    cp -r --no-preserve=ownership ${WORKDIR}/git/test-tools ${D}/opt/hm/
}

FILES:${PN} = "\
    /opt/hm/ref_unit_setup.bash \
    /opt/hm/ref_unit.bash \
    /opt/hm/ref_opkg_update.bash \
    /opt/hm/set_psu.bash \
    ${systemd_unitdir}/system/ref_unit_setup.service \
    ${systemd_unitdir}/system/ref_opkg_update.service \
    ${systemd_unitdir}/system/client.service \
    ${systemd_unitdir}/system/client_macaddress.service \
    /opt/hm/HostMobilityProductionTest \
    /opt/hm/test-tools \
    /opt/hm/HostMobilityProductionDatabaseClient/client.py \
    /opt/hm/HostMobilityProductionDatabaseClient/client_macaddress.py \
    /opt/hm/HostMobilityProductionDatabaseClient/mobilityproduction_db.json \
    /opt/hm/HostMobilityProductionDatabaseClient/production_tables.py \
    /opt/hm/HostMobilityProductionDatabaseClient/client_logs \
"