SUMMARY = "An implementation of a RAUC custom bootloader backend for the \
           Raspberry Pi firmware."
HOMEPAGE = "https://github.com/gportay/raspberrypi-firmware-rauc-bootloader-backend"
BUGTRACKER = "https://github.com/gportay/raspberrypi-firmware-rauc-bootloader-backend/issues"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742"

PV = "1.0+git${SRCPV}"
SRC_URI = "git://github.com/gportay/raspberrypi-firmware-rauc-bootloader-backend.git;protocol=https;branch=main"
SRC_URI[sha256sum] = "6b3f2cdfff6936756390b47cfe1a0ec5d5e4a58a784d54475edc79fd68417790"
SRCREV = "1ecbd17d9e3b41f0faeccadb75a42460f3b3ce78"

S = "${WORKDIR}/git"

do_configure() {
	:
}

do_compile() {
	:
}

do_install() {
	install -D -m755 ${S}/system-info ${D}${libdir}/raspberrypi-firmware-rauc-bootloader-backend/system-info
	install -D -m755 ${S}/bootloader-custom-backend ${D}${libdir}/raspberrypi-firmware-rauc-bootloader-backend/bootloader-custom-backend
}

RDEPENDS:${PN} += "bash userland dtc"
RRECOMMENDS:${PN} += "rauc"
