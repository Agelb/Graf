package org.agelb.graf.graph;

import java.util.Optional;

public interface WeightedGraph<T> extends UndirectedGraph<T> {

    Optional<Integer> weightBetween(T first, T second);

    Optional<WeightedEdge<T>> edgeBetween(T first, T second);
}
