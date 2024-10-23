SUMMARY = "Host Mobility base package group"
DESCRIPTION = "Package group base applications"


inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = " \
    python3 \
    python3-pip \
    python3-can \
    python3-pyserial \
"

