SUMMARY = "A MINIMAL console-only image that fully supports the target device hardware."
inherit core-image

LICENSE = "MIT"

PV = "1"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp ;"

IMAGE_LINGUAS = "en-us"

IMAGE_FEATURES:append = " \
    ssh-server-openssh \
"

#For packagegroup-basic use this instead of sshdropbear
TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server openssh-misc"

IMAGE_INSTALL:append = " \
    packagegroup-core-boot \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    packagegroup-hostmobility-can \
    packagegroup-hostmobility-python \
    packagegroup-hostmobility-base \
    packagegroup-hostmobility-net-minimal \
    packagegroup-hostmobility-gps \
    packagegroup-hostmobility-net-extended \
    packagegroup-hostmobility-test-tools \
    ${TASK_BASIC_SSHDAEMON} \
"

# Include Mxv needed tools, that are audio packages. dfu-utils for reflash CAN controller fw.
IMAGE_INSTALL:append:mxv-base = " \
    packagegroup-imx-tools-audio \
    dfu-util \
"

# HMX needed tools. unclear if libiio is needed. ethtool is needed to setup T1 ethernet configuration.

IMAGE_INSTALL:append:imx8mp-var-dart = " \
    libiio \
    ethtool \
"

# HMM needed tools. unclear if libiio is needed. i2c-tool could be remove later on released product.
IMAGE_INSTALL:append:verdin-am62-hmm = " \
    dfu-util \
    libiio \
    i2c-tools \
"


IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"


IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "console-mobility-image"


TOOLCHAIN_TARGET_TASK:append = " kernel-devsrc"
