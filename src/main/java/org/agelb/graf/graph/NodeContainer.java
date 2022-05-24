package org.agelb.graf.graph;

import java.util.Collection;

public interface NodeContainer<T> {
    boolean contains(T value);

    boolean containsAll(Collection<T> values);

    boolean doesNotContain(T value);
}
