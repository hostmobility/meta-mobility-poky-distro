SUMMARY = "Test tool package group"
DESCRIPTION = "Packages useful for platform testing and validation"

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
    systemd-analyze \
    stress-ng \
"

