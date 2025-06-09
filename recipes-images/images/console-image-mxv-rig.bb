DESCRIPTION = "A special internal image for production rigs and regression (testing) rigs, it includes features for robotframework and python3, this image is similar to mobility-image-mxv-rig with the exception of having no chromium or related graphics features"

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

export IMAGE_BASENAME = "console-image-mxv-rig"