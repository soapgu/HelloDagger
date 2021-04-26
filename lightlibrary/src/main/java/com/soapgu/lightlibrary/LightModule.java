package com.soapgu.lightlibrary;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class LightModule {
    @Provides @IntoMap
    @StringKey("red")
    ISwitch provideRedSwitch(){
        return new RedSwitch();
    }

    @Provides @IntoMap
    @StringKey("yellow")
    ISwitch provideYellowSwitch(){
        return new YellowSwitch();
    }

    @Provides
    IComm provideComm(){
        return new SerialPortComm();
    }
}
