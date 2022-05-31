package org.agelb.graf.path;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackPathAccumulatorTest {

    @Test
    public void testBasicFunctionality() {
        StackPathAccumulator<Integer> pathAccumulator = new StackPathAccumulator<>();

        pathAccumulator.pushStep(1);
        pathAccumulator.pushStep(2);
        pathAccumulator.pushStep(1);

        assertEquals(3, pathAccumulator.size());

        List<Integer> path = pathAccumulator.toList();
        assertEquals(Arrays.asList(1, 2, 1), path);
    }

    @Test
    public void testRemoveUntil() {
        StackPathAccumulator<Integer> pathAccumulator = new StackPathAccumulator<>();

        pathAccumulator.pushStep(1);
        pathAccumulator.pushStep(2);
        pathAccumulator.pushStep(1);
        pathAccumulator.pushStep(3);

        assertEquals(4, pathAccumulator.size());
        pathAccumulator.removeUntil(2);
        assertEquals(2, pathAccumulator.size());

        pathAccumulator.removeUntil(1);
        assertEquals(1, pathAccumulator.size());

        pathAccumulator.removeUntil(99);
        assertEquals(0, pathAccumulator.size());
    }

    @Test
    public void testRemoveWhile() {
        StackPathAccumulator<Integer> pathAccumulator = new StackPathAccumulator<>();

        pathAccumulator.pushStep(1);
        pathAccumulator.pushStep(2);
        pathAccumulator.pushStep(1);
        pathAccumulator.pushStep(3);
        pathAccumulator.pushStep(4);

        assertEquals(5, pathAccumulator.size());
        pathAccumulator.removeWhile(x -> x != 4);
        assertEquals(5, pathAccumulator.size());

        pathAccumulator.removeWhile(x -> x > 3);
        assertEquals(4, pathAccumulator.size());

        pathAccumulator.removeWhile(x -> x % 2 != 0);
        assertEquals(2, pathAccumulator.size());

        pathAccumulator.removeWhile(x -> true);
        assertEquals(0, pathAccumulator.size());
    }
}
