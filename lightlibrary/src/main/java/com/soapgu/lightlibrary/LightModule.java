package com.soapgu.lightlibrary;

import dagger.Module;
import dagger.Provides;

@Module
public class LightModule {
    @Provides
    ISwitch provideSwitch(){
        return new RedSwitch();
    }
}
