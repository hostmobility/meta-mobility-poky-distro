
SRCREV = "75873e431245ab96c3b5be51682834d12e0798bb"
SRC_URI = "gitsm://git@gitlab.com/hostmobility/test-toolkit.git;protocol=ssh;branch=main;"

inherit systemd

PV = "1.0"

DEPENDS = "virtual/kernel"

SYSTEMD_PACKAGES = "${PN}"

RDEPENDS:${PN} = "bash"

do_install:prepend() {
    install -d ${D}${systemd_unitdir}/system
}