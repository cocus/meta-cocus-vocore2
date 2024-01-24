inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# LINUX_VERSION ?= "5.15"
# LINUX_PATCH ?= "105"
LINUX_VERSION ?= "5.10"
LINUX_PATCH ?= "161"
KBRANCH="v${LINUX_VERSION}.${LINUX_PATCH}"

# always assign KERNEL_DTB_NAME appropriately in the kernel recipes
# either softer or lazy assignment only leading to MACHINE value to be
# something else than the intended MACHINE name.
# This requires further inverstigation
KERNEL_DTB_NAME ??= "mt7628an_vocore_vocore2"

KERNEL_UIMAGE ?= "uImage"
LINUX_VERSION_EXTENSION:append ?= "-yocto"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nobranch=1;rev=7b932a1b1ce872447d3bcd7716493b6c1661a90d"

#git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nobranch=1;rev=d3b6a0dfe1c572cf63f9e058c23d27fa617fc45b"

KERNEL_MODULE_AUTOLOAD += "cfg80211 mac80211 mt76 mt7603"

LIC_FILES_CHKSUM = " \
    file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46 \
"

SRC_URI += " \
    file://device-trees \
    file://sources \
"

SRC_URI += " \
    file://cfg/mt7628-vocore.cfg \
    file://cfg/mt7628.scc \
    file://cfg/mt7628-wifi-modules.cfg \
    file://defconfig \
"

