package com.manjesh.guicedemo.service;

import lombok.Data;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/17/2016.
 */
@Data
public class ServiceConfig {

    private int retryCount;
    private int messageThreshold;

}
