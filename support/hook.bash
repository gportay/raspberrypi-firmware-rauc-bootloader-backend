#!/bin/bash
#
# Copyright 2024 Gaël PORTAY
#           2024 Rtone
#
# SPDX-License-Identifier: LGPL-2.1-only
#

set -e

slot_pre_install() {
	echo "root=$RAUC_SLOT_DEVICE console=tty1 console=serial0" >"$RUNTIME_DIRECTORY/cmdline.txt"
}

slot_post_install() {
	cp "$RUNTIME_DIRECTORY/cmdline.txt" "$RAUC_SLOT_MOUNT_POINT/cmdline.txt.tmp"
	mv "$RAUC_SLOT_MOUNT_POINT/cmdline.txt"{.tmp,}
	rm -f "$RAUC_SLOT_MOUNT_POINT/cmdline.txt.tmp"
}

if [ "$1" = "slot-pre-install" ]
then
	shift
	slot_pre_install "$@"
elif [ "$1" = "slot-post-install" ]
then
	shift
	slot_post_install "$@"
fi
