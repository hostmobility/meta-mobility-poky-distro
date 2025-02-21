SUMMARY = "Host Mobility base package group"
DESCRIPTION = "Package group base applications"


inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = " \
    libgpiod-tools \
    minicom \
    lrzsz \
    lmsensors \
    opkg \
    opkg-utils \
    distro-feed-configs \
    openssl-engines \
    htop \
    cpufrequtils \
    tzdata \
    usb-rndis-systemd \
    sudo \
    fs-init \
"

