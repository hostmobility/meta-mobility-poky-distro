SUMMARY = "Host Mobility base package group"
DESCRIPTION = "Package group base applications"


inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = " \
    libgpiod \
    libgpiod-tools \
    minicom \
    libssl \
    lrzsz \
    lmsensors-sensors \
    python3-pip \
    python3-pyserial \
    hdparm \
    opkg \
    opkg-utils \
    distro-feed-configs \
    fbtest \
    openssl-engines \
    htop \
    make \
"

