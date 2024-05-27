#!/bin/bash
#
# Copyright 2023-2024 Gaël PORTAY
#           2023-2024 Rtone
#
# SPDX-License-Identifier: LGPL-2.1-only
#

# An implementation of a customized RAUC system handler for the Raspberry Pi
# firmware.
#
# https://rauc.readthedocs.io/en/latest/using.html#system-based-customization-handlers
# https://rauc.readthedocs.io/en/latest/reference.html#handlers-section

# Output the board serial.
#
# https://github.com/raspberrypi/firmware/wiki/Mailbox-property-interface#get-board-serial
serial_number() {
	local hex_high hex_low
	local board_serial

	if ! read -a board_serial < <(vcmailbox 0x00010004 8 8 0 0) ||
	   [[ "${#board_serial[*]}" -ne 8 ]] || [[ ! "${board_serial[5]}" ]]
	then
		fdtget /sys/firmware/fdt / serial-number
		return
	fi

	hex_high="${board_serial[6]}"
	hex_low="${board_serial[5]}"
	printf "%x%x\n" "$((hex_high))" "$((hex_low))"
}

if serial_number="$(serial_number)"
then
	echo "RAUC_SYSTEM_SERIAL=$serial_number"
fi
