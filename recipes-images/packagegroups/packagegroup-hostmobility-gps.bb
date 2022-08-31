SUMMARY = "GNSS package group"
DESCRIPTION = "Package group bringing in packages needed to support \
Global Navigation Satellite Systems (GNSS)"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = " \
    gpsd \
    gps-utils \
    "

