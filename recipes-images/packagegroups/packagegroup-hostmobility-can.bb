SUMMARY = "Control Area Network package group"
DESCRIPTION = "Package group bringing in packages that are needed when working with CAN on Linux"

inherit packagegroup

# disable sanity check for allarch packagegroup
PACKAGE_ARCH = ""

RDEPENDS:${PN} = " \
    can-utils \
    libsocketcan \
    iproute2 \
"

