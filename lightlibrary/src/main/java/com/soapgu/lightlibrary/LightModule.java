package com.soapgu.lightlibrary;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class LightModule {
    @Provides @IntoMap
    @StringKey("red")
    ISwitchCommand provideRedSwitch(){
        return new RedSwitchCommand();
    }

    @Provides @IntoMap
    @StringKey("yellow")
    ISwitchCommand provideYellowSwitch(){
        return new YellowSwitchCommand();
    }

    @Provides
    IComm provideComm(){
        return new SerialPortComm();
    }
}
