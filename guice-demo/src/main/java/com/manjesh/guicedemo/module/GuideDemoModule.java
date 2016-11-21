package com.manjesh.guicedemo.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.manjesh.guicedemo.launcher.DynamicSource;
import com.manjesh.guicedemo.service.ConfigurationService;
import com.manjesh.guicedemo.service.DataProviderService;
import com.manjesh.guicedemo.service.DynamicConfigurationService;
import com.manjesh.guicedemo.service.RemoteDataProviderService;
import com.manjesh.guicedemo.service.ServiceConfig;
import com.manjesh.guicedemo.service.StaticConfigurationService;
import com.manjesh.guicedemo.service.WebLogger;
import com.manjesh.guicedemo.service.WebLoggerImpl;
import com.manjesh.guicedemo.utils.GuiceUtils;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/17/2016.
 */
public class GuideDemoModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(DataProviderService.class).to(RemoteDataProviderService.class);
        bind(ConfigurationService.class).annotatedWith(DynamicSource.class).to(DynamicConfigurationService.class);
        bind(ConfigurationService.class).to(StaticConfigurationService.class);
        bind(WebLogger.class).to(WebLoggerImpl.class);
        bindConstant().annotatedWith(Names.named("dateFormat")).to("dd-mm-yyyy");
        requestStaticInjection(GuiceUtils.class);
        //bind(DataProviderService.class).toInstance(new RemoteDataProviderService(new ServiceConfig()));
    }
}
