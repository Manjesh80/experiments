package com.manjesh.experiments.demologger;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/28/2016.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoLogger {

    private static Logger log = LoggerFactory.getLogger(DemoLogger.class);

    public static void main(String[] args) {
        log.error("Where is the file");
    }
}
