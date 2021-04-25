package com.soapgu.lightlibrary;

public class RedSwitch implements ISwitch {
    @Override
    public byte[] on() {
        return new byte[]{(byte) 0xFF, (byte) 0xAA, (byte) 0x00};
    }

    @Override
    public byte[] off() {
        return new byte[]{(byte) 0xFF, (byte) 0xAA, (byte) 0xFF};
    }
}
