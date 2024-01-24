DESCRIPTION = "Openwrt backported WLAN drivers."
SECTION = "Openwrt drivers."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PKG_VERSION = "5.15.81"
PKG_RELEASE = "1"
REVISION = "r5671-c5ca1c9"

SRC_URI[sha256sum] = "8d84d1dc1b424d2f2df3afffaca0635023d345c4671562292aca414ab819b433"

SRC_URI = " \
	https://cdn.kernel.org/pub/linux/kernel/projects/backports/stable/v${PKG_VERSION}/backports-${PKG_VERSION}-${PKG_RELEASE}.tar.gz \
	file://.config \
	file://patches/build/000-fix_kconfig.patch \
	file://patches/build/001-fix_build.patch \
	file://patches/build/002-change_allconfig.patch \
	file://patches/build/003-remove_bogus_modparams.patch \
	file://patches/build/012-kernel_build_check.patch \
	file://patches/build/015-ipw200-mtu.patch \
	file://patches/build/050-lib80211_option.patch \
	file://patches/build/060-no_local_ssb_bcma.patch \
	file://patches/subsys/110-mac80211_keep_keys_on_stop_ap.patch \
	file://patches/subsys/120-cfg80211_allow_perm_addr_change.patch \
	file://patches/subsys/150-disable_addr_notifier.patch \
	file://patches/subsys/210-ap_scan.patch \
	file://patches/subsys/301-mac80211-sta-randomize-BA-session-dialog-token-alloc.patch \
	file://patches/subsys/303-mac80211-set-up-the-fwd_skb-dev-for-mesh-forwarding.patch \
	file://patches/subsys/306-mac80211-use-coarse-boottime-for-airtime-fairness-co.patch \
	file://patches/subsys/307-mac80211_hwsim-make-6-GHz-channels-usable.patch \
	file://patches/subsys/308-mac80211-add-support-for-.ndo_fill_forward_path.patch \
	file://patches/subsys/309-mac80211-minstrel_ht-fix-MINSTREL_FRAC-macro.patch \
	file://patches/subsys/310-mac80211-minstrel_ht-reduce-fluctuations-in-rate-pro.patch \
	file://patches/subsys/311-mac80211-minstrel_ht-rework-rate-downgrade-code-and-.patch \
	file://patches/subsys/312-mac80211-split-beacon-retrieval-functions.patch \
	file://patches/subsys/313-nl80211-MBSSID-and-EMA-support-in-AP-mode.patch \
	file://patches/subsys/314-cfg80211-implement-APIs-for-dedicated-radar-detectio.patch \
	file://patches/subsys/315-cfg80211-move-offchan_cac_event-to-a-dedicated-work.patch \
	file://patches/subsys/316-cfg80211-fix-possible-NULL-pointer-dereference-in-cf.patch \
	file://patches/subsys/317-cfg80211-schedule-offchan_cac_abort_wk-in-cfg80211_r.patch \
	file://patches/subsys/318-cfg80211-allow-continuous-radar-monitoring-on-offcha.patch \
	file://patches/subsys/319-mac80211-introduce-set_radar_offchan-callback.patch \
	file://patches/subsys/320-cfg80211-rename-offchannel_chain-structs-to-backgrou.patch \
	file://patches/subsys/323-mac80211-MBSSID-support-in-interface-handling.patch \
	file://patches/subsys/324-mac80211-MBSSID-beacon-handling-in-AP-mode.patch \
	file://patches/subsys/325-mac80211-MBSSID-channel-switch.patch \
	file://patches/subsys/326-mac80211-update-bssid_indicator-in-ieee80211_assign_.patch \
	file://patches/subsys/328-mac80211-do-not-wake-queues-on-a-vif-that-is-being-s.patch \
	file://patches/subsys/330-mac80211-switch-airtime-fairness-back-to-deficit-rou.patch \
	file://patches/subsys/331-mac80211-make-sta-airtime-deficit-field-s32-instead-.patch \
	file://patches/subsys/332-mac80211-consider-aql_tx_pending-when-checking-airti.patch \
	file://patches/subsys/333-mac80211-keep-recently-active-tx-queues-in-schedulin.patch \
	file://patches/subsys/334-mac80211-add-a-per-PHY-AQL-limit-to-improve-fairness.patch \
	file://patches/subsys/335-mac80211-add-debugfs-file-to-display-per-phy-AQL-pen.patch \
	file://patches/subsys/336-mac80211-only-accumulate-airtime-deficit-for-active-.patch \
	file://patches/subsys/337-mac80211-increase-quantum-for-airtime-scheduler.patch \
	file://patches/subsys/339-mac80211-exclude-multicast-packets-from-AQL-pending-.patch \
	file://patches/subsys/340-wifi-mac80211-do-not-abuse-fq.lock-in-ieee80211_do_s.patch \
	file://patches/subsys/341-mac80211-Fix-deadlock-Don-t-start-TX-while-holding-f.patch \
	file://patches/subsys/342-mac80211-Ensure-vif-queues-are-operational-after-sta.patch \
	file://patches/subsys/343-wifi-mac80211-fix-decap-offload-for-stations-on-AP_V.patch \
	file://patches/subsys/344-wifi-cfg80211-fix-ieee80211_data_to_8023_exthdr-hand.patch \
	file://patches/subsys/345-wifi-mac80211-do-not-drop-packets-smaller-than-the-L.patch \
	file://patches/subsys/346-v6.0-wifi-mac80211-fix-mesh-airtime-link-metric-estimatin.patch \
	file://patches/subsys/400-allow-ibss-mixed.patch \
	file://patches/subsys/500-mac80211_configure_antenna_gain.patch \
	file://patches/subsys/782-net-next-1-of-net-pass-the-dst-buffer-to-of_get_mac_address.patch \
	file://patches/ath/070-ath_common_config.patch \
	file://patches/ath/400-ath_move_debug_code.patch \
	file://patches/ath/402-ath_regd_optional.patch \
	file://patches/ath/403-world_regd_fixup.patch \
	file://patches/ath/404-regd_no_assoc_hints.patch \
	file://patches/ath/405-ath_regd_us.patch \
	file://patches/ath/406-ath_relax_default_regd.patch \
	file://patches/ath/431-add_platform_eeprom_support_to_ath5k.patch \
	file://patches/ath5k/201-ath5k-WAR-for-AR71xx-PCI-bug.patch \
	file://patches/ath5k/411-ath5k_allow_adhoc_and_ap.patch \
	file://patches/ath5k/420-ath5k_disable_fast_cc.patch \
	file://patches/ath5k/430-add_ath5k_platform.patch \
	file://patches/ath5k/432-ath5k_add_pciids.patch \
	file://patches/ath5k/440-ath5k_channel_bw_debugfs.patch \
	file://patches/ath9k/040-ath9k-support-DT-ieee80211-freq-limit-property-to-li.patch \
	file://patches/ath9k/350-ath9k_hw-reset-AHB-WMAC-interface-on-AR91xx.patch \
	file://patches/ath9k/351-ath9k_hw-issue-external-reset-for-QCA955x.patch \
	file://patches/ath9k/354-ath9k-force-rx_clear-when-disabling-rx.patch \
	file://patches/ath9k/356-Revert-ath9k-interpret-requested-txpower-in-EIRP-dom.patch \
	file://patches/ath9k/365-ath9k-adjust-tx-power-reduction-for-US-regulatory-do.patch \
	file://patches/ath9k/401-ath9k_blink_default.patch \
	file://patches/ath9k/410-ath9k_allow_adhoc_and_ap.patch \
	file://patches/ath9k/450-ath9k-enabled-MFP-capability-unconditionally.patch \
	file://patches/ath9k/500-ath9k_eeprom_debugfs.patch \
	file://patches/ath9k/501-ath9k_ahb_init.patch \
	file://patches/ath9k/510-ath9k_intr_mitigation_tweak.patch \
	file://patches/ath9k/511-ath9k_reduce_rxbuf.patch \
	file://patches/ath9k/512-ath9k_channelbw_debugfs.patch \
	file://patches/ath9k/513-ath9k_add_pci_ids.patch \
	file://patches/ath9k/530-ath9k_extra_leds.patch \
	file://patches/ath9k/531-ath9k_extra_platform_leds.patch \
	file://patches/ath9k/540-ath9k_reduce_ani_interval.patch \
	file://patches/ath9k/542-ath9k_debugfs_diag.patch \
	file://patches/ath9k/543-ath9k_entropy_from_adc.patch \
	file://patches/ath9k/544-ath9k-ar933x-usb-hang-workaround.patch \
	file://patches/ath9k/545-ath9k_ani_ws_detect.patch \
	file://patches/ath9k/547-ath9k_led_defstate_fix.patch \
	file://patches/ath9k/548-ath9k_enable_gpio_chip.patch \
	file://patches/ath9k/549-ath9k_enable_gpio_buttons.patch \
	file://patches/ath9k/551-ath9k_ubnt_uap_plus_hsr.patch \
	file://patches/ath9k/552-ath9k-ahb_of.patch \
	file://patches/ath9k/553-ath9k_of_gpio_mask.patch \
	file://patches/ath9k/600-v5.16-ath9k-fetch-calibration-data-via-nvmem-subsystem.patch \
	file://patches/ath9k/601-v5.16-ath9k-owl-loader-fetch-pci-init-values-through-nvmem.patch \
	file://patches/ath10k/080-ath10k_thermal_config.patch \
	file://patches/ath10k/100-ath10k-support-bus-and-device-specific-API-1-BDF-sel.patch \
	file://patches/ath10k/120-ath10k-fetch-calibration-data-via-nvmem-subsystem.patch \
	file://patches/ath10k/921-ath10k_init_devices_synchronously.patch \
	file://patches/ath10k/930-ath10k_add_tpt_led_trigger.patch \
	file://patches/ath10k/974-ath10k_add-LED-and-GPIO-controlling-support-for-various-chipsets.patch \
	file://patches/ath10k/975-ath10k-use-tpt-trigger-by-default.patch \
	file://patches/ath10k/981-ath10k-adjust-tx-power-reduction-for-US-regulatory-d.patch \
	file://patches/ath10k/984-ath10k-Try-to-get-mac-address-from-dts.patch \
	file://patches/ath10k/990-ath10k-small-buffers.patch \
	file://patches/rt2x00/001-rt2x00-define-RF5592-in-init_eeprom-routine.patch \
	file://patches/rt2x00/002-rt2x00-add-throughput-LED-trigger.patch \
	file://patches/rt2x00/003-rt2x00-add-support-for-external-PA-on-MT7620.patch \
	file://patches/rt2x00/004-rt2x00-move-up-and-reuse-busy-wait-functions.patch \
	file://patches/rt2x00/005-rt2x00-add-RF-self-TXDC-calibration-for-MT7620.patch \
	file://patches/rt2x00/006-rt2x00-add-r-calibration-for-MT7620.patch \
	file://patches/rt2x00/007-rt2x00-add-RXDCOC-calibration-for-MT7620.patch \
	file://patches/rt2x00/008-rt2x00-add-RXIQ-calibration-for-MT7620.patch \
	file://patches/rt2x00/010-rt2x00-add-TX-LOFT-calibration-for-MT7620.patch \
	file://patches/rt2x00/011-rt2x00-move-helper-functions-up-in-file.patch \
	file://patches/rt2x00/012-rt2x00-fix-HT20-HT40-bandwidth-switch-on-MT7620.patch \
	file://patches/rt2x00/100-rt2x00_options.patch \
	file://patches/rt2x00/501-rt2x00-allow-to-build-rt2800soc-module-for-RT3883.patch \
	file://patches/rt2x00/601-rt2x00-introduce-rt2x00_platform_h.patch \
	file://patches/rt2x00/602-rt2x00-introduce-rt2x00eeprom.patch \
	file://patches/rt2x00/603-rt2x00-of_load_eeprom_filename.patch \
	file://patches/rt2x00/604-rt2x00-load-eeprom-on-SoC-from-a-mtd-device-defines-.patch \
	file://patches/rt2x00/606-rt2x00-allow_disabling_bands_through_platform_data.patch \
	file://patches/rt2x00/607-rt2x00-add_platform_data_mac_addr.patch \
	file://patches/rt2x00/608-rt2x00-allow_disabling_bands_through_dts.patch \
	file://patches/rt2x00/609-rt2x00-make-wmac-loadable-via-OF-on-rt288x-305x-SoC.patch \
	file://patches/rt2x00/610-rt2x00-change-led-polarity-from-OF.patch \
	file://patches/rt2x00/611-rt2x00-add-AP+STA-support.patch \
	file://patches/rt2x00/994-rt2x00-import-support-for-external-LNA-on-MT7620.patch \
	file://patches/rt2x00/995-rt2x00-mt7620-introduce-accessors-for-CHIP_VER-register.patch \
	file://patches/rt2x00/996-rt2x00-mt7620-differentiate-based-on-SoC-CHIP_VER.patch \
	file://patches/mwl/700-mwl8k-missing-pci-id-for-WNR854T.patch \
	file://patches/mwl/801-libertas-configure-sysfs-links.patch \
	file://patches/mwl/802-libertas-set-wireless-macaddr.patch \
	file://patches/mwl/940-mwl8k_init_devices_synchronously.patch \
	file://patches/brcm/040-brcmutil_option.patch \
	file://patches/brcm/810-b43-gpio-mask-module-option.patch \
	file://patches/brcm/811-b43_no_pio.patch \
	file://patches/brcm/812-b43-add-antenna-control.patch \
	file://patches/brcm/813-b43-reduce-number-of-RX-slots.patch \
	file://patches/brcm/814-b43-only-use-gpio-0-1-for-led.patch \
	file://patches/brcm/815-b43-always-take-overlapping-devs.patch \
	file://patches/brcm/850-brcmsmac-remove-extra-regulation-restriction.patch \
	file://patches/brcm/860-brcmfmac-register-wiphy-s-during-module_init.patch \
	file://patches/brcm/861-brcmfmac-workaround-bug-with-some-inconsistent-BSSes.patch \
	file://patches/brcm/862-brcmfmac-Disable-power-management.patch \
	file://patches/brcm/863-brcmfmac-add-in-driver-tables-with-country-codes.patch \
	file://patches/brcm/864-brcmfmac-do-not-use-internal-roaming-engine-by-default.patch \
	file://patches/brcm/998-survey.patch \
"

