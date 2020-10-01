DESCRIPTION = "A console-only image."

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-debug \
    tools-profile \
    splash \
    ssh-server-dropbear \
"

LICENSE = "MIT"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-basic \
    packagegroup-base-extended \
    packagegroup-hostmobility-base \
    packagegroup-hostmobility-can \
    packagegroup-hostmobility-net-minimal \
    packagegroup-hostmobility-gps \
    packagegroup-hostmobility-net-extended \
"

CORE_IMAGE_EXTRA_INSTALL_append_mx6 += " \
    ntpdate \
    cryptodev-module \
    cryptodev-tests \
    rng-tools \
    uart-test \
    dfu-util \
"


