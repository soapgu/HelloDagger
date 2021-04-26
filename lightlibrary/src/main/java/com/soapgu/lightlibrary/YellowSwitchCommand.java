package com.soapgu.lightlibrary;

public class YellowSwitchCommand implements ISwitchCommand {
    @Override
    public byte[] on() {
        return new byte[]{(byte) 0xFF, (byte) 0xAA, (byte) 0x0A};
    }

    @Override
    public byte[] off() {
        return new byte[]{(byte) 0xFF, (byte) 0xAA, (byte) 0xFF};
    }
}