S = "${WORKDIR}/backports-${PKG_VERSION}-${PKG_RELEASE}"

DEPENDS = "kconf-native"

inherit module

do_configure() {
	rm -rf \
		${S}/include/linux/ssb \
		${S}/include/linux/bcma \
		${S}/include/net/bluetooth

	rm -f \
		${S}/include/linux/cordic.h \
		${S}/include/linux/crc8.h \
		${S}/include/linux/eeprom_93cx6.h \
		${S}/include/linux/wl12xx.h \
		${S}/include/linux/spi/libertas_spi.h \
		${S}/include/net/ieee80211.h \
		${S}/backport-include/linux/bcm47xx_nvram.h

	echo 'compat-wireless-${PKG_VERSION}-1-${PKG_RELEASE}-${REVISION}' > ${S}/compat_version

	### cmp ${S}/include/linux/ath9k_platform.h ${STAGING_KERNEL_DIR}/include/linux/ath9k_platform.h
	### cmp ${S}/include/linux/ath5k_platform.h ${STAGING_KERNEL_DIR}/include/linux/ath5k_platform.h
	### cmp ${S}/include/linux/rt2x00_platform.h ${STAGING_KERNEL_DIR}/include/linux/rt2x00_platform.h

	cp ${WORKDIR}/.config ${S}
	cp `which mconf` ${S}/kconf
	cp `which conf` ${S}/kconf
}

EXTRA_OEMAKE = "V=1 KLIB_BUILD=${STAGING_KERNEL_BUILDDIR} \
                KLIB=${base_libdir}/modules/${KERNEL_VERSION} \
		"

DEPENDS += "coreutils-native"

inherit module

MAKE_TARGETS = "modules"

FILES_${PN} += "${nonarch_base_libdir}/udev \
                ${sysconfdir}/udev \
		${nonarch_base_libdir} \
               "

EXCLUDE_FROM_WORLD = "1"


