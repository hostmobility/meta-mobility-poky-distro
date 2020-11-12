DESCRIPTION = "A console-only image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
test and benchmark applications."

IMAGE_FEATURES += " \
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
    packagegroup-fsl-tools-gpu \
    packagegroup-imx-tools-audio \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', "${X11TOOLS}", "", d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston weston-init', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', \
                         'weston-xwayland xterm', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', "packagegroup-xfce-base", "", d)} \
"

CORE_IMAGE_EXTRA_INSTALL_append_mx6 += " \
    ntpdate \
    cryptodev-module \
    rng-tools \
    uart-test \
    dfu-util \
"

PACKAGE_IMX_TO_REMOVE = ""
PACKAGE_IMX_TO_REMOVE_imxgpu2d = "clutter-1.0-examples gtk+3-demo"
PACKAGE_IMX_TO_REMOVE_imxgpu3d = ""

CORE_IMAGE_EXTRA_INSTALL_remove = "${PACKAGE_IMX_TO_REMOVE}"