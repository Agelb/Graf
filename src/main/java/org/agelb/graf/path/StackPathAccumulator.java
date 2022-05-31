package org.agelb.graf.path;

import java.util.*;
import java.util.function.Predicate;

public class StackPathAccumulator<T> implements PathAccumulator<T> {

    private final Deque<T> stack;

    public StackPathAccumulator(int size) {
        this.stack = new ArrayDeque<>(size);
    }

    public StackPathAccumulator() {
        this.stack = new ArrayDeque<>();
    }

    @Override
    public void pushStep(T step) {
        stack.push(step);
    }

    @Override
    public void removeUntil(T value) {
        while (stack.size() > 0 && !stack.peek().equals(value)) {
            stack.pop();
        }
    }

    @Override
    public void removeWhile(Predicate<T> condition) {
        while(stack.size() > 0 && condition.test(stack.peek())) {
            stack.pop();
        }
    }

    @Override
    public List<T> toList() {
        List<T> path = new ArrayList<>(stack);
        Collections.reverse(path);
        return path;
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public T peek() {
        return stack.peek();
    }
}
