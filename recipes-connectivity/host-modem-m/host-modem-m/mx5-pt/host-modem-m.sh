#!/bin/sh

# Host modem manager for MX-V with EG25-G

WVDIAL_CONF=/opt/host-modem-m/onomondo-wvdial.conf

MODEM_GPIO=$(gpiofind MODEM_ENABLE_ON)
if [ -z "$MODEM_GPIO" ]; then
  logger "Failed to find GPIO for MODEM_ENABLE_ON"
  exit 1
fi

modem_start()
{
  gpioset $MODEM_GPIO=1

  ## If we need to control two sims in the future, sim1 is controlled by 0 and sim2 by 1.
  ##  gpioset $(gpiofind SIM_SEL)=0
  ##  if [ $? != 0 ]; then
  ##    echo "FAILED gpioset (gpiofind SIM_SEL!" >> $SETUP_LOG
  ##  fi

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

modem_stop()
{
  gpioset $MODEM_GPIO=0
}

modem_start
RET=$?
if [ $RET = 0 ]; then
  wvdial -C $WVDIAL_CONF
  exit $?
else
  modem_stop
  exit 1
fi
