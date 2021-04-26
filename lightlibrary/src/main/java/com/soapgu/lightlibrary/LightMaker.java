package com.soapgu.lightlibrary;

import android.serialport.SerialPort;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Objects;

import javax.inject.Inject;

public class LightMaker {

    @Inject
    Map<String, ISwitch> lSwitch;
    @Inject
    IComm comm;

    public LightMaker() {
        //lSwitch = new RedSwitch();
        LightComponent component = DaggerLightComponent.create();
        component.inject(this);
    }

    public void on( String tag )
    {
        this.comm.send( Objects.requireNonNull(lSwitch.get(tag)).on() );
    }

    public void off(String tag)
    {
        this.comm.send(Objects.requireNonNull(lSwitch.get(tag)).off());
    }

    public void open() {
        this.comm.open();
    }

    public void close() {
        this.comm.close();
    }
}
