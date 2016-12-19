package com.manjesh.experiments.patterns.behaviour.strategy;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/19/2016.
 */
public class StrategyDemo {

    public static void main(String[] args) {
        CompressionContext compressionContext = new CompressionContext();
        compressionContext.setCompressionStrategy(new ZipCompressionStrategy());
        compressionContext.compressFiles(null);
    }
}
