#!/usr/bin/env bash
function modem_start()
{
    # Is the machine MX-V?
    if gpiofind MODEM_ENABLE_ON; then
        if gpioset $(gpiofind MODEM_ENABLE_ON)=1; then
        echo "FAILED gpioset (gpiofind MODEM_ENABLE_ON)!"
        fi
    ## If we need to control two sim in this test in th future sim1 is controlled by a 0 and sim2 by 1.
    ##  gpioset $(gpiofind SIM_SEL)=0
    ##  if [ $? != 0 ]; then
    ##echo "FAILED gpioset (gpiofind SIM_SEL!" >> $SETUP_LOG
    ##fi
    else
    # Assume MX-4
        WAIT_TIME=0
        WAIT_EXIT=1
        logger "check co cpu modem status"
        until [ $WAIT_EXIT -eq 0 ] || [ $WAIT_TIME -eq 5 ]; do
        echo 1 > /opt/hm/pic_attributes/ctrl_modem_on
        sleep 6
        CTRL_STATE=$(/opt/hm/modem_status.sh | grep "Ctrl state" | awk '{print $3}')
        if [[ "$CTRL_STATE" == "ON" ]]; then
            logger "modem started"
            WAIT_EXIT=0
        fi
        WAIT_TIME=$((WAIT_TIME+1))

        done
    fi
        sleep 1

    WAIT_TIME=0
    WAIT_EXIT=1
    WAIT_TIME_OUT=60
    logger "Determining modem type..."
    until [ $WAIT_EXIT -eq 0 ] || [ $WAIT_TIME -eq $WAIT_TIME_OUT ]; do
    if [ -e /dev/ttyUSB2 ]; then 
        logger "EG25-G modem detected"
        WAIT_EXIT=0
    fi
    WAIT_TIME=$((WAIT_TIME+1))
    sleep 1
    done

    if [ $WAIT_TIME -eq $WAIT_TIME_OUT ]; then
    logger "FAILED to start Modem, try again!"
    return 1
    fi

    return 0
}

function modem_stop()
{
    if gpiofind MODEM_ENABLE_ON; then
        if gpioset $(gpiofind MODEM_ENABLE_ON)=0; then
        echo "FAILED gpioset (gpiofind MODEM_ENABLE_ON)!"
        fi
    else
        echo 0 > /opt/hm/pic_attributes/ctrl_modem_on
    fi
}


modem_start
RET=$?
if (( RET == 0 )); then
    wvdial -C /opt/host-insight-m/onomondo-wvdial.conf
    exit $?
else
    modem_stop
    exit 1
fi
