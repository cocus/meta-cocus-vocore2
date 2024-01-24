#
# Recipe for installing a custom wpa_supplicant configuration file
#

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://wpa_supplicant-wlan0.conf \
"

SYSTEMD_SERVICE:${PN} = "wpa_supplicant@wlan0.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install:append() {
    install -d ${D}${sysconfdir}/wpa_supplicant
    install -m 0600 ${WORKDIR}/wpa_supplicant-wlan0.conf ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf

    install -d ${D}/${systemd_system_unitdir}
    ln -s /${systemd_system_unitdir}/wpa_supplicant@.service ${D}/${systemd_system_unitdir}/wpa_supplicant@wlan0.service
}

FILES:${PN} += " \
    ${sysconfdir}/wpa-supplicant/wpa_supplicant-wlan0.conf \
    ${systemd_system_unitdir}/wpa_supplicant@wlan0.service \
"
