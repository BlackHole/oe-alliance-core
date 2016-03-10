SUMMARY = "OpenBH Base"
MAINTAINER = "OpenBH"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"
PACKAGES = "${PN}"

PV = "${IMAGE_VERSION}"
PR = "r0"

inherit packagegroup

DEPENDS = "openbh-version-info"

RDEPENDS_${PN} = "\
    oe-alliance-base \
    openbh-version-info \
    openbh-enigma2 \
    openbh-bootlogo \
    openbh-spinner \
    blackhole-base \
    blackholesocker \
    mc \
    openvpn \
    libcrypto-compat-0.9.7 \
    "

