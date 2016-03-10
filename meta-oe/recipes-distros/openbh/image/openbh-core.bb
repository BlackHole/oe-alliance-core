SUMMARY = "OpenBH Core"
MAINTAINER = "OpenBH"

require conf/license/license-gplv2.inc

DEPENDS = "enigma2 python-process libcrypto-compat-0.9.7"
RDEPENDS_enigma2-plugin-bh-core = "ofgwrite python-process libcrypto-compat-0.9.7 python-compression zip procps python-beautifulsoup"

PROVIDES += "openbh-core"
RPROVIDES_enigma2-plugin-bh-core += "openbh-core"

inherit autotools-brokensep gitpkgv pythonnative
SRCREV = "${AUTOREV}"
PV = "${IMAGE_VERSION}+git${SRCPV}"
PKGV = "${IMAGE_VERSION}+git${GITPKGV}"
PR = "r0"

SRC_URI="git://github.com/OpenViX/vix-core.git;protocol=git"

S = "${WORKDIR}/git"

EXTRA_OECONF = "\
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    "

PACKAGES =+ "enigma2-plugin-bh-core"
PACKAGES =+ "enigma2-plugin-bh-core-src"
PACKAGES =+ "enigma2-plugin-bh-core-po"
CONFFILES_enigma2-plugin-bh-core += "${sysconfdir}/exports"
FILES_enigma2-plugin-bh-core = "/etc /usr/lib"
FILES_enigma2-plugin-bh-core-dbg = "/usr/lib/enigma2/python/Plugins/SystemPlugins/ViX/.debug/"
FILES_enigma2-plugin-bh-core-src = "/usr/lib/enigma2/python/Plugins/SystemPlugins/ViX/*.py"
FILES_enigma2-plugin-bh-core-po = "/usr/lib/enigma2/python/Plugins/SystemPlugins/ViX/locale/*.po"
FILES_enigma2-plugin-bh-core-doc = "/usr/share/enigma2/README*"

do_install_append() {
    if [ -f ${DEPLOY_DIR_IMAGE}/burn.bat ]; then
        install -m 755 ${DEPLOY_DIR_IMAGE}/burn.bat ${D}/usr/lib/enigma2/python/Plugins/SystemPlugins/ViX/burn.bat
    fi
}
