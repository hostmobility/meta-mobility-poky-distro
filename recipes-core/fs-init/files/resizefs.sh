#!/bin/sh
# resize the rootfs ext filesystem size to its full partition size
# usually used on first boot in a postinstall script
# or set in an autostart file from a postinstall script

if [ -z $1 ]; then
    echo "Missing in parameter to target DISK (mmcblkX)"
    exit 1
fi

if [ -z $2 ]; then
    echo "Missing in parameter to target PART ($1pX)"
    exit 1
fi
DISK="$1"
PART="$2"

if grep "/$DISK" /proc/cmdline; then

    logger "resizing ${DISK}p$PART to fill its full partition size"
    # get the disk total size
    #DISK_SIZE=`cat /sys/block/$DISK/size`

    # get partition start and size
    PART_OFF=$(cat /sys/block/$DISK/${DISK}p$PART/start)
    #PART_SIZE=`cat /sys/block/$DISK/${DISK}p$PART/size`

    # Resize now
    if [ -f "/opt/hm/mx4_env" ]; then
        #For mx4 use one less \n before $PART_OFF for some strnge reason. 
        #if the mx4_env is not there we assume machines like Mxv.
        printf "d\n$PART\nn\np\n$PART_OFF\n\nw\n" | fdisk -B  /dev/${DISK}
    else
        printf "d\n$PART\nn\np\n\n$PART_OFF\n\nw\n" | fdisk -B  /dev/${DISK}
    fi

    resize2fs /dev/${DISK}p$PART

    #Check size or reboot might be needed to get full resize.
    DISK_SPACE_AVAILABLE=$(df --output=avail "$PWD" | sed '1d;s/[^0-9]//g')
    if (( DISK_SPACE_AVAILABLE <= 1000000 )); then
        echo "Warning: too little space available: $(df --output=avail -h ),\n rebooting system..."  | systemd-cat -p emerg
        reboot
        exit 1
    fi
    #job done, remove it from systemd services
    systemctl --no-reload disable resizefs.service

    logger "resizing ${DISK}p$PART finished, new size is $(df --output=avail -h )"
else
    echo "$(cat /proc/cmdline) is not target eMMC(${DISK}p$PART). Skip resize eMMC and exit 1"
    exit 1
fi
