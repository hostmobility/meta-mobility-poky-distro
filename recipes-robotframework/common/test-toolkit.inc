
SRCREV = "8b9f07d1ced7a55b7497829f985dbb43db3058d6"
SRC_URI = "gitsm://git@gitlab.com/hostmobility/test-toolkit.git;protocol=ssh;branch=main;"

inherit systemd

PV = "1.0"

DEPENDS = "virtual/kernel"

SYSTEMD_PACKAGES = "${PN}"

RDEPENDS:${PN} = "bash"

do_install:prepend() {
    install -d ${D}${systemd_unitdir}/system
}