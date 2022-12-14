SUMMARY = "Host Mobility development package group"
DESCRIPTION = "Package group development applications. Includes development test tools \
                and compile and debug custom applications"


inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = " \
    packagegroup-core-buildessential \
    curl \
    gdb \
    gdbserver \
    packagegroup-sdk-target \
    ethtool \
    packagegroup-hostmobility-net-extended \
    pm-utils \
    systemd-analyze \
    hdparm \
    packagegroup-fsl-tools-benchmark \
    i2c-tools \
    memtester \
    stress \
    lmbench \
    nbench-byte \
    python3-pip \
    python3-pyserial \
"

