package com.manjesh.guicedemo.service;

import com.google.inject.ImplementedBy;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/18/2016.
 */
@ImplementedBy(StaticConfigurationService.class)
public interface ConfigurationService {
    public String getConfigurationService();
}
