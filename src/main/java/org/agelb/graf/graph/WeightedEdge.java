package org.agelb.graf.graph;

public class WeightedEdge<T> {

    private final T firstNode;
    private final T secondNode;
    private final int weight;

    public WeightedEdge(T firstNode, T secondNode, int weight) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.weight = weight;
    }

    public T getFirstNode() {
        return firstNode;
    }

    public T getSecondNode() {
        return secondNode;
    }

    public int getWeight() {
        return weight;
    }

    public boolean containsNodes(T first, T second) {
        return (first.equals(firstNode) && second.equals(secondNode)) ||
                (first.equals(secondNode) && second.equals(firstNode));
    }
}
