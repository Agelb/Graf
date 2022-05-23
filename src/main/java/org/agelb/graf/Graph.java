package org.agelb.graf;

import java.util.Collection;

/**
 * Undirected, basic graph
 */
public interface Graph<T> {

    boolean contains(T value);

    boolean containsAll(T... values);

    boolean doesNotContain(T value);

    Collection<T> neighbors(T value);
}