SRC_URI += " \
    file://patches/backports/010-Kbuild-don-t-hardcode-path-to-awk-in-scripts-ld-vers.patch \
    file://patches/backports/011-kbuild-export-SUBARCH.patch \
    file://patches/backports/026-power-reset-linkstation-poweroff-add-missing-put_dev.patch \
    file://patches/backports/050-v5.16-00-MIPS-uasm-Enable-muhu-opcode-for-MIPS-R6.patch \
    file://patches/backports/050-v5.16-01-mips-uasm-Add-workaround-for-Loongson-2F-nop-CPU-err.patch \
    file://patches/backports/050-v5.16-02-mips-bpf-Add-eBPF-JIT-for-32-bit-MIPS.patch \
    file://patches/backports/050-v5.16-03-mips-bpf-Add-new-eBPF-JIT-for-64-bit-MIPS.patch \
    file://patches/backports/050-v5.16-04-mips-bpf-Add-JIT-workarounds-for-CPU-errata.patch \
    file://patches/backports/050-v5.16-05-mips-bpf-Enable-eBPF-JITs.patch \
    file://patches/backports/050-v5.16-06-mips-bpf-Remove-old-BPF-JIT-implementations.patch \
    file://patches/backports/071-crypto-arm-chacha-neon-optimize-for-non-block-size-m.patch \
    file://patches/backports/072-crypto-arm-chacha-neon-add-missing-counter-increment.patch \
    file://patches/backports/080-wireguard-peer-put-frequently-used-members-above-cac.patch \
    file://patches/backports/081-net-next-regmap-allow-to-define-reg_update_bits-for-no-bus.patch \
    file://patches/backports/103-v5.13-MIPS-select-CPU_MIPS64-for-remaining-MIPS64-CPUs.patch \
    file://patches/backports/311-v5.11-MIPS-zboot-put-appended-dtb-into-a-section.patch \
    file://patches/backports/343-netfilter-nft_flow_offload-handle-netdevice-events-f.patch \
    file://patches/backports/401-v5.11-dt-bindings-mtd-convert-fixed-partitions-to-the-json.patch \
    file://patches/backports/402-v5.12-0001-dt-bindings-mtd-move-partition-binding-to-its-own-fi.patch \
    file://patches/backports/402-v5.12-0002-dt-bindings-mtd-add-binding-for-BCM4908-partitions.patch \
    file://patches/backports/403-v5.13-mtd-parsers-ofpart-support-BCM4908-fixed-partitions.patch \
    file://patches/backports/404-v5.13-mtd-parsers-ofpart-limit-parsing-of-deprecated-DT-sy.patch \
    file://patches/backports/405-v5.13-mtd-parsers-ofpart-make-symbol-bcm4908_partitions_qu.patch \
    file://patches/backports/406-v5.13-0001-mtd-core-add-nvmem-cells-compatible-to-parse-mtd-as-.patch \
    file://patches/backports/406-v5.13-0002-dt-bindings-nvmem-drop-nodename-restriction.patch \
    file://patches/backports/406-v5.13-0003-dt-bindings-mtd-Document-use-of-nvmem-cells-compatib.patch \
    file://patches/backports/407-v5.13-0001-dt-bindings-mtd-add-binding-for-Linksys-Northstar-pa.patch \
    file://patches/backports/407-v5.13-0002-mtd-parsers-ofpart-support-Linksys-Northstar-partiti.patch \
    file://patches/backports/408-v5.13-mtd-cfi_cmdset_0002-Disable-buffered-writes-for-AMD.patch \
    file://patches/backports/409-v5.14-0001-dt-bindings-mtd-brcm-trx-Add-brcm-trx-magic.patch \
    file://patches/backports/409-v5.14-0002-mtd-parsers-trx-Allow-to-specify-brcm-trx-magic-in-D.patch \
    file://patches/backports/409-v5.14-0003-mtd-parsers-trx-Allow-to-use-TRX-parser-on-Mediatek-.patch \
    file://patches/backports/410-mtd-next-mtd-parsers-trx-allow-to-use-on-MediaTek-MIPS-SoCs.patch \
    file://patches/backports/412-v5.19-mtd-call-of_platform_populate-for-MTD-partitions.patch \
    file://patches/backports/413-v6.0-mtd-next-mtd-core-introduce-of-support-for-dynamic-partitions.patch \
    file://patches/backports/414-v6.1-mtd-allow-getting-MTD-device-associated-with-a-speci.patch \
    file://patches/backports/415-v6.0-mtd-core-check-partition-before-dereference.patch \
    file://patches/backports/416-v6.1-mtd-core-add-missing-of_node_get-in-dynamic-partitio.patch \
    file://patches/backports/417-v6.2-0001-mtd-core-simplify-a-bit-code-find-partition-matching.patch \
    file://patches/backports/417-v6.2-0002-mtd-core-try-to-find-OF-node-for-every-MTD-partition.patch \
    file://patches/backports/418-v6.2-mtd-core-set-ROOT_DEV-for-partitions-marked-as-rootf.patch \
    file://patches/backports/421-v6.2-mtd-parsers-add-TP-Link-SafeLoader-partitions-table-.patch \
    file://patches/backports/500-v5.13-ubifs-default-to-zstd-compression.patch \
    file://patches/backports/600-v5.12-net-extract-napi-poll-functionality-to-__napi_poll.patch \
    file://patches/backports/601-v5.12-net-implement-threaded-able-napi-poll-loop-support.patch \
    file://patches/backports/602-v5.12-net-add-sysfs-attribute-to-control-napi-threaded-mod.patch \
    file://patches/backports/603-v5.12-net-fix-race-between-napi-kthread-mode-and-busy-poll.patch \
    file://patches/backports/604-v5.12-net-fix-hangup-on-napi_disable-for-threaded-napi.patch \
    file://patches/backports/610-v5.13-00-netfilter-flowtable-add-hash-offset-field-to-tuple.patch \
    file://patches/backports/610-v5.13-01-netfilter-flowtable-separate-replace-destroy-and-sta.patch \
    file://patches/backports/610-v5.13-03-netfilter-conntrack-Remove-unused-variable-declarati.patch \
    file://patches/backports/610-v5.13-04-netfilter-flowtable-consolidate-skb_try_make_writabl.patch \
    file://patches/backports/610-v5.13-05-netfilter-flowtable-move-skb_try_make_writable-befor.patch \
    file://patches/backports/610-v5.13-06-netfilter-flowtable-move-FLOW_OFFLOAD_DIR_MAX-away-f.patch \
    file://patches/backports/610-v5.13-07-netfilter-flowtable-fast-NAT-functions-never-fail.patch \
    file://patches/backports/610-v5.13-08-netfilter-flowtable-call-dst_check-to-fall-back-to-c.patch \
    file://patches/backports/610-v5.13-09-netfilter-flowtable-refresh-timeout-after-dst-and-wr.patch \
    file://patches/backports/610-v5.13-10-netfilter-nftables-update-table-flags-from-the-commi.patch \
    file://patches/backports/610-v5.13-11-net-resolve-forwarding-path-from-virtual-netdevice-a.patch \
    file://patches/backports/610-v5.13-12-net-8021q-resolve-forwarding-path-for-vlan-devices.patch \
    file://patches/backports/610-v5.13-13-net-bridge-resolve-forwarding-path-for-bridge-device.patch \
    file://patches/backports/610-v5.13-14-net-bridge-resolve-forwarding-path-for-VLAN-tag-acti.patch \
    file://patches/backports/610-v5.13-15-net-ppp-resolve-forwarding-path-for-bridge-pppoe-dev.patch \
    file://patches/backports/610-v5.13-16-net-dsa-resolve-forwarding-path-for-dsa-slave-ports.patch \
    file://patches/backports/610-v5.13-17-netfilter-flowtable-add-xmit-path-types.patch \
    file://patches/backports/610-v5.13-18-netfilter-flowtable-use-dev_fill_forward_path-to-obt.patch \
    file://patches/backports/610-v5.13-19-netfilter-flowtable-use-dev_fill_forward_path-to-obt.patch \
    file://patches/backports/610-v5.13-20-netfilter-flowtable-add-vlan-support.patch \
    file://patches/backports/610-v5.13-21-netfilter-flowtable-add-bridge-vlan-filtering-suppor.patch \
    file://patches/backports/610-v5.13-22-netfilter-flowtable-add-pppoe-support.patch \
    file://patches/backports/610-v5.13-23-netfilter-flowtable-add-dsa-support.patch \
    file://patches/backports/610-v5.13-24-selftests-netfilter-flowtable-bridge-and-vlan-suppor.patch \
    file://patches/backports/610-v5.13-25-netfilter-flowtable-add-offload-support-for-xmit-pat.patch \
    file://patches/backports/610-v5.13-26-netfilter-nft_flow_offload-use-direct-xmit-if-hardwa.patch \
    file://patches/backports/610-v5.13-27-netfilter-flowtable-bridge-vlan-hardware-offload-and.patch \
    file://patches/backports/610-v5.13-28-net-flow_offload-add-FLOW_ACTION_PPPOE_PUSH.patch \
    file://patches/backports/610-v5.13-29-netfilter-flowtable-support-for-FLOW_ACTION_PPPOE_PU.patch \
    file://patches/backports/610-v5.13-30-dsa-slave-add-support-for-TC_SETUP_FT.patch \
    file://patches/backports/610-v5.13-31-net-ethernet-mtk_eth_soc-fix-parsing-packets-in-GDM.patch \
    file://patches/backports/610-v5.13-32-net-ethernet-mtk_eth_soc-add-support-for-initializin.patch \
    file://patches/backports/610-v5.13-33-net-ethernet-mtk_eth_soc-add-flow-offloading-support.patch \
    file://patches/backports/610-v5.13-34-docs-nf_flowtable-update-documentation-with-enhancem.patch \
    file://patches/backports/610-v5.13-35-net-ethernet-mediatek-ppe-fix-busy-wait-loop.patch \
    file://patches/backports/610-v5.13-36-net-ethernet-mediatek-fix-a-typo-bug-in-flow-offload.patch \
    file://patches/backports/610-v5.13-38-net-ethernet-mtk_eth_soc-unmap-RX-data-before-callin.patch \
    file://patches/backports/610-v5.13-39-net-ethernet-mtk_eth_soc-fix-build_skb-cleanup.patch \
    file://patches/backports/610-v5.13-40-net-ethernet-mtk_eth_soc-use-napi_consume_skb.patch \
    file://patches/backports/610-v5.13-41-net-ethernet-mtk_eth_soc-reduce-MDIO-bus-access-late.patch \
    file://patches/backports/610-v5.13-42-net-ethernet-mtk_eth_soc-remove-unnecessary-TX-queue.patch \
    file://patches/backports/610-v5.13-43-net-ethernet-mtk_eth_soc-use-larger-burst-size-for-Q.patch \
    file://patches/backports/610-v5.13-44-net-ethernet-mtk_eth_soc-increase-DMA-ring-sizes.patch \
    file://patches/backports/610-v5.13-45-net-ethernet-mtk_eth_soc-implement-dynamic-interrupt.patch \
    file://patches/backports/610-v5.13-46-net-ethernet-mtk_eth_soc-cache-HW-pointer-of-last-fr.patch \
    file://patches/backports/610-v5.13-47-net-ethernet-mtk_eth_soc-only-read-the-full-RX-descr.patch \
    file://patches/backports/610-v5.13-48-net-ethernet-mtk_eth_soc-reduce-unnecessary-interrup.patch \
    file://patches/backports/610-v5.13-49-net-ethernet-mtk_eth_soc-rework-NAPI-callbacks.patch \
    file://patches/backports/610-v5.13-50-net-ethernet-mtk_eth_soc-set-PPE-flow-hash-as-skb-ha.patch \
    file://patches/backports/610-v5.13-51-net-ethernet-mtk_eth_soc-use-iopoll.h-macro-for-DMA-.patch \
    file://patches/backports/610-v5.13-52-net-ethernet-mtk_eth_soc-missing-mutex.patch \
    file://patches/backports/610-v5.13-53-net-ethernet-mtk_eth_soc-handle-VLAN-pop-action.patch \
    file://patches/backports/610-v5.13-54-netfilter-flowtable-dst_check-from-garbage-collector.patch \
    file://patches/backports/610-v5.13-55-netfilter-conntrack-Introduce-tcp-offload-timeout-co.patch \
    file://patches/backports/610-v5.13-56-netfilter-conntrack-Introduce-udp-offload-timeout-co.patch \
    file://patches/backports/610-v5.13-57-netfilter-flowtable-Set-offload-timeouts-according-t.patch \
    file://patches/backports/610-v5.13-58-netfilter-flowtable-Add-FLOW_OFFLOAD_XMIT_UNSPEC-xmi.patch \
    file://patches/backports/610-v5.15-58-netfilter-flowtable-avoid-possible-false-sharing.patch \
    file://patches/backports/610-v5.18-netfilter-flowtable-move-dst_check-to-packet-path.patch \
    file://patches/backports/611-v5.12-net-ethernet-mediatek-support-setting-MTU.patch \
    file://patches/backports/612-v5.15-netfilter-conntrack-sanitize-table-size-default-sett.patch \
    file://patches/backports/613-v5.15-01-netfilter-flowtable-remove-nf_ct_l4proto_find-call.patch \
    file://patches/backports/613-v5.15-02-netfilter-conntrack-remove-offload_pickup-sysctl-aga.patch \
    file://patches/backports/614-v5.18-netfilter-flowtable-fix-TCP-flow-teardown.patch \
    file://patches/backports/705-net-phy-at803x-select-correct-page-on-config-init.patch \
    file://patches/backports/706-net-phy-at803x-fix-probe-error-if-copper-page-is-sel.patch \
    file://patches/backports/710-v5.12-net-phy-Add-100-base-x-mode.patch \
    file://patches/backports/711-v5.12-sfp-add-support-for-100-base-x-SFPs.patch \
    file://patches/backports/712-v5.13-net-phy-marvell-refactor-HWMON-OOP-style.patch \
    file://patches/backports/713-v5.15-net-phy-marvell-add-SFP-support-for-88E1510.patch \
    file://patches/backports/719-v5.12-net-dsa-automatically-bring-up-DSA-master-when-openi.patch \
    file://patches/backports/720-v5.12-net-bridge-notify-switchdev-of-disappearance-of-old-.patch \
    file://patches/backports/721-v5.12-net-dsa-be-louder-when-a-non-legacy-FDB-operation-fa.patch \
    file://patches/backports/722-v5.12-net-dsa-don-t-use-switchdev_notifier_fdb_info-in-dsa.patch \
    file://patches/backports/723-v5.12-net-dsa-move-switchdev-event-implementation-under-th.patch \
    file://patches/backports/724-v5.12-net-dsa-exit-early-in-dsa_slave_switchdev_event-if-w.patch \
    file://patches/backports/725-v5.12-net-dsa-listen-for-SWITCHDEV_-FDB-DEL-_ADD_TO_DEVICE.patch \
    file://patches/backports/730-net-dsa-mt7530-setup-core-clock-even-in-TRGMII-mode.patch \
    file://patches/backports/731-v5.12-net-dsa-mt7530-MT7530-optional-GPIO-support.patch \
    file://patches/backports/731-v5.13-net-dsa-mt7530-Add-support-for-EEE-features.patch \
    file://patches/backports/732-net-next-1-of-net-pass-the-dst-buffer-to-of_get_mac_address.patch \
    file://patches/backports/732-net-next-2-of-net-fix-of_get_mac_addr_nvmem-for-non-platform-devices.patch \
    file://patches/backports/733-v5.15-0001-net-bgmac-bcma-handle-deferred-probe-error-due-to-ma.patch \
    file://patches/backports/733-v5.15-0002-net-bgmac-platform-handle-mac-address-deferral.patch \
    file://patches/backports/734-v5.16-0001-net-bgmac-improve-handling-PHY.patch \
    file://patches/backports/734-v5.16-0002-net-bgmac-support-MDIO-described-in-DT.patch \
    file://patches/backports/735-v5.14-01-net-dsa-qca8k-change-simple-print-to-dev-variant.patch \
    file://patches/backports/735-v5.14-02-net-dsa-qca8k-use-iopoll-macro-for-qca8k_busy_wait.patch \
    file://patches/backports/735-v5.14-03-net-dsa-qca8k-improve-qca8k-read-write-rmw-bus-acces.patch \
    file://patches/backports/735-v5.14-04-net-dsa-qca8k-handle-qca8k_set_page-errors.patch \
    file://patches/backports/735-v5.14-05-net-dsa-qca8k-handle-error-with-qca8k_read-operation.patch \
    file://patches/backports/735-v5.14-06-net-dsa-qca8k-handle-error-with-qca8k_write-operatio.patch \
    file://patches/backports/735-v5.14-07-net-dsa-qca8k-handle-error-with-qca8k_rmw-operation.patch \
    file://patches/backports/735-v5.14-08-net-dsa-qca8k-handle-error-from-qca8k_busy_wait.patch \
    file://patches/backports/735-v5.14-09-net-dsa-qca8k-add-support-for-qca8327-switch.patch \
    file://patches/backports/735-v5.14-10-devicetree-net-dsa-qca8k-Document-new-compatible-qca.patch \
    file://patches/backports/735-v5.14-11-net-dsa-qca8k-add-priority-tweak-to-qca8337-switch.patch \
    file://patches/backports/735-v5.14-12-net-dsa-qca8k-limit-port5-delay-to-qca8337.patch \
    file://patches/backports/735-v5.14-13-net-dsa-qca8k-add-GLOBAL_FC-settings-needed-for-qca8.patch \
    file://patches/backports/735-v5.14-14-net-dsa-qca8k-add-support-for-switch-rev.patch \
    file://patches/backports/735-v5.14-15-net-dsa-qca8k-add-ethernet-ports-fallback-to-setup_m.patch \
    file://patches/backports/735-v5.14-16-net-dsa-qca8k-make-rgmii-delay-configurable.patch \
    file://patches/backports/735-v5.14-17-net-dsa-qca8k-clear-MASTER_EN-after-phy-read-write.patch \
    file://patches/backports/735-v5.14-18-net-dsa-qca8k-dsa-qca8k-protect-MASTER-busy_wait-wit.patch \
    file://patches/backports/735-v5.14-19-net-dsa-qca8k-enlarge-mdio-delay-and-timeout.patch \
    file://patches/backports/735-v5.14-20-net-dsa-qca8k-add-support-for-internal-phy-and-inter.patch \
    file://patches/backports/735-v5.14-21-devicetree-bindings-dsa-qca8k-Document-internal-mdio.patch \
    file://patches/backports/735-v5.14-22-net-dsa-qca8k-improve-internal-mdio-read-write-bus-a.patch \
    file://patches/backports/735-v5.14-23-net-dsa-qca8k-pass-switch_revision-info-to-phy-dev_f.patch \
    file://patches/backports/735-v5.14-25-net-phy-add-support-for-qca8k-switch-internal-PHY-in.patch \
    file://patches/backports/736-v5.14-net-dsa-qca8k-fix-missing-unlock-on-error-in-qca8k-vlan.patch \
    file://patches/backports/737-v5.14-01-net-dsa-qca8k-check-return-value-of-read-functions-c.patch \
    file://patches/backports/737-v5.14-02-net-dsa-qca8k-add-missing-check-return-value-in-qca8.patch \
    file://patches/backports/738-v5.14-01-net-dsa-qca8k-fix-an-endian-bug-in-qca8k-get-ethtool.patch \
    file://patches/backports/738-v5.14-02-net-dsa-qca8k-check-the-correct-variable-in-qca8k-se.patch \
    file://patches/backports/739-v5.15-net-dsa-qca8k-fix-kernel-panic-with-legacy-mdio-mapping.patch \
    file://patches/backports/740-v5.13-0001-net-dsa-b53-Add-debug-prints-in-b53_vlan_enable.patch \
    file://patches/backports/740-v5.13-0002-net-dsa-b53-spi-allow-device-tree-probing.patch \
    file://patches/backports/740-v5.13-0003-net-dsa-b53-relax-is63xx-condition.patch \
    file://patches/backports/740-v5.13-0004-net-dsa-tag_brcm-add-support-for-legacy-tags.patch \
    file://patches/backports/740-v5.13-0005-net-dsa-b53-support-legacy-tags.patch \
    file://patches/backports/740-v5.13-0006-net-dsa-b53-mmap-Add-device-tree-support.patch \
    file://patches/backports/740-v5.13-0007-net-dsa-b53-spi-add-missing-MODULE_DEVICE_TABLE.patch \
    file://patches/backports/741-v5.14-0001-net-dsa-b53-Do-not-force-CPU-to-be-always-tagged.patch \
    file://patches/backports/741-v5.14-0002-net-dsa-b53-remove-redundant-null-check-on-dev.patch \
    file://patches/backports/741-v5.14-0003-net-dsa-b53-Create-default-VLAN-entry-explicitly.patch \
    file://patches/backports/742-v5.16-net-phy-at803x-add-support-for-qca-8327-internal-phy.patch \
    file://patches/backports/743-v5.16-0001-net-dsa-b53-Include-all-ports-in-enabled_ports.patch \
    file://patches/backports/743-v5.16-0002-net-dsa-b53-Drop-BCM5301x-workaround-for-a-wrong-CPU.patch \
    file://patches/backports/743-v5.16-0003-net-dsa-b53-Improve-flow-control-setup-on-BCM5301x.patch \
    file://patches/backports/743-v5.16-0004-net-dsa-b53-Drop-unused-cpu_port-field.patch \
    file://patches/backports/744-v5.15-net-dsa-don-t-set-skb-offload_fwd_mark-when-not-offl.patch \
    file://patches/backports/745-v5.16-01-net-phy-at803x-add-support-for-qca-8327-A-variant.patch \
    file://patches/backports/745-v5.16-02-net-phy-at803x-add-resume-suspend-function-to-qca83x.patch \
    file://patches/backports/745-v5.16-03-net-phy-at803x-fix-spacing-and-improve-name-for-83xx.patch \
    file://patches/backports/746-v5.16-01-net-phy-at803x-fix-resume-for-QCA8327-phy.patch \
    file://patches/backports/746-v5.16-02-net-phy-at803x-add-DAC-amplitude-fix-for-8327-phy.patch \
    file://patches/backports/746-v5.16-03-net-phy-at803x-enable-prefer-master-for-83xx-interna.patch \
    file://patches/backports/746-v5.16-04-net-phy-at803x-better-describe-debug-regs.patch \
    file://patches/backports/747-v5.16-01-dsa-qca8k-add-mac-power-sel-support.patch \
    file://patches/backports/747-v5.16-02-dt-bindings-net-dsa-qca8k-Add-SGMII-clock-phase-prop.patch \
    file://patches/backports/747-v5.16-03-net-dsa-qca8k-add-support-for-sgmii-falling-edge.patch \
    file://patches/backports/747-v5.16-04-dt-bindings-net-dsa-qca8k-Document-support-for-CPU-p.patch \
    file://patches/backports/747-v5.16-05-net-dsa-qca8k-add-support-for-cpu-port-6.patch \
    file://patches/backports/747-v5.16-06-net-dsa-qca8k-rework-rgmii-delay-logic-and-scan-for-.patch \
    file://patches/backports/747-v5.16-07-dt-bindings-net-dsa-qca8k-Document-qca-sgmii-enable-.patch \
    file://patches/backports/747-v5.16-08-net-dsa-qca8k-add-explicit-SGMII-PLL-enable.patch \
    file://patches/backports/747-v5.16-09-dt-bindings-net-dsa-qca8k-Document-qca-led-open-drai.patch \
    file://patches/backports/747-v5.16-10-net-dsa-qca8k-add-support-for-pws-config-reg.patch \
    file://patches/backports/747-v5.16-11-dt-bindings-net-dsa-qca8k-document-support-for-qca83.patch \
    file://patches/backports/747-v5.16-12-net-dsa-qca8k-add-support-for-QCA8328.patch \
    file://patches/backports/747-v5.16-13-net-dsa-qca8k-set-internal-delay-also-for-sgmii.patch \
    file://patches/backports/747-v5.16-14-net-dsa-qca8k-move-port-config-to-dedicated-struct.patch \
    file://patches/backports/747-v5.16-15-dt-bindings-net-ipq8064-mdio-fix-warning-with-new-qc.patch \
    file://patches/backports/747-v5.16-16-dt-bindings-net-dsa-qca8k-convert-to-YAML-schema.patch \
    file://patches/backports/748-v5.16-net-dsa-qca8k-fix-delay-applied-to-wrong-cpu-in-parse-p.patch \
    file://patches/backports/749-v5.16-net-dsa-qca8k-tidy-for-loop-in-setup-and-add-cpu-port-c.patch \
    file://patches/backports/750-v5.16-net-dsa-qca8k-make-sure-pad0-mac06-exchange-is-disabled.patch \
    file://patches/backports/751-v5.16-net-dsa-qca8k-fix-internal-delay-applied-to-the-wrong-PAD.patch \
    file://patches/backports/752-v5.16-net-dsa-qca8k-fix-MTU-calculation.patch \
    file://patches/backports/753-net-next-net-dsa-qca8k-remove-redundant-check-in-parse_port_config.patch \
    file://patches/backports/754-net-next-net-dsa-qca8k-convert-to-GENMASK_FIELD_PREP_FIELD_GET.patch \
    file://patches/backports/755-net-next-net-dsa-qca8k-remove-extra-mutex_init-in-qca8k_setup.patch \
    file://patches/backports/756-net-next-net-dsa-qca8k-move-regmap-init-in-probe-and-set-it.patch \
    file://patches/backports/757-net-next-net-dsa-qca8k-initial-conversion-to-regmap-heper.patch \
    file://patches/backports/758-net-next-net-dsa-qca8k-add-additional-MIB-counter-and-.patch \
    file://patches/backports/759-net-next-net-dsa-qca8k-add-support-for-port-fast-aging.patch \
    file://patches/backports/760-net-next-net-dsa-qca8k-add-set_ageing_time-support.patch \
    file://patches/backports/761-net-next-net-dsa-qca8k-add-support-for-mdb_add-del.patch \
    file://patches/backports/762-v5.11-net-dsa-mt7530-support-setting-MTU.patch \
    file://patches/backports/763-v5.11-net-dsa-mt7530-enable-MTU-normalization.patch \
    file://patches/backports/764-v5.11-net-dsa-mt7530-support-setting-ageing-time.patch \
    file://patches/backports/770-v5.15-net-dsa-mt7530-support-MDB-operations.patch \
    file://patches/backports/771-v5.14-net-phy-add-MediaTek-Gigabit-Ethernet-PHY-driver.patch \
    file://patches/backports/772-v5.14-net-dsa-mt7530-add-interrupt-support.patch \
    file://patches/backports/773-v5.18-1-net-dsa-Move-VLAN-filtering-syncing-out-of-dsa_switc.patch \
    file://patches/backports/773-v5.18-2-net-dsa-Avoid-cross-chip-syncing-of-VLAN-filtering.patch \
    file://patches/backports/800-v5.13-0001-firmware-bcm47xx_nvram-rename-finding-function-and-i.patch \
    file://patches/backports/800-v5.13-0002-firmware-bcm47xx_nvram-add-helper-checking-for-NVRAM.patch \
    file://patches/backports/800-v5.13-0003-firmware-bcm47xx_nvram-extract-code-copying-NVRAM.patch \
    file://patches/backports/800-v5.13-0004-firmware-bcm47xx_nvram-look-for-NVRAM-with-for-inste.patch \
    file://patches/backports/800-v5.13-0005-firmware-bcm47xx_nvram-inline-code-checking-NVRAM-si.patch \
    file://patches/backports/801-v6.1-0001-nvmem-add-driver-handling-U-Boot-environment-variabl.patch \
    file://patches/backports/801-v6.1-0002-nvmem-u-boot-env-find-Device-Tree-nodes-for-NVMEM-ce.patch \
    file://patches/backports/801-v6.1-0003-nvmem-u-boot-env-fix-crc32-casting-type.patch \
    file://patches/backports/802-v5.19-nvmem-core-support-passing-DT-node-in-cell-info.patch \
    file://patches/backports/803-v6.2-0001-nvmem-u-boot-env-fix-crc32_data_offset-on-redundant-.patch \
    file://patches/backports/803-v6.2-0002-nvmem-u-boot-env-align-endianness-of-crc32-values.patch \
    file://patches/backports/803-v6.2-0003-nvmem-u-boot-env-add-Broadcom-format-support.patch \
    file://patches/backports/810-v5.13-usb-ehci-add-spurious-flag-to-disable-overcurrent-ch.patch \
    file://patches/backports/811-v5.13-usb-host-ehci-platform-add-spurious_oc-DT-support.patch \
    file://patches/backports/820-v5.13-make-pci_host_common_probe-declare-its-reliance-on-msi-domains.patch \
    file://patches/backports/821-v5.13-let-pci-host-bridges-declar-their-reliance-on-msi-domains.patch \
    file://patches/backports/822-v5.13-advertise-lack-of-built-in-msi-handling.patch \
    file://patches/backports/830-v5.14-leds-lp55xx-Initialize-enable-GPIO-direction-to-outp.patch \
    file://patches/backports/845-v6.0-0001-dt-bindings-leds-add-Broadcom-s-BCM63138-controller.patch \
    file://patches/backports/845-v6.0-0002-leds-bcm63138-add-support-for-BCM63138-controller.patch \
    file://patches/backports/846-v6.0-0001-dt-bindings-leds-leds-bcm63138-unify-full-stops-in-d.patch \
    file://patches/backports/846-v6.0-0002-leds-add-help-info-about-BCM63138-module-name.patch \
    file://patches/backports/846-v6.0-0003-leds-leds-bcm63138-get-rid-of-LED_OFF.patch \
    file://patches/backports/850-v5.17-0001-PCI-pci-bridge-emul-Add-description-for-class_revisi.patch \
    file://patches/backports/850-v5.17-0002-PCI-pci-bridge-emul-Add-definitions-for-missing-capa.patch \
    file://patches/backports/850-v5.17-0003-PCI-aardvark-Add-support-for-DEVCAP2-DEVCTL2-LNKCAP2.patch \
    file://patches/backports/850-v5.17-0005-PCI-aardvark-Comment-actions-in-driver-remove-method.patch \
    file://patches/backports/850-v5.17-0006-PCI-aardvark-Disable-bus-mastering-when-unbinding-dr.patch \
    file://patches/backports/850-v5.17-0007-PCI-aardvark-Mask-all-interrupts-when-unbinding-driv.patch \
    file://patches/backports/850-v5.17-0008-PCI-aardvark-Fix-memory-leak-in-driver-unbind.patch \
    file://patches/backports/850-v5.17-0009-PCI-aardvark-Assert-PERST-when-unbinding-driver.patch \
    file://patches/backports/850-v5.17-0010-PCI-aardvark-Disable-link-training-when-unbinding-dr.patch \
    file://patches/backports/850-v5.17-0011-PCI-aardvark-Disable-common-PHY-when-unbinding-drive.patch \
    file://patches/backports/851-v5.15-0001-phy-marvell-phy-mvebu-a3700-comphy-Rename-HS-SGMMI-t.patch \
    file://patches/backports/851-v5.15-0002-phy-marvell-phy-mvebu-a3700-comphy-Remove-unsupporte.patch \
    file://patches/backports/860-v5.17-MIPS-ath79-drop-_machine_restart-again.patch \
    file://patches/backports/870-hwmon-next-hwmon-lm70-Add-ti-tmp125-support.patch \
    file://patches/backports/880-v5.19-cdc_ether-export-usbnet_cdc_zte_rx_fixup.patch \
    file://patches/backports/881-v5.19-rndis_host-enable-the-bogus-MAC-fixup-for-ZTE-device.patch \
    file://patches/backports/882-v5.19-rndis_host-limit-scope-of-bogus-MAC-address-detectio.patch \
"

