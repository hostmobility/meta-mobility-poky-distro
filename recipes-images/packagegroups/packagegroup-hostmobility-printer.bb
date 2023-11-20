SUMMARY = "Printer package group"
DESCRIPTION = "Package group bringing in packages for printer configuration and drivers"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = " \
    cups \
    cups-filters \
    gutenprint \
    qpdf \
"