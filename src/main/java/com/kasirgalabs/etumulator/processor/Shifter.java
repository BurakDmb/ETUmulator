/*
 * Copyright (C) 2017 Kasirgalabs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.kasirgalabs.etumulator.processor;

import com.kasirgalabs.etumulator.operand2.Shift;

public class Shifter {
    private boolean carry;

    public void setCarry(boolean carry) {
        this.carry = carry;
    }

    public int shift(int value, int shiftAmount, int option) {
        if(shiftAmount <= 0) {
            return value;
        }
        int temp = value;
        switch(option) {
            case Shift.ASR:
                temp = value >> shiftAmount;
                break;
            case Shift.LSL:
                temp = value << shiftAmount;
                break;
            case Shift.LSR:
                temp = value >>> shiftAmount;
                break;
            case Shift.ROR:
                temp = Integer.rotateRight(value, shiftAmount);
                break;
        }
        return temp;
    }

    public int rrxShift(int value) {
        int result = value >>> 1;
        if(carry) {
            result |= 0x80000000;
        }
        return result;
    }
}
