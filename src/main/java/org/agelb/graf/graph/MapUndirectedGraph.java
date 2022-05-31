package org.agelb.graf.graph;

import java.util.*;

public class MapUndirectedGraph<T> implements UndirectedGraph<T> {

    private final Map<T, Set<T>> nodes = new HashMap<>();

    private MapUndirectedGraph(Map<T, Set<T>> graph) {
        nodes.putAll(graph);
    }

    public boolean contains(T value) {
        return nodes.containsKey(value);
    }

    @Override
    public boolean containsAll(Collection<T> values) {
        for (T value : values) {
            if (!contains(value)) return false;
        }
        return true;
    }

    @Override
    public boolean doesNotContain(T value) {
        return !contains(value);
    }

    @Override
    public Collection<T> neighbors(T value) {
        return nodes.getOrDefault(value, Collections.emptySet());
    }

    @Override
    public boolean areNeighbors(T first, T second) {
        return nodes.getOrDefault(first, Collections.emptySet()).contains(second);
    }

    public static class Builder<T> {
        private final Map<T, Set<T>> nodes = new HashMap<>();

        public Builder<T> addNode(T node) {
            if (!nodes.containsKey(node)) {
                nodes.put(node, new HashSet<>());
            }
            return this;
        }

        public Builder<T> addEdge(T first, T second) {
            addNodeAndEdge(first, second);
            addNodeAndEdge(second, first);
            return this;
        }

        private void addNodeAndEdge(T first, T second) {
            nodes.computeIfAbsent(first, x -> new HashSet<>()).add(second);
        }

        public MapUndirectedGraph<T> build() {
            return new MapUndirectedGraph<>(nodes);
        }
    }
}
