package com.manjesh.guicedemo.service;

import java.util.Arrays;
import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/17/2016.
 */
public class RemoteDataProviderService implements DataProviderService {

    @Override
    public List<String> getData() {
        return Arrays.asList("Data from remote system");
    }

    @Override
    public void close() throws Exception {

    }
}
