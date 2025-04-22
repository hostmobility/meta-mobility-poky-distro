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
    packagegroup-hostmobility-test-tools \
    udev-extra-rules \
    ${ROOTFS_PKGMANAGE_PKGS} \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    packagegroup-core-full-cmdline-utils \
    ${TASK_BASIC_SSHDAEMON} \
"

# Include Mxv needed tools, that are audio packages. dfu-utils for reflash CAN controller fw.
IMAGE_INSTALL:append:mxv-base = " \
    packagegroup-imx-tools-audio \
    dfu-util \
"

# HMX needed tools. unclear if libiio is needed. ethtool is needed to setup T1 ethernet configuration.
# TODO move and rename mx5-platform-version (package from hm-commercial) to be a machine feature in bsp layer
IMAGE_INSTALL:append:imx8mp-var-dart = " \
    libiio \
    ethtool \
"

# HMM needed tools. unclear if libiio is needed. i2c-tool could be remove later on released product.
# TODO move and rename mx5-platform-version (package from hm-commercial) to be a machine feature in bsp layer
IMAGE_INSTALL:append:verdin-am62-hmm = " \
    dfu-util \
    libiio \
    i2c-tools \
    systemd-analyze \
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
