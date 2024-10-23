SUMMARY = "Host Mobility base package group"
DESCRIPTION = "Package group base applications"


inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = " \
    libgpiod-tools \
    minicom \
    lrzsz \
    lmsensors-sensors \
    hdparm \
    opkg \
    opkg-utils \
    distro-feed-configs \
    fbtest \
    openssl-engines \
    htop \
    make \
    cpufrequtils \
    tzdata \
    usb-rndis-systemd \
    sudo \
"

