DESCRIPTION = "A console-only image with Host Insight client preinstalled."


LICENSE = "MIT"

require console-hostmobility-image.bb

# Allow tty access
# TODO: make this work some other way.
IMAGE_FEATURES:append = "debug-tweaks"

IMAGE_INSTALL:append = " \
    packagegroup-hostmobility-net-extended \
    host-insight-client \
    host-insight-m \
    host-insight-helper \
"

export IMAGE_BASENAME = "host-insight-image"