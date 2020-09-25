DESCRIPTION = "A console-only image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
test and benchmark applications."

IMAGE_FEATURES += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base', \
                                                       '', d), d)} \
    debug-tweaks \
    tools-debug \
    tools-profile \
    splash \
    ssh-server-openssh \
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
    alsa-tools \
    alsa-utils \
    alsa-utils-amixer \
    alsa-utils-aplay \
    blktool \
    canutils \
    dosfstools \
    e2fsprogs-mke2fs \
    ethtool \
    evtest \
    fbset \
    gps-utils \
    gpsd \
    i2c-tools \
    iproute2 \
    iproute2 \
    libsocketcan \
    ltp \
    memtester \
    mtd-utils \
    python3-core \
    python3-datetime \
    python3-json \
    spitools \
    stress-ng \
    systemd-analyze \
    udev-extraconf \
    libgpiod \
    libgpiod-tools \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'v4l-utils', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'gtk+3-demo', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston-examples clutter-1.0-examples', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', "${X11TOOLS}", "", d)} \
"

LICENSE = "MIT"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-imx-tools-audio \
    packagegroup-fsl-tools-benchmark \
    ${BRINGUP_TEST_APPS} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston weston-init', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', \
                         'weston-xwayland xterm', '', d)} \
"
