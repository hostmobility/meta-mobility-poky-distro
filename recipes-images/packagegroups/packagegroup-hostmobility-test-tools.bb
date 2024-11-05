SUMMARY = "Test tool package group"
DESCRIPTION = "Package group bringing in packages, that is used to validate the platform"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = " \
    hdparm \
    fbtest \
    make \
    curl \
    iperf3 \
    tmux \
    nfs-utils-client \
    bbk-cli \
    mmc-utils \
"

