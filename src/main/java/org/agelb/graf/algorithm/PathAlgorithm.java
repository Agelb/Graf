package org.agelb.graf.algorithm;

import org.agelb.graf.Graph;

import java.util.List;

public interface PathAlgorithm<T> {

    List<T> findPath(T start, T end);
}
