SUMMARY = "Control Area Network package group"
DESCRIPTION = "Package group bringing in packages that are needed when working with CAN on Linux"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = " \
    can-utils \
    libsocketcan \
    iproute2 \
"

