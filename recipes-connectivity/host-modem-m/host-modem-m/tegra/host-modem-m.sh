#!/bin/sh

# Host modem manager for MX-4 T30 with PLS-8

CTRL_MODEM_ON=/opt/hm/pic_attributes/ctrl_modem_on
if [ -z "$CTRL_MODEM_ON" ]; then
  logger "Failed to find $CTRL_MODEM_ON"
  exit 1
fi

modem_start()
{
  WAIT_TIME=0
  WAIT_EXIT=1
  logger "check co cpu modem status"
  until [ $WAIT_EXIT -eq 0 ] || [ $WAIT_TIME -eq 5 ]; do
    echo 1 > $CTRL_MODEM_ON
    sleep 6
    CTRL_STATE=$(/opt/hm/modem_status.sh | grep "Ctrl state" | awk '{print $3}')
    if [ "$CTRL_STATE" = "ON" ]; then
      logger "modem started"
      WAIT_EXIT=0
    fi
    WAIT_TIME=$((WAIT_TIME+1))

  done
  sleep 1

  WAIT_TIME=0
  WAIT_EXIT=1
  WAIT_TIME_OUT=60
  logger "Determining modem type..."
  until [ $WAIT_EXIT -eq 0 ] || [ $WAIT_TIME -eq $WAIT_TIME_OUT ]; do
    if [ -e /dev/ttyACM2 ]; then
      logger "PLS-8 modem detected"
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
  echo 0 > $CTRL_MODEM_ON
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
