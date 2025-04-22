DESCRIPTION="Starve backend setup for Hostmobility Production ref units"
LICENSE="CLOSED"

require recipes-robotframework/common/revision.inc

SRC_URI += " \
    file://starve_backend_env \
    file://starve_backend.service \
    file://starve_rfr.service \
"

RDEPENDS:${PN} += "ref-unit-setup"

SYSTEMD_SERVICE:${PN} = "starve_backend.service starve_rfr.service"

do_install() {
    install -d ${D}/opt/hm/starve/backend
    install -d ${D}/opt/hm/starve/robotframework_relay

    # install starve backend
    install -m 0644 ${WORKDIR}/starve_backend.service ${D}${systemd_unitdir}/system/starve_backend.service
    install -m 0755 ${WORKDIR}/git/starve/backend/connections.py ${D}/opt/hm/starve/backend/connections.py
    install -m 0755 ${WORKDIR}/git/starve/backend/main.py ${D}/opt/hm/starve/backend/main.py
    install -m 0755 ${WORKDIR}/git/starve/backend/tester.py ${D}/opt/hm/starve/backend/tester.py
    install -m 0755 ${WORKDIR}/git/starve/backend/ws.py ${D}/opt/hm/starve/backend/ws.py
    install -m 0644 ${WORKDIR}/starve_backend_env ${D}/opt/hm/starve/backend/.env
    cp -r --no-preserve=ownership ${WORKDIR}/git/starve/backend/messages ${D}/opt/hm/starve/backend/

    # install starve robotframework relay
    install -m 0644 ${WORKDIR}/starve_rfr.service ${D}${systemd_unitdir}/system/starve_rfr.service
    install -m 0755 ${WORKDIR}/git/starve/robotframework_relay/main.py ${D}/opt/hm/starve/robotframework_relay/main.py
}

FILES:${PN} = " \
    ${systemd_unitdir}/system/ref_unit.service \
    ${systemd_unitdir}/system/starve_rfr.service \
    /opt/hm/starve \
"