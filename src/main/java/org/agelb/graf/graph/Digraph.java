package org.agelb.graf.graph;

import java.util.Collection;

/**
 * A simple directed graph
 */
public interface Digraph<T> extends NodeContainer<T> {

    Collection<T> directPredecessors(T value);

    Collection<T> directSuccessors(T value);
}
