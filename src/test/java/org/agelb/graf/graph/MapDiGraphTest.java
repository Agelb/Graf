package org.agelb.graf.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapDiGraphTest {

    @Test
    public void testContainerFunctionality() {
        MapDiGraph.Builder<Integer> builder = new MapDiGraph.Builder<>();
        Digraph<Integer> graph = builder.addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(2, 99)
                .addNode(4).build();

        assertTrue(graph.contains(1));
        assertTrue(graph.contains(2));
        assertTrue(graph.contains(3));
        assertTrue(graph.contains(4));
        assertTrue(graph.containsAll(Arrays.asList(1, 2, 3, 4)));
        assertFalse(graph.doesNotContain(1));
        assertTrue(graph.doesNotContain(6));
    }

    @Test
    public void testNeighborFunctionality() {
        MapDiGraph.Builder<Integer> builder = new MapDiGraph.Builder<>();
        Digraph<Integer> graph = builder.addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(2, 99)
                .addNode(4).build();

        assertEquals(0, graph.directPredecessors(1).size());
        assertEquals(1, graph.directSuccessors(1).size());
        assertEquals(1, graph.directPredecessors(2).size());
        assertEquals(2, graph.directSuccessors(2).size());
        assertEquals(0, graph.directSuccessors(99).size());

        assertTrue(graph.directSuccessors(2).containsAll(Arrays.asList(3, 99)));

        assertEquals(0, graph.directPredecessors(4).size());
        assertEquals(0, graph.directSuccessors(4).size());
    }
}