SRC_URI += " \
    file://patches/pending/050-dtc-checks-Drop-interrupt-provider-address-cells-check.patch \
    file://patches/pending/100-compiler.h-only-include-asm-rwonce.h-for-kernel-code.patch \
    file://patches/pending/101-Use-stddefs.h-instead-of-compiler.h.patch \
    file://patches/pending/102-MIPS-only-process-negative-stack-offsets-on-stack-tr.patch \
    file://patches/pending/120-Fix-alloc_node_mem_map-with-ARCH_PFN_OFFSET-calcu.patch \
    file://patches/pending/130-add-linux-spidev-compatible-si3210.patch \
    file://patches/pending/140-jffs2-use-.rename2-and-add-RENAME_WHITEOUT-support.patch \
    file://patches/pending/141-jffs2-add-RENAME_EXCHANGE-support.patch \
    file://patches/pending/142-jffs2-add-splice-ops.patch \
    file://patches/pending/150-bridge_allow_receiption_on_disabled_port.patch \
    file://patches/pending/190-rtc-rs5c372-support_alarms_up_to_1_week.patch \
    file://patches/pending/191-rtc-rs5c372-let_the_alarm_to_be_used_as_wakeup_source.patch \
    file://patches/pending/203-kallsyms_uncompressed.patch \
    file://patches/pending/205-backtrace_module_info.patch \
    file://patches/pending/240-remove-unsane-filenames-from-deps_initramfs-list.patch \
    file://patches/pending/261-enable_wilink_platform_without_drivers.patch \
    file://patches/pending/270-platform-mikrotik-build-bits.patch \
    file://patches/pending/300-mips_expose_boot_raw.patch \
    file://patches/pending/302-mips_no_branch_likely.patch \
    file://patches/pending/305-mips_module_reloc.patch \
    file://patches/pending/307-mips_highmem_offset.patch \
    file://patches/pending/308-mips32r2_tune.patch \
    file://patches/pending/309-MIPS-Add-CPU-option-reporting-to-proc-cpuinfo.patch \
    file://patches/pending/310-arm_module_unresolved_weak_sym.patch \
    file://patches/pending/330-MIPS-kexec-Accept-command-line-parameters-from-users.patch \
    file://patches/pending/332-arc-add-OWRTDTB-section.patch \
    file://patches/pending/333-arc-enable-unaligned-access-in-kernel-mode.patch \
    file://patches/pending/342-powerpc-Enable-kernel-XZ-compression-option-on-PPC_8.patch \
    file://patches/pending/400-mtd-mtdsplit-support.patch \
    file://patches/pending/402-mtd-spi-nor-write-support-for-minor-aligned-partitions.patch \
    file://patches/pending/410-mtd-parsers-ofpart-fix-parsing-subpartitions.patch \
    file://patches/pending/419-mtd-redboot-add-of_match_table-with-DT-binding.patch \
    file://patches/pending/420-mtd-redboot_space.patch \
    file://patches/pending/430-mtd-add-myloader-partition-parser.patch \
    file://patches/pending/431-mtd-bcm47xxpart-check-for-bad-blocks-when-calculatin.patch \
    file://patches/pending/432-mtd-bcm47xxpart-detect-T_Meter-partition.patch \
    file://patches/pending/435-mtd-add-routerbootpart-parser-config.patch \
    file://patches/pending/460-mtd-cfi_cmdset_0002-no-erase_suspend.patch \
    file://patches/pending/461-mtd-cfi_cmdset_0002-add-buffer-write-cmd-timeout.patch \
    file://patches/pending/465-m25p80-mx-disable-software-protection.patch \
    file://patches/pending/470-mtd-spi-nor-support-limiting-4K-sectors-support-base.patch \
    file://patches/pending/476-mtd-spi-nor-add-eon-en25q128.patch \
    file://patches/pending/477-mtd-spi-nor-add-eon-en25qx128a.patch \
    file://patches/pending/479-mtd-spi-nor-add-xtx-xt25f128b.patch \
    file://patches/pending/482-mtd-spi-nor-add-support-for-Gigadevice-GD25D05.patch \
    file://patches/pending/483-mtd-spinand-add-support-for-xtx-xt26g0xa.patch \
    file://patches/pending/483-mtd-spi-nor-add-gd25q512.patch \
    file://patches/pending/484-mtd-spi-nor-add-esmt-f25l16pa.patch \
    file://patches/pending/485-mtd-spi-nor-add-xmc-xm25qh128c.patch \
    file://patches/pending/490-ubi-auto-attach-mtd-device-named-ubi-or-data-on-boot.patch \
    file://patches/pending/491-ubi-auto-create-ubiblock-device-for-rootfs.patch \
    file://patches/pending/492-try-auto-mounting-ubi0-rootfs-in-init-do_mounts.c.patch \
    file://patches/pending/493-ubi-set-ROOT_DEV-to-ubiblock-rootfs-if-unset.patch \
    file://patches/pending/494-mtd-ubi-add-EOF-marker-support.patch \
    file://patches/pending/495-mtd-core-add-get_mtd_device_by_node.patch \
    file://patches/pending/496-dt-bindings-add-bindings-for-mtd-concat-devices.patch \
    file://patches/pending/497-mtd-mtdconcat-add-dt-driver-for-concat-devices.patch \
    file://patches/pending/498-mtd-spi-nor-locking-support-for-MX25L6405D.patch \
    file://patches/pending/499-mtd-spi-nor-disable-16-bit-sr-for-macronix.patch \
    file://patches/pending/500-fs_cdrom_dependencies.patch \
    file://patches/pending/530-jffs2_make_lzma_available.patch \
    file://patches/pending/532-jffs2_eofdetect.patch \
    file://patches/pending/600-netfilter_conntrack_flush.patch \
    file://patches/pending/610-netfilter_match_bypass_default_checks.patch \
    file://patches/pending/611-netfilter_match_bypass_default_table.patch \
    file://patches/pending/612-netfilter_match_reduce_memory_access.patch \
    file://patches/pending/613-netfilter_optional_tcp_window_check.patch \
    file://patches/pending/620-net_sched-codel-do-not-defer-queue-length-update.patch \
    file://patches/pending/630-packet_socket_type.patch \
    file://patches/pending/655-increase_skb_pad.patch \
    file://patches/pending/666-Add-support-for-MAP-E-FMRs-mesh-mode.patch \
    file://patches/pending/670-ipv6-allow-rejecting-with-source-address-failed-policy.patch \
    file://patches/pending/671-net-provide-defines-for-_POLICY_FAILED-until-all-cod.patch \
    file://patches/pending/680-NET-skip-GRO-for-foreign-MAC-addresses.patch \
    file://patches/pending/682-of_net-add-mac-address-increment-support.patch \
    file://patches/pending/683-of_net-add-mac-address-to-of-tree.patch \
    file://patches/pending/700-net-ethernet-mtk_eth_soc-avoid-creating-duplicate-of.patch \
    file://patches/pending/701-00-net-ethernet-mtk_eth_soc-add-support-for-coherent-DM.patch \
    file://patches/pending/701-01-arm64-dts-mediatek-mt7622-add-support-for-coherent-D.patch \
    file://patches/pending/701-02-net-ethernet-mtk_eth_soc-add-support-for-Wireless-Et.patch \
    file://patches/pending/701-03-net-ethernet-mtk_eth_soc-implement-flow-offloading-t.patch \
    file://patches/pending/701-04-arm64-dts-mediatek-mt7622-introduce-nodes-for-Wirele.patch \
    file://patches/pending/701-05-net-ethernet-mtk_eth_soc-add-ipv6-flow-offload-suppo.patch \
    file://patches/pending/701-06-net-ethernet-mtk_eth_soc-support-TC_SETUP_BLOCK-for-.patch \
    file://patches/pending/701-07-net-ethernet-mtk_eth_soc-allocate-struct-mtk_ppe-sep.patch \
    file://patches/pending/701-08-net-ethernet-mtk_eth_soc-rework-hardware-flow-table-.patch \
    file://patches/pending/701-09-net-ethernet-mtk_eth_soc-remove-bridge-flow-offload-.patch \
    file://patches/pending/701-10-net-ethernet-mtk_eth_soc-support-creating-mac-addres.patch \
    file://patches/pending/703-phy-add-detach-callback-to-struct-phy_driver.patch \
    file://patches/pending/704-00-netfilter-flowtable-fix-excessive-hw-offload-attempt.patch \
    file://patches/pending/704-01-netfilter-nft_flow_offload-skip-dst-neigh-lookup-for.patch \
    file://patches/pending/704-02-net-fix-dev_fill_forward_path-with-pppoe-bridge.patch \
    file://patches/pending/704-03-netfilter-nft_flow_offload-fix-offload-with-pppoe-vl.patch \
    file://patches/pending/705-net-dsa-tag_mtk-add-padding-for-tx-packets.patch \
    file://patches/pending/710-bridge-add-knob-for-filtering-rx-tx-BPDU-pack.patch \
    file://patches/pending/730-net-phy-at803x-fix-feature-detection.patch \
    file://patches/pending/760-net-dsa-mv88e6xxx-fix-vlan-setup.patch \
    file://patches/pending/762-net-bridge-switchdev-Refactor-br_switchdev_fdb_notif.patch \
    file://patches/pending/763-net-bridge-switchdev-Include-local-flag-in-FDB-notif.patch \
    file://patches/pending/764-net-bridge-switchdev-Send-FDB-notifications-for-host.patch \
    file://patches/pending/765-net-dsa-Include-local-addresses-in-assisted-CPU-port.patch \
    file://patches/pending/766-net-dsa-Include-bridge-addresses-in-assisted-CPU-por.patch \
    file://patches/pending/767-net-dsa-Sync-static-FDB-entries-on-foreign-interface.patch \
    file://patches/pending/768-net-dsa-mv88e6xxx-Request-assisted-learning-on-CPU-port.patch \
    file://patches/pending/780-ARM-kirkwood-add-missing-linux-if_ether.h-for-ETH_AL.patch \
    file://patches/pending/800-bcma-get-SoC-device-struct-copy-its-DMA-params-to-th.patch \
    file://patches/pending/801-gpio-gpio-cascade-add-generic-GPIO-cascade.patch \
    file://patches/pending/810-pci_disable_common_quirks.patch \
    file://patches/pending/811-pci_disable_usb_common_quirks.patch \
    file://patches/pending/820-w1-gpio-fix-problem-with-platfom-data-in-w1-gpio.patch \
    file://patches/pending/834-ledtrig-libata.patch \
    file://patches/pending/840-hwrng-bcm2835-set-quality-to-1000.patch \
    file://patches/pending/842-net-qmi_wwan-add-ZTE-MF286D-modem-19d2-1485.patch \
    file://patches/pending/850-0001-PCI-aardvark-Replace-custom-PCIE_CORE_INT_-macros-wi.patch \
    file://patches/pending/850-0004-PCI-aardvark-Rewrite-IRQ-code-to-chained-IRQ-handler.patch \
    file://patches/pending/850-0005-PCI-aardvark-Check-return-value-of-generic_handle_do.patch \
    file://patches/pending/850-0006-PCI-aardvark-Make-MSI-irq_chip-structures-static-dri.patch \
    file://patches/pending/850-0007-PCI-aardvark-Make-msi_domain_info-structure-a-static.patch \
    file://patches/pending/850-0008-PCI-aardvark-Use-dev_fwnode-instead-of-of_node_to_fw.patch \
    file://patches/pending/850-0009-PCI-aardvark-Refactor-unmasking-summary-MSI-interrup.patch \
    file://patches/pending/850-0010-PCI-aardvark-Add-support-for-masking-MSI-interrupts.patch \
    file://patches/pending/850-0011-PCI-aardvark-Fix-setting-MSI-address.patch \
    file://patches/pending/850-0012-PCI-aardvark-Enable-MSI-X-support.patch \
    file://patches/pending/850-0013-PCI-aardvark-Add-support-for-ERR-interrupt-on-emulat.patch \
    file://patches/pending/850-0015-PCI-aardvark-Optimize-writing-PCI_EXP_RTCTL_PMEIE-an.patch \
    file://patches/pending/850-0016-PCI-aardvark-Add-support-for-PME-interrupts.patch \
    file://patches/pending/850-0017-PCI-aardvark-Fix-support-for-PME-requester-on-emulat.patch \
    file://patches/pending/850-0018-PCI-aardvark-Use-separate-INTA-interrupt-for-emulate.patch \
    file://patches/pending/850-0019-PCI-aardvark-Remove-irq_mask_ack-callback-for-INTx-i.patch \
    file://patches/pending/850-0020-PCI-aardvark-Don-t-mask-irq-when-mapping.patch \
    file://patches/pending/850-0021-PCI-aardvark-Drop-__maybe_unused-from-advk_pcie_disa.patch \
    file://patches/pending/850-0022-PCI-aardvark-Update-comment-about-link-going-down-af.patch \
    file://patches/pending/850-0023-PCI-aardvark-Make-main-irq_chip-structure-a-static-d.patch \
    file://patches/pending/851-0001-phy-marvell-phy-mvebu-a3700-comphy-Remove-port-from-.patch \
    file://patches/pending/851-0002-phy-marvell-phy-mvebu-a3700-comphy-Add-native-kernel.patch \
    file://patches/pending/851-0003-arm64-dts-marvell-armada-37xx-Add-xtal-clock-to-comp.patch \
    file://patches/pending/851-0004-Revert-ata-ahci-mvebu-Make-SATA-PHY-optional-for-Arm.patch \
    file://patches/pending/851-0005-Revert-usb-host-xhci-mvebu-make-USB-3.0-PHY-optional.patch \
    file://patches/pending/851-0006-Revert-PCI-aardvark-Fix-initialization-with-old-Marv.patch \
    file://patches/pending/920-mangle_bootargs.patch \
"



