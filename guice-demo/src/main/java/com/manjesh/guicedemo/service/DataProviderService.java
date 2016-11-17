package com.manjesh.guicedemo.service;

import java.io.Serializable;
import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/17/2016.
 */
public interface DataProviderService extends Serializable, AutoCloseable {
    List<String> getData();
}
