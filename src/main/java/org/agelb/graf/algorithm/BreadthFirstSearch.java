package org.agelb.graf.algorithm;

import org.agelb.graf.graph.Graph;
import org.agelb.graf.path.HashPathAccumulator;
import org.agelb.graf.path.PathAccumulator;

import java.util.*;

public class BreadthFirstSearch<T> implements PathAlgorithm<T> {

    private final Graph<T> graph;

    public BreadthFirstSearch(Graph<T> graph) {
        this.graph = graph;
    }

    @Override
    public List<T> findPath(T start, T end) {
        Set<T> visited = new HashSet<>();
        PathAccumulator<T> pathAccumulator = new HashPathAccumulator<>();

        if (!graph.contains(start) || !graph.contains(end)) return Collections.emptyList();

        Deque<T> frontier = new ArrayDeque<>();
        frontier.add(start);
        visited.add(start);

        while (frontier.size() > 0) {
            T current = frontier.pop();

            for (T neighbor : graph.neighbors(current)) {
                if (!visited.contains(neighbor)) {
                    pathAccumulator.addStep(current, neighbor);
                    if (neighbor == end) {
                        return pathAccumulator.toList(end);
                    }
                    frontier.add(neighbor);
                }
            }
            visited.add(current);
        }

        return Collections.emptyList();
    }
}
