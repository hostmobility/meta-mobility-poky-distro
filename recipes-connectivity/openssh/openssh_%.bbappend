# Add custom authorized_keys, ssh_config and sshd_config for host-insight.
#Add hostkey to allow login HOST_INSIGHT_PUBLIC_SSH_KEY export this variable to your enviorment before build start and target DISTRO=host-insight-poky .

FILESEXTRAPATHS:prepend := "${THISDIR}/host-insight-openssh:"


SRC_URI:append = " \
    file://host-insight-ssh_config \
    file://host-insight-sshd_config \
"

do_install:append:host-insight-poky() {
        echo "${HOST_INSIGHT_PUBLIC_SSH_KEY}" > ${D}${sysconfdir}/ssh/authorized_keys
        install -m 0644 ${WORKDIR}/host-insight-ssh_config ${D}${sysconfdir}/ssh/ssh_config
        install -m 0644 ${WORKDIR}/host-insight-sshd_config ${D}${sysconfdir}/ssh/sshd_config
}

FILES_${PN} += "\
${sysconfdir}/ssh/authorized_keys \
"