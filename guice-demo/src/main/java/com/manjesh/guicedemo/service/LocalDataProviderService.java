package com.manjesh.guicedemo.service;

import com.google.inject.Inject;

import java.util.Arrays;
import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/17/2016.
 */
public class LocalDataProviderService implements DataProviderService {

    //final private ServiceConfig serviceConfig;
    final private ConfigurationService configurationService;

    @Inject
    public LocalDataProviderService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @Override
    public List<String> getData() {
        return Arrays.asList(configurationService.getConfigurationService());
    }

    @Override
    public void close() throws Exception {

    }
}
