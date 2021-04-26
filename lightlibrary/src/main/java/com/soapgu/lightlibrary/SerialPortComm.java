package com.soapgu.lightlibrary;

import android.serialport.SerialPort;

import com.orhanobut.logger.Logger;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SerialPortComm implements IComm {
    private SerialPort transport;
    private InputStream inputStream;
    private OutputStream outputStream;
    private boolean opened;


    @Override
    public synchronized void open() {
        if( !opened ) {
            try {
                transport = new SerialPort(new File("/dev/ttyS1"), 9600);
                inputStream = transport.getInputStream();
                outputStream = transport.getOutputStream();
                opened = true;
                this.send(new byte[]{(byte) 0xEE, (byte) 0xFF, (byte) 0x00});
            } catch (IOException e) {
                Logger.e( e ,"Serial port open FAILED");
            }

        }
    }

    @Override
    public synchronized void close() {
        if( opened ) {
            opened = false;
            try {
                inputStream.close();
            } catch (IOException e) {
                Logger.e( e, "close inputStream error" );
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                Logger.e( e, "close outputStream error" );
            }
            transport.close();
            Logger.i("-----Serial port Closed----");
        }
    }

    @Override
    public synchronized void send(byte[] body) {
        if (transport == null) return;
        if (!opened) return;

        try {
            outputStream.write(body);
            Logger.i( "Send data complete." );
        } catch (IOException e) {
            Logger.e( e ,"Serial port send FAILED");
        }
    }
}
