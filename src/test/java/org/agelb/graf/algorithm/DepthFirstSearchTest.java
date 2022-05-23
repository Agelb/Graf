package org.agelb.graf.algorithm;

import org.agelb.graf.Graph;
import org.agelb.graf.MapGraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepthFirstSearchTest {


    @Test
    public void testEmptyGraph() {
        Graph<Integer> graph = new MapGraph.Builder<Integer>()
                .addEdge(1, 5)
                .addEdge(1, 4)
                .addEdge(4, 8)
                .build();

        List<Integer> path = new DepthFirstSearch<>(graph).findPath(1, 8);
    }

    @Test
    public void testFindsPath() {
        Graph<Integer> graph = new MapGraph.Builder<Integer>()
                .addEdge(1, 5)
                .addEdge(5, 7)
                .addEdge(1, 4)
                .addEdge(4, 8)
                .addEdge(8, 9)
                .build();

        List<Integer> path = new DepthFirstSearch<>(graph).findPath(1, 9);
        assertEquals(1, path.get(0));
        assertEquals(4, path.get(1));
        assertEquals(8, path.get(2));
        assertEquals(9, path.get(3));
    }

    @Test
    public void testFindsLongestPath() {
        Graph<Integer> graph = new MapGraph.Builder<Integer>()
                .addEdge(1, 5)
                .addEdge(5, 7)
                .addEdge(7, 9)
                .addEdge(1, 4)
                .addEdge(4, 9)
                .build();

        List<Integer> path = new DepthFirstSearch<>(graph).findPath(1, 9);
        assertEquals(1, path.get(0));
        assertEquals(5, path.get(1));
        assertEquals(7, path.get(2));
        assertEquals(9, path.get(3));
    }

    @Test
    public void testStopsAtTarget() {
        Graph<Integer> graph = new MapGraph.Builder<Integer>()
                .addEdge(1, 5)
                .addEdge(5, 7)
                .addEdge(1, 4)
                .addEdge(4, 8)
                .addEdge(8, 9)
                .addEdge(9, 10)
                .build();

        List<Integer> path = new DepthFirstSearch<>(graph).findPath(1, 9);
        assertEquals(1, path.get(0));
        assertEquals(4, path.get(1));
        assertEquals(8, path.get(2));
        assertEquals(9, path.get(3));
    }
}
