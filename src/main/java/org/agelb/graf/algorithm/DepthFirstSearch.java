package org.agelb.graf.algorithm;

import org.agelb.graf.graph.UndirectedGraph;
import org.agelb.graf.path.PathAccumulator;
import org.agelb.graf.path.StackPathAccumulator;

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
        PathAccumulator<T> accumulator = new StackPathAccumulator<>();

        stack.push(start);
        while(!stack.isEmpty()) {
            T next = stack.pop();
            if (!graph.areNeighbors(accumulator.peek(), next)) {
                accumulator.removeWhile(endOfPath -> !graph.areNeighbors(next, endOfPath));
            }
            accumulator.pushStep(next);
            if (next == end) {
                return accumulator.toList();
            }

            if (!visited.contains(next)) {
                visited.add(next);
                for (T neighbor : graph.neighbors(next)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return Collections.emptyList();
    }
}
