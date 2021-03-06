package org.agelb.graf.algorithm;

import org.agelb.graf.graph.UndirectedGraph;
import org.agelb.graf.path.HashPathAccumulator;
import org.agelb.graf.path.MapPathAccumulator;

import java.util.*;

public class DepthFirstSearchRecursive<T> implements PathAlgorithm<T> {

    private final UndirectedGraph<T> graph;

    public DepthFirstSearchRecursive(UndirectedGraph<T> graph) {
        this.graph = graph;
    }

    @Override
    public List<T> findPath(T start, T end) {
        if (!graph.containsAll(Arrays.asList(start, end))) return Collections.emptyList();

        Set<T> visited = new HashSet<>();
        MapPathAccumulator<T> path = new HashPathAccumulator<>();
        findPathRecursive(start, end, visited, path);
        return path.toList(end);
    }


    private void findPathRecursive(T node, T end, Set<T> visited, MapPathAccumulator<T> path) {
        visited.add(node);
        for (T neighbor : graph.neighbors(node)) {
            if (!visited.contains(neighbor)) {
                path.addStep(node, neighbor);
                if (neighbor == end) return;
                findPathRecursive(neighbor, end, visited, path);
            }
        }
    }
}
