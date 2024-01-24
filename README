## meta-cocus-vocore2
An OpenEmbedded BSP Yocto Layer for the VoCore2 module.

Based on https://gitlab.com/wtolkien/meta-mediatek

Uses an SD card for the rootfs since this uses systemd and it's not tailored to fit in the SPI memory. Maybe someday :)

## Installation
This was tested on Ubuntu 20.04 LTS, and should work on 22.04 as well.

First of all, install the required packages, for example on Ubuntu:
```
sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
    build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
    xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev \
    pylint3 xterm
```

Clone Yocto Kirkstone:
```
git clone git://git.yoctoproject.org/poky -b kirkstone
```

Clone meta-openembedded and this layer into the poky directory:
```
cd poky/
git clone git://git.openembedded.org/meta-openembedded -b kirkstone
git clone https://github.com/cocus/meta-cocus-vocore2.git
```

Run this once to initialize a build directory with this layer set as the template conf:
```
TEMPLATECONF=meta-cocus-vocore2/conf source oe-init-build-env
```

Once the build dir is initialized, just run:
```
source oe-init-build-env
```

Make a build:
```
bitbake core-image-custom
```

Grab the resuling `uImage` and rootfs files. Flash the `uImage` where the Kernel resides on the SPI flash, and dd the rootfs into an SD card.

