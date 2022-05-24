package org.agelb.graf.graph;

public class Edge<T> {

    private T first;
    private T second;

    public Edge(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
