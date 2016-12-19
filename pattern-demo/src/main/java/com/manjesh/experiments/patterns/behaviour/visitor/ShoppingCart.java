package com.manjesh.experiments.patterns.behaviour.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/19/2016.
 */
public class ShoppingCart {

    private List<Visitable> items;

    public ShoppingCart() {
        items = new LinkedList<>();
    }

    public List<Visitable> getItems() {
        return items;
    }

    public boolean addItem(Visitable visitable) {
        return items.add(visitable);
    }

    public double calculatePostage() {
        PostageVisitor postageVisitor = new PostageVisitor();
        for (Visitable visitable : items) {
            visitable.accept(postageVisitor);
        }
        return postageVisitor.getTotalPostageForCart();
    }
}
