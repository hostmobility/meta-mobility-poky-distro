#!/bin/sh

# Generic Host modem manager for platforms with modem on

WVDIAL_CONF=/opt/host-modem-m/wvdial.conf

wvdial -C $WVDIAL_CONF
exit $?

