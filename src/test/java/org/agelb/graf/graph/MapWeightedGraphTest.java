package org.agelb.graf.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapWeightedGraphTest {


    @Test
    public void testContainerFunctionality() {
        MapWeightedGraph.Builder<Integer> builder = new MapWeightedGraph.Builder<>();
        WeightedGraph<Integer> graph = builder.addEdge(1, 2, 1)
                .addEdge(2, 3, 10)
                .addEdge(2, 99, 20)
                .build();

        assertTrue(graph.contains(1));
        assertTrue(graph.contains(2));
        assertTrue(graph.contains(3));
        assertTrue(graph.containsAll(Arrays.asList(1, 2, 3, 99)));
        assertFalse(graph.doesNotContain(1));
        assertTrue(graph.doesNotContain(6));
    }

    @Test
    public void testNeighborFunctionality() {
        MapWeightedGraph.Builder<Integer> builder = new MapWeightedGraph.Builder<>();
        WeightedGraph<Integer> graph = builder.addEdge(1, 2, 1)
                .addEdge(2, 3, 10)
                .addEdge(2, 99, 20)
                .build();

        assertEquals(1, graph.weightBetween(1, 2).get());
        assertEquals(10, graph.weightBetween(2, 3).get());
        assertEquals(20, graph.weightBetween(2, 99).get());

        assertFalse(graph.weightBetween(2, 100).isPresent());
    }
}
