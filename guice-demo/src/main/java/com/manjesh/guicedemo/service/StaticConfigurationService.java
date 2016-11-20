package com.manjesh.guicedemo.service;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/18/2016.
 */
public class StaticConfigurationService implements ConfigurationService{

    @Override
    public String getConfigurationService() {
        return "Static Configuration Service";
    }
}
