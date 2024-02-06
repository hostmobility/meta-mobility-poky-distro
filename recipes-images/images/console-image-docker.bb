DESCRIPTION = "A console-only image with docker support"


LICENSE = "MIT"

require console-hostmobility-image.bb


IMAGE_INSTALL:append = " \
    packagegroup-hostmobility-docker \
"

export IMAGE_BASENAME = "console-image-docker"