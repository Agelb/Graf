package org.agelb.graf.path;

import java.util.*;

public class HashPathAccumulator<T> implements PathAccumulator<T> {

    private final Map<T, T> pathMap = new HashMap<>();

    @Override
    public int size() {
        return pathMap.size();
    }

    @Override
    public void addStep(T from, T to) {
        pathMap.put(to, from);
    }

    @Override
    public List<T> toList(T end) {
        List<T> path = new ArrayList<>();
        path.add(end);
        T previous = pathMap.get(end);
        while (previous != null) {
            path.add(previous);
            previous = pathMap.get(previous);
        }
        Collections.reverse(path);
        return path;
    }
}
