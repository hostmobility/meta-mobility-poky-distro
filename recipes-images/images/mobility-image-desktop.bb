DESCRIPTION = "Simple desktop version with weston wayland based on mobility-image"


LICENSE = "MIT"

require mobility-image.bb


IMAGE_INSTALL:append = " \
        ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston weston-init', '', d)} \
"

export IMAGE_BASENAME = "mobility-image-desktop"