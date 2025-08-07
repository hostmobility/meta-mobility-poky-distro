SUMMARY = "A remote I/O client for GNU/Linux"
HOMEPAGE = "https://hostmobility.com"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://git@github.com/hostmobility/host-insight-client.git;protocol=ssh;branch=main;name=client \
           gitsm://git@github.com/hostmobility/host-insight-proto.git;protocol=ssh;branch=main;destsuffix=git/proto;name=proto"

SRCREV_client = "b69202214d1358f159d359d0ee2d818c888b4739"
SRCREV_proto = "598ae5f292fa20d2d51edaf1ebd6e19547ba5b73"
SRCREV_FORMAT = "client_proto"

SRCREV = "${SRCREV_client}"
DEPENDS = "protobuf-native protobuf"
RDEPENDS:${PN} = "curl"

PV = "0.6.0"

S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""

inherit cargo cargo-update-recipe-crates systemd

require ${BPN}-crates.inc

BBCLASSEXTEND = "native"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "host-insight-client.service"

do_configure:prepend() {
    cd ${WORKDIR}/git
    git submodule update --init --recursive
}

do_install() {
    install -d ${D}/opt/host-insight-client
    install -d -m 755 ${D}/${sysconfdir}/opt/host-insight-client
    install -d ${D}${systemd_unitdir}/system

    install -m 755 ${B}/target/${RUST_TARGET_SYS}/release/host-insight-client ${D}/opt/host-insight-client/host-insight-client
    install -m 755 ${S}/scripts/exit-handler.sh ${D}/opt/host-insight-client/exit-handler.sh
    install -m 644 ${S}/scripts/conf-fallback.toml ${D}/${sysconfdir}/opt/host-insight-client/conf-fallback.toml
    install -m 644 ${S}/scripts/host-insight-client.service ${D}/${systemd_unitdir}/system/host-insight-client.service
}

FILES:${PN} = "/opt/host-insight-client/host-insight-client \
               /opt/host-insight-client/exit-handler.sh \
               ${sysconfdir}/opt/host-insight-client \
               ${sysconfdir}/opt/host-insight-client/conf-fallback.toml \
               ${systemd_system_unitdir}/host-insight-client.service \
               ${sysconfdir}/opt/host-insight-client"