SRC_URI += " \
    file://patches/020-mips-ralink-manage-low-reset-lines.patch \
    file://patches/200-add-ralink-eth.patch \
    file://patches/201-MIPS-ralink-rt288x-select-MIPS_AUTO_PFN_OFFSET.patch \
    file://patches/203-staging-mt7621-pci-phy-kconfig-select-regmap-mmio.patch \
    file://patches/300-mt7620-export-chip-version-and-pkg.patch \
    file://patches/311-MIPS-use-set_mode-to-enable-disable-the-cevt-r4k-irq.patch \
    file://patches/312-MIPS-ralink-add-cpu-frequency-scaling.patch \
    file://patches/314-MIPS-add-bootargs-override-property.patch \
    file://patches/315-owrt-hack-fix-mt7688-cache-issue.patch \
    file://patches/316-arch-mips-do-not-select-illegal-access-driver-by-def.patch \
    file://patches/320-MIPS-add-support-for-buggy-MT7621S-core-detection.patch \
    file://patches/322-mt7621-fix-cpu-clk-add-clkdev.patch \
    file://patches/323-mt7621-memory-detect.patch \
    file://patches/324-mt7621-perfctr-fix.patch \
    file://patches/325-mt7621-fix-memory-detect.patch \
    file://patches/400-mtd-cfi-cmdset-0002-force-word-write.patch \
    file://patches/405-mtd-spi-nor-Add-support-for-BoHong-bh25q128as.patch \
    file://patches/410-mtd-rawnand-add-driver-support-for-MT7621-nand-flash.patch \
    file://patches/411-dt-bindings-add-documentation-for-mt7621-nand-driver.patch \
    file://patches/700-net-ethernet-mediatek-support-net-labels.patch \
    file://patches/720-Revert-net-phy-simplify-phy_link_change-arguments.patch \
    file://patches/721-NET-no-auto-carrier-off-support.patch \
    file://patches/801-DT-Add-documentation-for-gpio-ralink.patch \
    file://patches/802-GPIO-MIPS-ralink-add-gpio-driver-for-ralink-SoC.patch \
    file://patches/803-gpio-ralink-Add-support-for-GPIO-as-interrupt-contro.patch \
    file://patches/804-staging-mt7621-pinctrl-use-ngpios-not-num-gpios.patch \
    file://patches/805-pinctrl-AW9523.patch \
    file://patches/810-uvc-add-iPassion-iP2970-support.patch \
    file://patches/820-DT-Add-documentation-for-spi-rt2880.patch \
    file://patches/821-SPI-ralink-add-Ralink-SoC-spi-driver.patch \
    file://patches/825-i2c-MIPS-adds-ralink-I2C-driver.patch \
    file://patches/830-mmc-MIPS-ralink-add-sdhci-for-mt7620a-SoC.patch \
    file://patches/835-asoc-add-mt7620-support.patch \
    file://patches/840-serial-add-ugly-custom-baud-rate-hack.patch \
    file://patches/845-pwm-add-mediatek-support.patch \
    file://patches/850-awake-rt305x-dwc2-controller.patch \
    file://patches/0001-puta-madre.patch \
"

