package org.agelb.graf.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MapUndirectedGraphTest {

    @Test
    public void testBasicFunctionality() {
        MapUndirectedGraph.Builder<Integer> builder = new MapUndirectedGraph.Builder<>();
        UndirectedGraph<Integer> graph = builder.addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(2, 99)
                .addNode(4).build();

        assertTrue(graph.contains(1));
        assertTrue(graph.contains(2));
        assertTrue(graph.contains(3));
        assertTrue(graph.contains(4));
        assertTrue(graph.containsAll(1, 2, 3, 4));
        assertFalse(graph.doesNotContain(1));
        assertTrue(graph.doesNotContain(6));

        assertEquals(3, graph.neighbors(2).size());
        assertTrue(graph.neighbors(2).containsAll(Arrays.asList(1, 3, 99)));

        assertEquals(0, graph.neighbors(4).size());
    }
}
