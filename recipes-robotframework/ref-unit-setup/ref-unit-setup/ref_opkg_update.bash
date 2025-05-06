#!/usr/bin/env bash

opkg update -f /etc/opkg/all-feed.conf || echo "Update failed"

opkg upgrade -f /etc/opkg/all-feed.conf || echo "Upgrade failed"
