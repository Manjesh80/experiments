package com.manjesh.guicedemo.di;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Created by aadhya on 10/31/2016.
 */
public class DIConfigurationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("lookupFilePath")).toInstance("./searchFlight.csv");

    }
}
