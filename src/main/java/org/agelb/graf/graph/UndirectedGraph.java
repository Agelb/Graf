package org.agelb.graf.graph;

import java.util.Collection;

/**
 * Undirected, basic graph
 */
public interface UndirectedGraph<T> extends NodeContainer<T> {

    Collection<T> neighbors(T value);

    boolean areNeighbors(T first, T second);
}
