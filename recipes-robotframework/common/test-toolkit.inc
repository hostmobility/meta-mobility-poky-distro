
SRCREV = "265944b5d428e8da36e851c1e2631a897f6142c4"
SRC_URI = "gitsm://git@gitlab.com/hostmobility/test-toolkit.git;protocol=ssh;branch=main;"

inherit systemd

PV = "1.0"

DEPENDS = "virtual/kernel"

SYSTEMD_PACKAGES = "${PN}"

RDEPENDS:${PN} = "bash"

do_install:prepend() {
    install -d ${D}${systemd_unitdir}/system
}