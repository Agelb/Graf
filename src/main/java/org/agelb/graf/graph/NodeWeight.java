package org.agelb.graf.graph;

public class NodeWeight<T> {

    private final T node;
    private final int weight;

    public NodeWeight(T node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public T getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }
}
