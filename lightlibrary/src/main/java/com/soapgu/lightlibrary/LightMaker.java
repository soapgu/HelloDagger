package com.soapgu.lightlibrary;

import android.serialport.SerialPort;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;

public class LightMaker {

    @Inject
    ISwitch lSwitch;
    @Inject
    IComm comm;

    public LightMaker() {
        //lSwitch = new RedSwitch();
        LightComponent component = DaggerLightComponent.create();
        component.inject(this);
    }

    public void on()
    {
        this.comm.send( lSwitch.on() );
    }

    public void off()
    {
        this.comm.send(lSwitch.off());
    }

    public void open() {
        this.comm.open();
    }

    public void close() {
        this.comm.close();
    }
}
