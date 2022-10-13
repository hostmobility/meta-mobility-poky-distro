DESCRIPTION = "A console-only image with gstreamer and gpu packages."


LICENSE = "MIT"

require console-hostmobility-image.bb


IMAGE_INSTALL:append = " \
    packagegroup-hostmobility-net-extended \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-tools-gpu \
"

export IMAGE_BASENAME = "mobility-image"