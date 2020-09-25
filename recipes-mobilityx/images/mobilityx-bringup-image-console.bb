DESCRIPTION = "A console-only image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
test and benchmark applications."

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-debug \
    tools-profile \
    splash \
    ssh-server-dropbear \
"

X11TOOLS = "\
    x11perf \
    xrestop \
    xwininfo \
    xprop \
"

CANTOOLS = "\
    can-utils \
    libsocketcan \
    iproute2 \
"

BRINGUP_TEST_APPS = "\
    cryptodev-module \
    cryptodev-tests \
    dfu-util \
    rng-tools \
    libssl \
    ntpdate \
    lrzsz \
    lmsensors-sensors \
"

LICENSE = "MIT"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-basic \
    packagegroup-base-extended \
    ${BRINGUP_TEST_APPS} \
    ${CANTOOLS} \
"
