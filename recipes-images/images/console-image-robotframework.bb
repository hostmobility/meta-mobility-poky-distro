DESCRIPTION = "A console-only image robotframework."


LICENSE = "MIT"

require console-hostmobility-image.bb


IMAGE_INSTALL:append = " \
    packagegroup-hostmobility-robotframework \
    packagegroup-hostmobility-net-extended \
    glibc \
    libstdc++ \
    libatomic1 \
    wget \
    curl \
    tmux \
    iperf3 \
"

export IMAGE_BASENAME = "console-image-robotframework"