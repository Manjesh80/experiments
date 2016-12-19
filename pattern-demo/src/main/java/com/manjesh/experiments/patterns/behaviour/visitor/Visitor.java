package com.manjesh.experiments.patterns.behaviour.visitor;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/19/2016.
 */
public interface Visitor {
    void visit(Book book);
    void visit(CD cd);
}
