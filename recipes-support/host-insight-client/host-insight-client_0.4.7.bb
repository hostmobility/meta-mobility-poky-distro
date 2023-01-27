SUMMARY = "A remote I/O client for GNU/Linux"
HOMEPAGE = "https://hostmobility.com"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://git@github.com/hostmobility/host-insight-client.git;protocol=ssh;branch=main;name=client \
           git://git@github.com/hostmobility/host-insight-proto.git;protocol=ssh;branch=main;destsuffix=git/proto;name=proto"

SRC_URI_client[md5sum] = "da0ebecd284d7f4afcfc226be2e648b6"
SRC_URI_client[sha256sum] = "0019f1ab11aa8364b17727a7b6916a8a07fad25aefe23c45d33d4d4db4f7b6f1"
SRCREV_client = "359719dfe37cc6888a06af16e82f05840627c1a3"

SRC_URI_proto[md5sum] = "da0ebecd284d7f4afcfc226be2e648b6"
SRC_URI_proto[sha256sum] = "0019f1ab11aa8364b17727a7b6916a8a07fad25aefe"
SRCREV_proto = "598ae5f292fa20d2d51edaf1ebd6e19547ba5b73"

SRCREV = "${SRCREV_client}"

DEPENDS = "protobuf-native protobuf"
RDEPENDS:${PN} = "curl"
CARGO_SRC_DIR = ""

S = "${WORKDIR}/git"

inherit cargo systemd

