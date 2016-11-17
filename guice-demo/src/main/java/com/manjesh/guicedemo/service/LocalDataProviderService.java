package com.manjesh.guicedemo.service;

import java.util.Arrays;
import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/17/2016.
 */
public class LocalDataProviderService implements DataProviderService {

    @Override
    public List<String> getData() {
        return Arrays.asList("Data from local system");
    }

    @Override
    public void close() throws Exception {

    }
}
