SUMMARY = "Host Mobility base package group"
DESCRIPTION = "Package group base applications"


inherit packagegroup

# disable sanity check for allarch packagegroup
PACKAGE_ARCH = ""


RDEPENDS:${PN} = " \
    libgpiod \
    libgpiod-tools \
    minicom \
    libssl \
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
"

