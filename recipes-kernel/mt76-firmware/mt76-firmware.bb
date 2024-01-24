DESCRIPTION = "Openwrt MT76 WLAN driver."
SECTION = "Openwrt WLAN drivers."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/openwrt/mt76.git;protocol=https;branch=openwrt-22.03;rev=7df5b451472176206eae36d7b316d7d2c039fd8c"

PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

#KERNEL_MODULE_AUTOLOAD += "kernel-module-backports kernel-module-mt76 kernel-module-mt7603e kernel-module-mt76x2e"

#EXTRA_OEMAKE += "NOSTDINC_FLAGS="-I${S} -I${STAGING_KERNEL_DIR}/usr/include/mac80211/uapi -I${STAGING_KERNEL_DIR}/usr/include/mac80211 -I${STAGING_KERNEL_DIR}/usr/include/mac80211/uapi -I${STAGING_KERNEL_DIR}/usr/include/mac80211""

do_configure() {
    bbwarn "not doing anything"
}

do_compile() {
    bbwarn "not doing anything"
}

do_install:append() {
	install -d ${D}/lib/firmware
	cp \
		${S}/firmware/mt7662_rom_patch.bin \
		${S}/firmware/mt7662.bin \
		${D}/lib/firmware

	cp \
		${S}/firmware/mt7628_e1.bin \
		${S}/firmware/mt7628_e2.bin \
		${S}/firmware/mt7603_e1.bin \
		${S}/firmware/mt7603_e2.bin \
		${D}/lib/firmware
}

FILES:${PN} = "/lib/*"
