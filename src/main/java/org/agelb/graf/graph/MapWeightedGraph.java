package org.agelb.graf.graph;

import java.util.*;
import java.util.stream.Collectors;

public class MapWeightedGraph<T> implements WeightedGraph<T> {

    // TODO support disconnected nodes
    private final Set<WeightedEdge<T>> edges = new HashSet<>();
    private final Map<T, Set<NodeWeight<T>>> nodeConnections = new HashMap<>();

    public MapWeightedGraph(Collection<WeightedEdge<T>> edges) {
        this.edges.addAll(edges);
        for (WeightedEdge<T> edge : edges) {
            nodeConnections.computeIfAbsent(edge.getFirstNode(), x -> new HashSet<>()).add(
                    new NodeWeight<>(edge.getSecondNode(), edge.getWeight())
            );
            nodeConnections.computeIfAbsent(edge.getSecondNode(), x -> new HashSet<>()).add(
                    new NodeWeight<>(edge.getFirstNode(), edge.getWeight())
            );
        }
    }


    @Override
    public Optional<Integer> weightBetween(T first, T second) {
        Optional<WeightedEdge<T>> edge = edgeBetween(first, second);
        if (edge.isPresent()) return edge.map(WeightedEdge::getWeight);
        return Optional.empty();
    }

    @Override
    public Optional<WeightedEdge<T>> edgeBetween(T first, T second) {
        return edges.stream().filter(x -> x.containsNodes(first, second)).findFirst();
    }

    public boolean contains(T value) {
        return nodeConnections.containsKey(value);
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
        return nodeConnections.getOrDefault(value, Collections.emptySet())
                .stream()
                .map(NodeWeight::getNode)
                .collect(Collectors.toList());
    }

    public static class Builder<T> {
        private final Set<WeightedEdge<T>> edges = new HashSet<>();

        public Builder<T> addEdge(T first, T second, int weight) {
            edges.add(new WeightedEdge<>(first, second, weight));
            return this;
        }


        public MapWeightedGraph<T> build() {
            return new MapWeightedGraph<>(edges);
        }
    }
}
