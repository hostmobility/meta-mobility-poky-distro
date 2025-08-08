#!/bin/sh

# Host modem manager for Host Monitor Mini

MODEM_GPIO=$(gpiofind MODEM_ENABLE_ON)
if [ -z "$MODEM_GPIO" ]; then
  logger "Failed to find GPIO for MODEM_ENABLE_ON"
  exit 1
fi

modem_start()
{
  gpioset $MODEM_GPIO=1

  sleep 1

  WAIT_TIME=0
  WAIT_EXIT=1
  WAIT_TIME_OUT=60
  logger "Waiting for modem..."
  until [ $WAIT_EXIT -eq 0 ] || [ $WAIT_TIME -eq $WAIT_TIME_OUT ]; do
    if [ -e /dev/ttyUSB2 ]; then
      logger "Modem detected"
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
  wvdial
  exit $?
else
  modem_stop
  exit 1
fi

