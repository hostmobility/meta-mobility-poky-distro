#!/usr/bin/env bash

# Copyright (c) 2023 Host Mobility

#Start Hostmobility Production tester prestart Setup.

echo "Setup CAN channels so they will not lock us out with sleeping trancivers."
for ((i=0;i<6;i++));do ip link set can$i down; ip link set can$i up type can bitrate 500000 dbitrate 4000000 fd on restart-ms 1000; done


