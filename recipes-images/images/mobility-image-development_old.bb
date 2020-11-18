DESCRIPTION = "A console-only image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
test and benchmark applications."

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-debug \
    tools-profile \
    splash \
    ssh-server-dropbear \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base', \
                                                       '', d), d)} \
"

LICENSE = "MIT"

inherit core-image

X11TOOLS = "\
    x11perf \
    xrestop \
    xwininfo \
    xprop \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-basic \
    packagegroup-base-extended \
    packagegroup-hostmobility-base \
    packagegroup-hostmobility-can \
    packagegroup-hostmobility-net-minimal \
    packagegroup-hostmobility-gps \
    packagegroup-hostmobility-net-extended \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-imx-tools-audio \
    packagegroup-fsl-tools-benchmark \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'v4l-utils', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'gtk+3-demo', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston-examples clutter-1.0-examples', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', "${X11TOOLS}", "", d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston weston-init', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', \
                         'weston-xwayland xterm', '', d)} \
"

CORE_IMAGE_EXTRA_INSTALL_append_mx6 += " \
    ntpdate \
    cryptodev-module \
    cryptodev-tests \
    rng-tools \
    uart-test \
    dfu-util \
"