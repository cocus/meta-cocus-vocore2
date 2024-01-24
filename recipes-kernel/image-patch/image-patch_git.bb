DESCRIPTION = "Openwrt tool for pathcing an image with DTB file."
SECTION = "Openwrt tools."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/openwrt/openwrt.git;rev=94198e2a1c26b75cc1b349f758273bc678569ce9;protocol=https;branch=master"

S = "${WORKDIR}/git/tools/patch-image/src"

BBCLASSEXTEND="native nativesdk"

FILES_${PN}_class-native="${D}/${bindir}/*"

do_compile:class-native () {
    ${CC} patch-dtb.c ${LDFLAGS} -o patch-dtb
}

do_install(){
    install -d ${D}/${bindir}/
    install -m 0755 ${S}/patch-dtb ${D}/${bindir}/ 
}
