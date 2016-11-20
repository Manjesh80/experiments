package com.manjesh.guicedemo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.manjesh.guicedemo.module.GuideDemoModule;
import com.manjesh.guicedemo.service.DataProviderService;
import com.manjesh.guicedemo.service.ServiceConfig;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/17/2016.
 */
public class GuiceDemoFactory {

    private final Injector injector;

    public GuiceDemoFactory(AbstractModule guideModule) {
        injector = Guice.createInjector(guideModule);
    }

    public DataProviderService createDtaProviderService()
    {
         return injector.getInstance(DataProviderService.class);
    }

    public static GuiceDemoFactory create() {
        final GuiceDemoFactory guiceDemoFactory = new GuiceDemoFactory(new GuideDemoModule());
        return guiceDemoFactory;
    }

    private ServiceConfig getServiceConfig()
    {
        return new ServiceConfig();
    }
}
