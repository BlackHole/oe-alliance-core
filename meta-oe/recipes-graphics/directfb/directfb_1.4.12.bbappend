PACKAGE_ARCH = "${MACHINE_ARCH}"

RREPLACES_${PN} += "stm-directfb"
RCONFLICTS_${PN} += "stm-directb"

DEPENDS += " \
    ${@base_contains("BRAND_OEM", "fulan", "fulan-dvb-modules" , "", d)} \
"

SRC_URI_prepend_sh4 = " \
    file://directfb-1.4.12+STM2011.09.27-3.patch;patch=1 \
    file://directfb-1.4.11+STM2010.12.15-4.libpng.patch;patch=1 \
"

EXTRA_OECONF = "\
  --enable-freetype=yes \
  --disable-sdl \
  --enable-zlib \
  ${@base_contains("TARGET_ARCH", "sh4", "--with-gfxdrivers=stgfx", "--with-gfxdrivers=none", d)} \
  --disable-vnc \
  --disable-x11 \
  ${@base_contains("TARGET_ARCH", "sh4", "--disable-fbdev --disable-devmem --enable-mme --enable-stmfbdev", "", d)} \
"

FILES_${PN}_append_sh4 += "\
  ${libdir}/directfb-${RV}/gfxdrivers/*.so \
"

FILES_${PN}-dev_append_sh4 += "\
  ${libdir}/directfb-${RV}/gfxdrivers/*.la \
"

