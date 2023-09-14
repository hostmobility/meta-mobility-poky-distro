#Change to root instead of lpadmin. Affect /etc/cups/cups-files.conf (SystemGroup)
GROUPADD_PARAM:${PN} = "--system root"