#!/bin/bash

#
# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation; either version 2 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program; if not, see <http://www.gnu.org/licenses/>.

set -e

# command line parameters
command="$1" # "up" or "down"
udc_device="$2" # a udc device name, such as "musb-hdrc.1.auto"

g="/sys/kernel/config/usb_gadget/g1"

hm_usb_up() {
    usb_ver="0x0200"
    dev_class="2" 
    vid="0x1b67" 
    pid="0x400c" 
    device="0x01"
    mfg="HostMobility" 
    prod="Host"

    serial="123456789"
	#serial form /etc/hostname
    attr="0xC0" 
    pwr="1" 
    cfg1="CDC"
    cfg2="RNDIS"

    dev_mac1="04:1B:94:00:00:01"
    host_mac1="04:1B:94:00:00:02"
    dev_mac2="04:1B:94:00:00:03"
    host_mac2="04:1B:94:00:00:04"
    ms_vendor_code="0xcd" 
    ms_qw_sign="MSFT100" 
    ms_compat_id="RNDIS"
    ms_subcompat_id="5162001"


    if [ -d ${g} ]; then
        if [ "$(cat ${g}/UDC)" != "" ]; then
            exit 0
        fi
        hm_usb_down
    fi


    mkdir ${g}
    echo "${usb_ver}" > ${g}/bcdUSB
    echo "${dev_class}" > ${g}/bDeviceClass
    echo "${vid}" > ${g}/idVendor
    echo "${pid}" > ${g}/idProduct
    echo "${device}" > ${g}/bcdDevice
    mkdir ${g}/strings/0x409
    echo "${mfg}" > ${g}/strings/0x409/manufacturer
    echo "${prod}" > ${g}/strings/0x409/product
    echo "${serial}" > ${g}/strings/0x409/serialnumber


    mkdir ${g}/configs/c.1
    echo "${attr}" > ${g}/configs/c.1/bmAttributes
    echo "${pwr}" > ${g}/configs/c.1/MaxPower
    mkdir ${g}/configs/c.1/strings/0x409
    echo "${cfg1}" > ${g}/configs/c.1/strings/0x409/configuration

    mkdir ${g}/functions/ecm.usb0
    echo "${dev_mac1}" > ${g}/functions/ecm.usb0/dev_addr
    echo "${host_mac1}" > ${g}/functions/ecm.usb0/host_addr

    mkdir ${g}/configs/c.2
    echo "${attr}" > ${g}/configs/c.2/bmAttributes
    echo "${pwr}" > ${g}/configs/c.2/MaxPower
    mkdir ${g}/configs/c.2/strings/0x409
    echo "${cfg2}" > ${g}/configs/c.2/strings/0x409/configuration

    echo "1" > ${g}/os_desc/use
    echo "${ms_vendor_code}" > ${g}/os_desc/b_vendor_code
    echo "${ms_qw_sign}" > ${g}/os_desc/qw_sign

    mkdir ${g}/functions/rndis.usb0
    echo "${dev_mac2}" > ${g}/functions/rndis.usb0/dev_addr
    echo "${host_mac2}" > ${g}/functions/rndis.usb0/host_addr
    echo "${ms_compat_id}" > ${g}/functions/rndis.usb0/os_desc/interface.rndis/compatible_id
    echo "${ms_subcompat_id}" > ${g}/functions/rndis.usb0/os_desc/interface.rndis/sub_compatible_id

    ln -s ${g}/functions/ecm.usb0 ${g}/configs/c.1
    ln -s ${g}/functions/rndis.usb0 ${g}/configs/c.2
    ln -s ${g}/configs/c.2 ${g}/os_desc
    echo "${udc_device}" > ${g}/UDC

    exit 0
}

hm_usb_down() {
    if [ ! -d ${g} ]; then
        exit 0
    fi

    if [ "$(cat ${g}/UDC)" != "" ]; then
        echo "" > ${g}/UDC
    fi
    rm -f ${g}/os_desc/c.2
    rm -f ${g}/configs/c.2/rndis.usb0
    rm -f ${g}/configs/c.1/ecm.usb0
    [ -d ${g}/functions/ecm.usb0 ] && rmdir ${g}/functions/ecm.usb0
    [ -d ${g}/functions/rndis.usb0 ] && rmdir ${g}/functions/rndis.usb0
    [ -d ${g}/configs/c.2/strings/0x409 ] && rmdir ${g}/configs/c.2/strings/0x409
    [ -d ${g}/configs/c.2 ] && rmdir ${g}/configs/c.2
    [ -d ${g}/configs/c.1/strings/0x409 ] && rmdir ${g}/configs/c.1/strings/0x409
    [ -d ${g}/configs/c.1 ] && rmdir ${g}/configs/c.1
    [ -d ${g}/strings/0x409 ] && rmdir ${g}/strings/0x409
    rmdir ${g}
	exit 0
}

case ${command} in

up)
    hm_usb_up
    ;;
down)
    hm_usb_down
    ;;
*)
    echo "Usage: hm-usb.sh up|down <udc_device>"
    exit 1
    ;;
esac