# I couldn't apply these patches
#    file://patches/855-linkit_bootstrap.patch
#    file://patches/710-at803x.patch


PV = "${LINUX_VERSION}+git${SRCPV}"

KERNEL_VERSION_SANITY_SKIP="1"

DEPENDS+="image-patch-native xz-native u-boot-mkimage-native dtc-native openwrt-lzma-native"

COMPATIBLE_MACHINE ?= "(vocore2)"

do_patch:prepend() {
    cp -r device-trees/* ${S}/arch/mips/boot/dts/ralink
    cp -r sources/drivers ${S}/
}

do_configure:prepend() {
    rm -rf {B}/.config
}

do_compile:append () {
    cd ${B}
    make dtbs
}

do_uboot_mkimage() {
	ENTRYPOINT=${UBOOT_ENTRYPOINT}
	if [ -n "${UBOOT_ENTRYSYMBOL}" ]; then
		ENTRYPOINT=`${HOST_PREFIX}nm ${B}/vmlinux | \
			awk '$3=="${UBOOT_ENTRYSYMBOL}" {print "0x"$1;exit}'`
	fi

    #ENTRYPOINT=`readelf -h vmlinux | grep "Entry point address" | awk '{print $4}'`

    bbwarn "Entrypoint = $ENTRYPOINT"


    ${OBJCOPY} -O binary -R .reginfo -R .notes -R .note -R .comment -R .mdebug -R .note.gnu.build-id -S vmlinux vmlinux.bin
    cp arch/mips/boot/dts/ralink/vocore2.dtb ${B}
    # since the uboot I'm using is the stock one (and it's old), it requires the openwrt-lzma compression:
    patch-dtb vmlinux.bin vocore2.dtb
    openwrt-lzma e vmlinux.bin -lc1 -lp2 -pb2 vmlinux.bin.lzma

	uboot-mkimage -A ${UBOOT_ARCH} -O linux -T ${UBOOT_MKIMAGE_KERNEL_TYPE} -C "lzma" -a ${UBOOT_LOADADDRESS} -e $ENTRYPOINT -n "CocusWasHereWithYocto" -d vmlinux.bin.lzma ${B}/arch/${ARCH}/boot/uImage
	rm -f vmlinux.bin.lzma vocore2.dtb
}


# Disabling stripping.
# Allows kernel modules recompile. Vmlinux cannot be stripped for that.
##do_strip() {
##}
