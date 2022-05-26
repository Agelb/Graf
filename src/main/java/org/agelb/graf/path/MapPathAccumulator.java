package org.agelb.graf.path;

import java.util.List;

/**
 * A Map Path Accumulator keeps track of pairs of paths between nodes. This is useful in cases where an algorithm
 * needs to keep more information than a single list of elements
 * @param <T>
 */
// TODO this class is probably incorrect. Because this is only useful in some algorithms and not in general, this will likely become redundant as more algorithms are added
public interface MapPathAccumulator<T> {

    void addStep(T from, T to);

    List<T> toList(T end);

    int size();
}
