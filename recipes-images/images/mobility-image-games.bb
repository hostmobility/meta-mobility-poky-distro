DESCRIPTION = "Demo image with games and glmark based on mobility-image-desktop, \
Require layers in your bblayer.conf to work: \
    meta-openembedded/meta-filesystems \
    meta-qt5 \
    meta-games \
    meta-game-emulators \
"
IMAGE_FEATURES += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base', \
                                                       '', d), d)} \
"

LICENSE = "MIT"

require mobility-image-desktop.bb


IMAGE_INSTALL:append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'glmark2', '', d)} \                         
    packagegroup-core-buildessential\
    neverball \
    neverball-data \
    mednafen \
    freeciv \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', \
                         'weston-xwayland xterm supertuxkart supertux2 maelstrom', '', d)} \
"

export IMAGE_BASENAME = "mobility-image-games"