package com.soapgu.lightlibrary;

public class RedSwitchCommand extends SwitchCommandBase {
    @Override
    public byte[] on() {
        return new byte[]{(byte) 0xFF, (byte) 0xAA, (byte) 0x00};
    }
}
