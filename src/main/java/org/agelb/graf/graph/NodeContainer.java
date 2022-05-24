package org.agelb.graf.graph;

public interface NodeContainer<T> {
    boolean contains(T value);

    boolean containsAll(T... values);

    boolean doesNotContain(T value);
}
