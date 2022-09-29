DESCRIPTION = "A console-only image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
test and benchmark applications."


LICENSE = "MIT"

require console-hostmobility-image.bb

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
        ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'glmark2', '', d)} \
"

export IMAGE_BASENAME = "mobility-image"