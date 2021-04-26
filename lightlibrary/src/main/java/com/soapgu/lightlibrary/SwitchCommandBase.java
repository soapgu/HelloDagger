package com.soapgu.lightlibrary;

public abstract class SwitchCommandBase implements ISwitchCommand {
    public abstract byte[] on();
    public final byte[] off() {
        return new byte[]{(byte) 0xFF, (byte) 0xAA, (byte) 0xFF};
    }
}
