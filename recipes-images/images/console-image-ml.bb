DESCRIPTION = "A console-only image with machine learning support"

LICENSE = "MIT"

require console-hostmobility-image.bb

IMAGE_INSTALL:append = " \
    packagegroup-variscite-imx-ml \
"

export IMAGE_BASENAME = "console-image-ml"
