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
    ref-unit-network \
    ref-unit-setup \
    uuu \
    packagegroup-hostmobility-printer \
    rsync \
    git \
    dnsmasq \
    zile \
    dfu-util \
    starve-backend \
    starve-frontend \
"

inherit extrausers

GROUPADD_PARAM:${PN} = " \
    -g 100 users; \
    -g 27 sudo; \
"

# jenkinsuser pwd: 'openssl passwd -6 pwd' generated passwd.
EXTRA_USERS_PARAMS = "\
    useradd -p '\$6\$xbyTOQbMo3y6g/Bu\$KGmgF3.wOVWjaCfVrBC6y.F/aFXmihK2lA0/CrjzprbEdt6YN6LlemfkVBccB/4WSGhMUXDcX6m/r3Tcmbzmq.' -s /bin/sh -G sudo,users,dialout jenkinsuser; \
"

export IMAGE_BASENAME = "console-image-robotframework"

# Change distro feed to special robotframework image for production
