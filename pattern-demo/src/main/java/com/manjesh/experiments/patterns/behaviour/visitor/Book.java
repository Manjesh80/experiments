package com.manjesh.experiments.patterns.behaviour.visitor;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/19/2016.
 */
public class Book implements Visitable {

    private String ISBN;
    private double price;
    private double weight;

    public Book(String isbn, double price, double weight) {
        ISBN = isbn;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}
