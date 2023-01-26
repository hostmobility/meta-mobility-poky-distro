SUMMARY = "Host Mobility host insight package group"
DESCRIPTION = "Package group client and help applications for host insight"


inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = " \
    host-insight-client \
    host-insight-m \
    host-insight-helper \
"

