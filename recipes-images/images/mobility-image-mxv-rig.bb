DESCRIPTION = "A special internal image that includes chromium-ozone-wayland and features for robotframework and python3"


LICENSE = "MIT"

require mobility-image.bb

IMAGE_FEATURES += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base', \
                                                       '', d), d)} \
"

X11TOOLS = "\
    x11perf \
    xrestop \
    xwininfo \
    xprop \
"

inherit extrausers
EXTRA_USERS_PARAMS = " \
    useradd -p hmuser hmuser; \
    groupadd hmusers; \
    usermod -s /bin/sh hmuser; \
    useradd -g hmusers hmuser; \
    "


IMAGE_INSTALL:append = " \
    packagegroup-fsl-gstreamer1.0-full \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', "${X11TOOLS}", "", d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston weston-init chromium-ozone-wayland', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', \
                         'weston-xwayland xterm', '', d)} \
    packagegroup-hostmobility-robotframework \
    packagegroup-hostmobility-net-extended \
    glibc \
    libstdc++ \
    wget \
    curl \
    tmux \
    iperf3 \
    mxv-ref-unit-setup \
"

export IMAGE_BASENAME = "mobility-image-mxv-rig"