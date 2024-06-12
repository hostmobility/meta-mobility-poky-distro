DESCRIPTION = "A console-only image robotframework."


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
    ref-unit-setup \
    uuu \
    packagegroup-hostmobility-printer \
    rsync \
    git \
    zile \
"

export IMAGE_BASENAME = "console-image-robotframework"