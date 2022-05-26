package org.agelb.graf.path;

import java.util.List;
import java.util.function.Predicate;

public interface PathAccumulator<T> {

    /**
     * Pushes an element to the end of the path.
     * @param step
     */
    void pushStep(T step);

    /**
     * Removes values from the path until T is found, or until the path is empty. If <i>value</i> is in the path,
     * it will be the last element of the path.
     * @param value
     */
    void removeUntil(T value);

    /**
     * Returns a list of the elements in the path.
     * @return
     */
    List<T> toList();

    /**
     * Returns the number of elements in the current path
     * @return
     */
    int size();

    /**
     * Removes elements from the path while the provided condition returns true, or until the path is empty
     * @param condition
     */
    void removeWhile(Predicate<T> condition);

}
