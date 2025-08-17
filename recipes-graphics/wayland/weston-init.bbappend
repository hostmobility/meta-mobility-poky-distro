# Install custom weston_chromium.ini that add two icons with chromium one in kisk mode and other normal.
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://weston_chromium.ini"

# Ensure the correct destination path for weston.ini in the image
do_install:append() {
    install -d ${D}${sysconfdir}/xdg/weston/
    install -m 0644 ${WORKDIR}/weston_chromium.ini ${D}${sysconfdir}/xdg/weston/weston.ini
}