package com.soapgu.lightlibrary;

public class YellowSwitch implements ISwitch {
    @Override
    public byte[] on() {
        return new byte[]{(byte) 0xFF, (byte) 0xAA, (byte) 0x0A};
    }

    @Override
    public byte[] off() {
        return new byte[]{(byte) 0xFF, (byte) 0xAA, (byte) 0xFF};
    }
}
