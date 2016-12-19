package com.manjesh.experiments.patterns.behaviour.visitor;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/19/2016.
 */
public class CD implements Visitable {

    private double price;
    private boolean freePostage;

    public CD(double price, boolean freePostage) {
        this.price = price;
        this.freePostage = freePostage;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public boolean isFreePostage() {
        return freePostage;
    }
}
