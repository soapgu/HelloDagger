package com.soapgu.lightlibrary;

public class YellowSwitchCommand extends SwitchCommandBase {
    @Override
    public byte[] on() {
        return new byte[]{(byte) 0xFF, (byte) 0xAA, (byte) 0x0A};
    }
}
