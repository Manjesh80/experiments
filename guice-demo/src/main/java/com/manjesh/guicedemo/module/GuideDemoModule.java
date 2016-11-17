package com.manjesh.guicedemo.module;

import com.google.inject.AbstractModule;
import com.manjesh.guicedemo.service.DataProviderService;
import com.manjesh.guicedemo.service.RemoteDataProviderService;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/17/2016.
 */
public class GuideDemoModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(DataProviderService.class).to(RemoteDataProviderService.class);
    }
}
