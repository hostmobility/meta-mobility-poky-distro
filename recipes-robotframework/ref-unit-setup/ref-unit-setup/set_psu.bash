#!/usr/bin/env bash

BAUD=19200
TTY_HANDLE=/dev/ttyACM0

function print_usage() {
  echo "Usage: $0 OPTION..."
  echo
  echo "Options:"
  echo "  -h, --help             Print this usage and exit"
  echo "  -s, --set [option]     Set PSU to on or off"
}

function parse_params() {
  while [[ $# -gt 0 ]]; do
    case "$1" in
      -h|--help)
        print_usage
        exit 0
        ;;
      -s|--set)
        shift
        if [[ "$1" == "on" ]]; then
          STATE=on
        elif [[ "$1" == "off" ]]; then
          STATE=off
        else
          echo "Invalid value for --set: $1"
          exit 1
        fi
        ;;
      -*)
        echo "Unknown option: $1"
        print_usage
        exit 1
        ;;
      *)
        break
        ;;
    esac
    shift
  done
}

if [[ $# -eq 0 ]]; then
  print_usage
  exit 1
fi

parse_params "$@"

if [[ -z "$STATE" ]]; then
  echo "Missing or invalid --set option"
  print_usage
  exit 1
fi

if [[ "$STATE" == "on" ]]; then
  echo -ne "OUT1" | microcom -s $BAUD $TTY_HANDLE -t 200
elif [[ "$STATE" == "off" ]]; then
  echo -ne "OUT0" | microcom -s $BAUD $TTY_HANDLE -t 200
fi
