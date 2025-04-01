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
    dfu-util \
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
DISTRO_FEED_URI:append = "https://hostmobility.org/robotframework-ref/Package-Manager-REF/${DISTRO}/${DISTRO_CODENAME}"
DISTRO_FEED_URI:remove = "https://hostmobility.org/${DISTRO}/${DISTRO_CODENAME}"
