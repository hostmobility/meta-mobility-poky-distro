DESCRIPTION = "A demo image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
xfce desktop."


LICENSE = "MIT"

require mobility-image.bb

IMAGE_INSTALL:append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'packagegroup-xfce-base', '', d)} \
"

export IMAGE_BASENAME = "mobility-image-xfce"