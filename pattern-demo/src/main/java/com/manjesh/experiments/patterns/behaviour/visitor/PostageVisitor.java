package com.manjesh.experiments.patterns.behaviour.visitor;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/19/2016.
 */
public class PostageVisitor implements Visitor {

    private double totalPostageForCart;

    @Override
    public void visit(Book book) {
        if( book.getWeight() > 10 )
            totalPostageForCart += book.getWeight() * 0.02;
        else
            totalPostageForCart += book.getWeight() * 0.01;
    }

    @Override
    public void visit(CD cd) {
        if( !cd.isFreePostage())
            totalPostageForCart += cd.getPrice() * 0.01;
    }

    public double getTotalPostageForCart() {
        return totalPostageForCart;
    }
}
