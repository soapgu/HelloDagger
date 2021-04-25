package com.soapgu.lightlibrary;

import dagger.Component;

@Component(modules = LightModule.class)
public interface LightComponent {
    void inject(LightMaker maker);
}
