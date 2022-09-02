DESCRIPTION = "A console-only image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
test and benchmark applications."


LICENSE = "MIT"

require console-hostmobility-image.bb

IMAGE_FEATURES:append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base', \
                                                       '', d), d)} \
"

X11TOOLS = "\
    x11perf \
    xrestop \
    xwininfo \
    xprop \
"

IMAGE_INSTALL:append = " \
    packagegroup-hostmobility-net-extended \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-tools-gpu \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', "${X11TOOLS}", "", d)} \
"

export IMAGE_BASENAME = "mobility-image"