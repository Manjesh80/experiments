package com.manjesh.experiments.ocjp.nio2;

import java.net.MalformedURLException;
import java.nio.file.*;

/**
 * Created by aadhya on 12/3/2016.
 */
public class DemoNIO {

    public static void main(String[] args) throws Exception {

        testPath();

    }

    private static void testPath() throws Exception {
        Path testFilePath = Paths.get(".\\log.txt");

        // retrieve basic information about path
        print("Printing file information: ");
        print("\t file name: " + testFilePath.getFileName());
        print("\t root of the path: " + testFilePath.getRoot());
        print("\t parent of the target: " + testFilePath.getParent());
        print("\t url of the target: " + testFilePath.toUri().toURL().toString());
        print("Its absolute path is: " + testFilePath.toAbsolutePath());
        print("Its normalized path is: " + testFilePath.normalize());
        // get another path object with normalized relative path
        Path testPathNormalized = Paths.get(testFilePath.normalize().toString());
        print("Its normalized absolute path is: " + testPathNormalized.toAbsolutePath());
        print("Its normalized real path is: " + testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));

        // print path elements
        print("Printing elements of the path: ");
        for (Path element : testFilePath) {
            System.out.println("\t path element: " + element);
        }
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
