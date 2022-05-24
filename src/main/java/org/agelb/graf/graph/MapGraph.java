package org.agelb.graf.graph;

import java.util.*;

public class MapGraph<T> implements Graph<T> {

    private final Map<T, Set<T>> nodes = new HashMap<>();

    private MapGraph(Map<T, Set<T>> graph) {
        nodes.putAll(graph);
    }

    public boolean contains(T value) {
        return nodes.containsKey(value);
    }

    @Override
    public boolean containsAll(T... values) {
        for (T value : values) {
            if (!contains(value)) return false;
        }
        return true;
    }

    @Override
    public boolean doesNotContain(T value) {
        return !contains(value);
    }

    public Collection<T> neighbors(T value) {
        return nodes.getOrDefault(value, Collections.emptySet());
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

        public MapGraph<T> build() {
            return new MapGraph<>(nodes);
        }
    }
}
