
SRCREV = "c9fef06215fb15b4fc9cd08dd6912a7e8b3a09d2"
SRC_URI = "gitsm://git@gitlab.com/hostmobility/test-toolkit.git;protocol=ssh;branch=main;"

inherit systemd

PV = "1.0"

DEPENDS = "virtual/kernel"

SYSTEMD_PACKAGES = "${PN}"

RDEPENDS:${PN} = "bash"

do_install:prepend() {
    install -d ${D}${systemd_unitdir}/system
}