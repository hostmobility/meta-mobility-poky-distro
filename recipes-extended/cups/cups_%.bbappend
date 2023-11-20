#Change to root instead of lpadmin. Affect /etc/cups/cups-files.conf (SystemGroup)
EXTRA_OECONF = " \
               --enable-dbus \
               --with-dbusdir=${sysconfdir}/dbus-1 \
               --enable-browsing \
               --disable-gssapi \
               --enable-debug \
               --disable-relro \
               --enable-libusb \
               --with-system-groups=root \
               --with-cups-group=lp \
               --with-domainsocket=/run/cups/cups.sock \
               --with-pkgconfpath=${libdir}/pkgconfig \
               DSOFLAGS='${LDFLAGS}' \
               "