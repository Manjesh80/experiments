package com.manjesh.experiments.patterns.behaviour.strategy;

import java.io.File;
import java.util.ArrayList;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/19/2016.
 */
public class CompressionContext {

    private CompressionStrategy compressionStrategy;

    public void setCompressionStrategy(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }

    public void compressFiles(ArrayList<File> files){
        compressionStrategy.compressFiles(files);
    }
}
