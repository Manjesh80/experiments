package com.manjesh.guicedemo;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Created by aadhya on 10/31/2016.
 */
public class LookupProvider {

    @Inject @Named("lookupFilePath")
    private final String lookupFilePath;

    public LookupProvider(String lookupFilePath) {
        this.lookupFilePath = lookupFilePath;
    }

    public String getLookupFilePath() {
        return lookupFilePath;
    }
}
