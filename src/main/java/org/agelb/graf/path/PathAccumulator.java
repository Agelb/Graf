package org.agelb.graf.path;

import java.util.List;

public interface PathAccumulator<T> {

    void addStep(T from, T to);

    List<T> toList(T end);

    int size();
}
