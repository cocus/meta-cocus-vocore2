DESCRIPTION = "Openwrt backports tool for handling kconfig data."
SECTION = "Openwrt tools."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PKG_VERSION = "5.15.81"
PKG_RELEASE = "1"

# Modify these as desired
#PV = "1.0+git${SRCPV}"
#SRCREV = "${AUTOREV}"

SRC_URI[sha256sum] = "8d84d1dc1b424d2f2df3afffaca0635023d345c4671562292aca414ab819b433"

SRC_URI = " \
	https://cdn.kernel.org/pub/linux/kernel/projects/backports/stable/v${PKG_VERSION}/backports-${PKG_VERSION}-${PKG_RELEASE}.tar.gz \
"

S = "${WORKDIR}/backports-${PKG_VERSION}-${PKG_RELEASE}/kconf"

BBCLASSEXTEND="native nativesdk"

FILES_${PN}:class-native="${D}/${bindir}/*"

DEPENDS:class-native += "bc-native bison-native flex-native"

do_compile:class-native () {
    make LEX=flex mconf
    make LEX=flex conf
}

do_install(){
    install -d ${D}/${bindir}/
    install -m 0755 ${S}/mconf ${D}/${bindir}/ 
    install -m 0755 ${S}/conf ${D}/${bindir}/ 
}
