SUMMARY = "Networking package group"
DESCRIPTION = "Package group bringing in packages for a more network manager framework"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = " \
    modemmanager \
    mobile-broadband-provider-info \
    wvdial \
"

