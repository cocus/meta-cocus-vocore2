SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL:append = " \
    usbutils \
    htop \
    openssh \
    mt76-firmware \
    wpa-supplicant \
    wireless-regdb-static \
    i2c-tools \
    nano \
    mtd-utils \
    stress-ng \
    openocd \
"
# TODO: re-add: iw
IMAGE_INSTALL:remove = "busybox-hwclock"

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

#This function removes everything under /boot/
#
my_empty_boot() {
    rm -rf ${IMAGE_ROOTFS}/boot
}

ROOTFS_POSTINSTALL_COMMAND += " my_empty_boot; "
