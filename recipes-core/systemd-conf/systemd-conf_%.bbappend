FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# introduce a wlan0 network unit so it connects automatically
SRC_URI += " \
    file://wlan0.network \
"

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/wlan0.network \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/wlan0.network ${D}${sysconfdir}/systemd/network
}
