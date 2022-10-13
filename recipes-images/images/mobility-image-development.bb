DESCRIPTION = "A console-only image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
test and benchmark applications."

IMAGE_FEATURES:append = " \
    tools-debug \
    tools-profile \
    splash \
"
require mobility-image-desktop.bb

IMAGE_INSTALL:append = " \
    packagegroup-base-extended \
    packagegroup-fsl-gstreamer1.0-full \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-imx-tools-audio \
    packagegroup-fsl-tools-benchmark \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston-examples clutter-1.0-examples', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston weston-init', '', d)} \
    python3-pip \
    python3-pyserial \
    curl \
"

export IMAGE_BASENAME = "mobility-image-development"
