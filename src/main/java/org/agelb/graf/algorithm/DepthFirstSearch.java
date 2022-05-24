package org.agelb.graf.algorithm;

import org.agelb.graf.graph.UndirectedGraph;
import org.agelb.graf.path.HashPathAccumulator;
import org.agelb.graf.path.PathAccumulator;

import java.util.*;

public class DepthFirstSearch<T> {

    private final UndirectedGraph<T> graph;

    public DepthFirstSearch(UndirectedGraph<T> graph) {
        this.graph = graph;
    }

    public List<T> findPath(T start, T end) {
        if (!graph.contains(start) || !graph.contains(end)) {
            return Collections.emptyList();
        }

        Deque<T> stack = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();
        PathAccumulator<T> accumulator = new HashPathAccumulator<>();

        stack.push(start);
        while(!stack.isEmpty()) {
            T next = stack.pop();
            if (!visited.contains(next)) {
                visited.add(next);
                for (T neighbor : graph.neighbors(next)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                        accumulator.addStep(next, neighbor);
                        if (neighbor == end) {
                            return accumulator.toList(end);
                        }
                    }
                }
            }
        }

        return Collections.emptyList();
    }
}
