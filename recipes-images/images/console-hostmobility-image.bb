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
TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server"

IMAGE_INSTALL:append = " \
    packagegroup-base \
    packagegroup-hostmobility-can \
    packagegroup-hostmobility-base \
    packagegroup-hostmobility-net-minimal \
    packagegroup-hostmobility-gps \
    udev-extra-rules \
    ${ROOTFS_PKGMANAGE_PKGS} \
    minicom \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    fs-init \
    packagegroup-core-full-cmdline-utils \
"

IMAGE_INSTALL:append:mxv-base = " \
    packagegroup-imx-tools-audio \
    ntpdate \
    dfu-util \
"


IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "console-hostmobility-image"

inherit core-image

