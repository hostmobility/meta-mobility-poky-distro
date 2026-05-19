FILESEXTRAPATHS:prepend:imx-nxp-bsp := "${THISDIR}/${PN}:"

SRC_URI:append:imx-nxp-bsp = " \
    file://openssl-3.0-add-Kernel-TLS-configuration.patch \
"

EXTRA_OECONF:append:imx-nxp-bsp = " enable-ktls"