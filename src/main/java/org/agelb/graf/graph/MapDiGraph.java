package org.agelb.graf.graph;

import java.util.*;

public class MapDiGraph<T> implements Digraph<T> {

    /**
     * The key is the node value, and the value is all of the nodes reachable from the source node
     */
    private final Map<T, Set<T>> outgoingEdges = new HashMap<>();
    /**
     * the key is the node value, and the value is all of the nodes that can reach the source node
     */
    private final Map<T, Set<T>> incomingEdges = new HashMap<>();
    private final Set<T> allNodes = new HashSet<>();

    private MapDiGraph(Map<T, Set<T>> outgoingEdges,
                       Map<T, Set<T>> incomingEdges) {
        this.outgoingEdges.putAll(outgoingEdges);
        this.incomingEdges.putAll(incomingEdges);
        allNodes.addAll(outgoingEdges.keySet());
        allNodes.addAll(incomingEdges.keySet());
    }

    public boolean contains(T value) {
        return allNodes.contains(value);
    }

    @Override
    public final boolean containsAll(T... values) {
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
    public Collection<T> directPredecessors(T value) {
        return incomingEdges.getOrDefault(value, Collections.emptySet());
    }

    @Override
    public Collection<T> directSuccessors(T value) {
        return outgoingEdges.getOrDefault(value, Collections.emptySet());
    }

    public static class Builder<T> {
        /**
         * The key is the node value, and the value is all of the nodes reachable from the source node
         */
        private final Map<T, Set<T>> outgoingEdges = new HashMap<>();
        /**
         * the key is the node value, and the value is all of the nodes that can reach the source node
         */
        private final Map<T, Set<T>> incomingEdges = new HashMap<>();


        public Builder<T> addEdge(T first, T second) {
            addNodeAndEdge(first, second);
            return this;
        }

        public Builder<T> addNode(T node) {
            outgoingEdges.putIfAbsent(node, new HashSet<>());
            incomingEdges.putIfAbsent(node, new HashSet<>());
            return this;
        }

        private void addNodeAndEdge(T first, T second) {
            outgoingEdges.computeIfAbsent(first, x -> new HashSet<>()).add(second);
            incomingEdges.computeIfAbsent(second, x -> new HashSet<>()).add(first);
        }

        public MapDiGraph<T> build() {
            return new MapDiGraph<>(outgoingEdges, incomingEdges);
        }
    }
}
