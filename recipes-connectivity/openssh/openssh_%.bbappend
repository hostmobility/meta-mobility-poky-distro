# Add custom authorized_keys, ssh_config and sshd_config for Host Insight.
# Add public key to authorized_keys to allow SSH login with tunneled passwords disabled.
# Edit this file before build start and target DISTRO=host-insight-poky.

FILESEXTRAPATHS:prepend := "${THISDIR}/host-insight-openssh:"


SRC_URI:append = " \
    file://host-insight-authorized_keys \
    file://host-insight-ssh_config \
    file://host-insight-sshd_config \
"

do_install:append:host-insight-poky() {
    install -m 0644 ${WORKDIR}/host-insight-authorized_keys ${D}${sysconfdir}/ssh/authorized_keys
    install -m 0644 ${WORKDIR}/host-insight-ssh_config ${D}${sysconfdir}/ssh/ssh_config
    install -m 0644 ${WORKDIR}/host-insight-sshd_config ${D}${sysconfdir}/ssh/sshd_config
}

FILES_${PN} += "\
    ${sysconfdir}/ssh/authorized_keys \
"