SRC_URI += " \
    crate://crates.io/anyhow/1.0.57 \
    crate://crates.io/async-channel/1.6.1 \
    crate://crates.io/async-executor/1.4.1 \
    crate://crates.io/async-global-executor/2.1.0 \
    crate://crates.io/async-io/1.7.0 \
    crate://crates.io/async-lock/2.6.0 \
    crate://crates.io/async-std/1.12.0 \
    crate://crates.io/async-stream-impl/0.3.3 \
    crate://crates.io/async-stream/0.3.3 \
    crate://crates.io/async-task/4.2.0 \
    crate://crates.io/async-trait/0.1.53 \
    crate://crates.io/atomic-waker/1.0.0 \
    crate://crates.io/atty/0.2.14 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/axum-core/0.2.9 \
    crate://crates.io/axum/0.5.17 \
    crate://crates.io/base64/0.13.0 \
    crate://crates.io/bitflags/0.4.0 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/blocking/1.2.0 \
    crate://crates.io/bumpalo/3.10.0 \
    crate://crates.io/bytes/1.1.0 \
    crate://crates.io/cache-padded/1.2.0 \
    crate://crates.io/can-dbc/5.0.0 \
    crate://crates.io/cc/1.0.73 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/clap/3.2.23 \
    crate://crates.io/clap_lex/0.2.4 \
    crate://crates.io/codegen/0.2.0 \
    crate://crates.io/concurrent-queue/1.2.2 \
    crate://crates.io/crossbeam-utils/0.8.8 \
    crate://crates.io/ctor/0.1.22 \
    crate://crates.io/derive-getters/0.2.0 \
    crate://crates.io/either/1.6.1 \
    crate://crates.io/event-listener/2.5.2 \
    crate://crates.io/fastrand/1.7.0 \
    crate://crates.io/fixedbitset/0.4.1 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/futures-channel/0.3.25 \
    crate://crates.io/futures-core/0.3.25 \
    crate://crates.io/futures-executor/0.3.25 \
    crate://crates.io/futures-io/0.3.25 \
    crate://crates.io/futures-lite/1.12.0 \
    crate://crates.io/futures-macro/0.3.25 \
    crate://crates.io/futures-sink/0.3.25 \
    crate://crates.io/futures-task/0.3.25 \
    crate://crates.io/futures-util/0.3.25 \
    crate://crates.io/futures/0.3.25 \
    crate://crates.io/getrandom/0.2.7 \
    crate://crates.io/gloo-timers/0.2.4 \
    crate://crates.io/gpio-cdev/0.5.1 \
    crate://crates.io/h2/0.3.13 \
    crate://crates.io/hashbrown/0.12.3 \
    crate://crates.io/heck/0.4.0 \
    crate://crates.io/hermit-abi/0.1.19 \
    crate://crates.io/hex/0.2.0 \
    crate://crates.io/home/0.5.4 \
    crate://crates.io/http-body/0.4.5 \
    crate://crates.io/http-range-header/0.3.0 \
    crate://crates.io/http/0.2.8 \
    crate://crates.io/httparse/1.7.1 \
    crate://crates.io/httpdate/1.0.2 \
    crate://crates.io/hyper-timeout/0.4.1 \
    crate://crates.io/hyper/0.14.19 \
    crate://crates.io/indexmap/1.9.1 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/itertools/0.10.3 \
    crate://crates.io/itertools/0.4.19 \
    crate://crates.io/itoa/1.0.2 \
    crate://crates.io/js-sys/0.3.58 \
    crate://crates.io/kv-log-macro/1.0.7 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/libc/0.2.138 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/matchit/0.5.0 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/memoffset/0.7.1 \
    crate://crates.io/mime/0.3.16 \
    crate://crates.io/minimal-lexical/0.2.1 \
    crate://crates.io/mio/0.8.4 \
    crate://crates.io/multimap/0.8.3 \
    crate://crates.io/nix/0.23.1 \
    crate://crates.io/nix/0.26.1 \
    crate://crates.io/nix/0.5.1 \
    crate://crates.io/nom/7.1.1 \
    crate://crates.io/num_cpus/1.13.1 \
    crate://crates.io/once_cell/1.12.0 \
    crate://crates.io/os_str_bytes/6.4.1 \
    crate://crates.io/parking/2.0.0 \
    crate://crates.io/percent-encoding/2.1.0 \
    crate://crates.io/petgraph/0.6.2 \
    crate://crates.io/pin-project-internal/1.0.12 \
    crate://crates.io/pin-project-lite/0.2.9 \
    crate://crates.io/pin-project/1.0.12 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/polling/2.2.0 \
    crate://crates.io/ppv-lite86/0.2.16 \
    crate://crates.io/prettyplease/0.1.11 \
    crate://crates.io/proc-macro2/1.0.47 \
    crate://crates.io/prost-build/0.11.4 \
    crate://crates.io/prost-derive/0.11.0 \
    crate://crates.io/prost-types/0.11.1 \
    crate://crates.io/prost/0.11.3 \
    crate://crates.io/quote/1.0.18 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.6.3 \
    crate://crates.io/redox_syscall/0.2.13 \
    crate://crates.io/regex-syntax/0.6.26 \
    crate://crates.io/regex/1.5.6 \
    crate://crates.io/remove_dir_all/0.5.3 \
    crate://crates.io/ring/0.16.20 \
    crate://crates.io/rustls-pemfile/1.0.0 \
    crate://crates.io/rustls/0.20.6 \
    crate://crates.io/sct/0.7.0 \
    crate://crates.io/serde/1.0.150 \
    crate://crates.io/serde_derive/1.0.150 \
    crate://crates.io/slab/0.4.6 \
    crate://crates.io/socket2/0.4.4 \
    crate://crates.io/socketcan/1.7.0 \
    crate://crates.io/spin/0.5.2 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/strsim/0.10.0 \
    crate://crates.io/syn/1.0.105 \
    crate://crates.io/sync_wrapper/0.1.1 \
    crate://crates.io/tempfile/3.3.0 \
    crate://crates.io/termcolor/1.1.3 \
    crate://crates.io/textwrap/0.16.0 \
    crate://crates.io/thiserror-impl/1.0.34 \
    crate://crates.io/thiserror/1.0.34 \
    crate://crates.io/tokio-io-timeout/1.2.0 \
    crate://crates.io/tokio-macros/1.7.0 \
    crate://crates.io/tokio-rustls/0.23.4 \
    crate://crates.io/tokio-socketcan/0.3.1 \
    crate://crates.io/tokio-stream/0.1.9 \
    crate://crates.io/tokio-util/0.7.3 \
    crate://crates.io/tokio/1.23.0 \
    crate://crates.io/toml/0.5.9 \
    crate://crates.io/tonic-build/0.8.4 \
    crate://crates.io/tonic/0.8.2 \
    crate://crates.io/tower-http/0.3.4 \
    crate://crates.io/tower-layer/0.3.2 \
    crate://crates.io/tower-service/0.3.1 \
    crate://crates.io/tower/0.4.13 \
    crate://crates.io/tracing-attributes/0.1.21 \
    crate://crates.io/tracing-core/0.1.27 \
    crate://crates.io/tracing-futures/0.2.5 \
    crate://crates.io/tracing/0.1.35 \
    crate://crates.io/try-lock/0.2.3 \
    crate://crates.io/try_from/0.2.2 \
    crate://crates.io/unicode-ident/1.0.0 \
    crate://crates.io/untrusted/0.7.1 \
    crate://crates.io/value-bag/1.0.0-alpha.9 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/waker-fn/1.1.0 \
    crate://crates.io/want/0.3.0 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.81 \
    crate://crates.io/wasm-bindgen-futures/0.4.31 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.81 \
    crate://crates.io/wasm-bindgen-macro/0.2.81 \
    crate://crates.io/wasm-bindgen-shared/0.2.81 \
    crate://crates.io/wasm-bindgen/0.2.81 \
    crate://crates.io/web-sys/0.3.57 \
    crate://crates.io/webpki/0.22.0 \
    crate://crates.io/wepoll-ffi/0.1.2 \
    crate://crates.io/which/4.2.5 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-sys/0.36.1 \
    crate://crates.io/windows-sys/0.42.0 \
    crate://crates.io/windows_aarch64_gnullvm/0.42.0 \
    crate://crates.io/windows_aarch64_msvc/0.36.1 \
    crate://crates.io/windows_aarch64_msvc/0.42.0 \
    crate://crates.io/windows_i686_gnu/0.36.1 \
    crate://crates.io/windows_i686_gnu/0.42.0 \
    crate://crates.io/windows_i686_msvc/0.36.1 \
    crate://crates.io/windows_i686_msvc/0.42.0 \
    crate://crates.io/windows_x86_64_gnu/0.36.1 \
    crate://crates.io/windows_x86_64_gnu/0.42.0 \
    crate://crates.io/windows_x86_64_gnullvm/0.42.0 \
    crate://crates.io/windows_x86_64_msvc/0.36.1 \
    crate://crates.io/windows_x86_64_msvc/0.42.0 \
"

BBCLASSEXTEND = "native"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "host-insight-client.service"

do_configure:prepend() {
    cd ${WORKDIR}/git
    git submodule update --init --recursive
}

do_install() {
    install -d ${D}/opt/host-insight-client
    install -d 755 ${D}/${sysconfdir}/opt/host-insight-client
    install -d ${D}${systemd_unitdir}/system

    install -m 755 ${B}/target/${TARGET_SYS}/release/host-insight-client ${D}/opt/host-insight-client/host-insight-client
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