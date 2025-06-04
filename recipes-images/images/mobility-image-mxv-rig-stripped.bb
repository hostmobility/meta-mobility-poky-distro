DESCRIPTION = "A special internal image for mxv production and regression (testing) rigs, it includes features for robotframework and python3"

LICENSE = "MIT"

require console-hostmobility-image.bb

IMAGE_INSTALL:append = " \
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

export IMAGE_BASENAME = "mobility-image-mxv-rig-stripped"