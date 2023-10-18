SUMMARY = "Networking package group"
DESCRIPTION = "Package group bringing in packages for a minimal network manager framework"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = " \
    ppp \
"

