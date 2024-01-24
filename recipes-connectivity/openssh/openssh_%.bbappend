#
# Recipe for installing a static openssh rsa host key
#

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# I generated these on my host and copied here using ssh-keygen
SRC_URI:append = " \
    file://ssh_host_rsa_key \
    file://ssh_host_rsa_key.pub \
"

do_install:append() {
    install -d ${D}${sysconfdir}/ssh
    install -m 0600 ${WORKDIR}/ssh_host_rsa_key ${D}${sysconfdir}/ssh/ssh_host_rsa_key
    install -m 0600 ${WORKDIR}/ssh_host_rsa_key.pub ${D}${sysconfdir}/ssh/ssh_host_rsa_key.pub
}

FILES:${PN} += " \
    ${sysconfdir}/ssh/ssh_host_rsa_key \
    ${sysconfdir}/ssh/ssh_host_rsa_key.pub \
"
