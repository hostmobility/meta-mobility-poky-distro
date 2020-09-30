SUMMARY = "Docker package group"
DESCRIPTION = "Add support for docker"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = " \
    docker \
    "

