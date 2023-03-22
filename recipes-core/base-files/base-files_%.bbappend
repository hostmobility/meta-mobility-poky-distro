FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# add empty folder for mount point for sdcard.
do_install:append() {
  install -d ${D}/media/sdcard
  install -d ${D}/mnt/config
}