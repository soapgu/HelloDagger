package com.soapgu.lightlibrary;

import android.serialport.SerialPort;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;

public class LightMaker {
    private SerialPort transport;
    private InputStream inputStream;
    private OutputStream outputStream;
    private boolean opened;

    @Inject
    ISwitch lSwitch;

    public LightMaker() {
        //lSwitch = new RedSwitch();
        LightComponent component = DaggerLightComponent.create();
        component.inject(this);
    }

    public void on()
    {
        this.send( lSwitch.on() );
    }

    public void off()
    {
        this.send(lSwitch.off());
    }

    public synchronized void open() throws IOException{
        if( !opened ) {
            opened =true;
            transport = new SerialPort(new File("/dev/ttyS1"), 9600);
            inputStream = transport.getInputStream();
            outputStream = transport.getOutputStream();
            this.send(new byte[]{(byte) 0xEE, (byte) 0xFF, (byte) 0x00});
        }
    }

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
