package com.manjesh.guicedemo.service;

import com.google.inject.Inject;
import com.manjesh.guicedemo.launcher.DynamicSource;

import java.util.Arrays;
import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/17/2016.
 */
public class RemoteDataProviderService implements DataProviderService {

    //final private ServiceConfig serviceConfig;
    final private ConfigurationService configurationService;
    @Inject
    public WebLogger webLogger;

    @Inject
    public RemoteDataProviderService( @DynamicSource ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @Override
    public List<String> getData() {
        webLogger.log("Ganesh weblogger invoked");
        return Arrays.asList(configurationService.getConfigurationService());
    }

    @Override
    public void close() throws Exception {

    }
}
