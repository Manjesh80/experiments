package com.manjesh.experiments.nuggets.typeerasure;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/2/2016.
 */
public class Node<T> {

    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Root Node called to set Data");
        this.data = data;
    }
}

