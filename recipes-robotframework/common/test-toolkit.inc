
SRCREV = "5a4dcb5d6b28d4bded2859574e45ccc247b63419"
SRC_URI = "gitsm://git@gitlab.com/hostmobility/test-toolkit.git;protocol=ssh;branch=main;"

inherit systemd

PV = "1.0"

DEPENDS = "virtual/kernel"

SYSTEMD_PACKAGES = "${PN}"

RDEPENDS:${PN} = "bash"

do_install:prepend() {
    install -d ${D}${systemd_unitdir}/system
}