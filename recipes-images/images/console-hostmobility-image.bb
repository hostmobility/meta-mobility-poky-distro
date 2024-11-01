SUMMARY = "Image booting to a console"

LICENSE = "MIT"

PV = "1"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp ;"

IMAGE_LINGUAS = "en-us"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@oe.utils.conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

IMAGE_FEATURES:append = " \
    debug-tweaks \
    ssh-server-openssh \
"

#For packagegroup-basic use this instead of sshdropbear
TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server openssh-misc"

IMAGE_INSTALL:append = " \
    packagegroup-base \
    packagegroup-hostmobility-can \
    packagegroup-hostmobility-python \
    packagegroup-hostmobility-base \
    packagegroup-hostmobility-net-minimal \
    packagegroup-hostmobility-gps \
    packagegroup-hostmobility-net-extended \
    udev-extra-rules \
    ${ROOTFS_PKGMANAGE_PKGS} \
    minicom \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    fs-init \
    packagegroup-core-full-cmdline-utils \
    ${TASK_BASIC_SSHDAEMON} \
"

IMAGE_INSTALL:append:mxv-base = " \
    packagegroup-imx-tools-audio \
    ntpdate \
    dfu-util \
"


IMAGE_INSTALL:append:imx8mp-var-dart = " \
    libiio \
    curl \
    iperf3 \
    tmux \
    ethtool \
    nfs-utils-client \
    mx5-platform-version \
"

IMAGE_INSTALL:append:verdin-am62-hmm = " \
    dfu-util \
    tmux \
    curl \
    iperf3 \
    bbk-cli \
    mx5-platform-version \
    nfs-utils-client \
    libiio \
    i2c-tools \
    mmc-utils \
"



# This variscite bbappend disables systemd-networkd and systemd-resolved.
# We want to have these so we mask this out.
BBMASK = "meta-variscite-imx/recipes-core/systemd/systemd_%.bbappend"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "console-hostmobility-image"

inherit core-image

TOOLCHAIN_TARGET_TASK:append = " kernel-devsrc"
