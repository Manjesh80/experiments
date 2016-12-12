package com.manjesh.experiments.nuggets.typeerasure;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/2/2016.
 */
public class DemoTypeErasure {

    public static void main(String[] args) {

        IntegerNode myInteger = new IntegerNode(100);
        Node rootNode = myInteger;
        rootNode.setData("Hello Ganesh");
        Integer giveBackNumber = myInteger.data;
    }
}
