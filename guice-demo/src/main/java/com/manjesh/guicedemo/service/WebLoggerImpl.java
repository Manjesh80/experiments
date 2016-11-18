package com.manjesh.guicedemo.service;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/18/2016.
 */
public class WebLoggerImpl implements WebLogger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
