package com.manjesh.experiments.patterns.behaviour.visitor;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/19/2016.
 */
public class DemoVisitor {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Book("isbn", 10, 10));
        shoppingCart.addItem(new Book("isbn", 20, 20));
        shoppingCart.addItem(new CD(30, false));

        System.out.println(shoppingCart.calculatePostage());
    }
}
