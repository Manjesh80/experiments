package com.manjesh.experiments.nuggets.typeerasure;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/2/2016.
 */
public class IntegerNode extends Node<Integer> {

    public IntegerNode(Integer data) {
        super(data);
    }

    public void setData(Integer data) {
        System.out.println("Integer Node called to setup data");
        super.setData(data);
    }
}
