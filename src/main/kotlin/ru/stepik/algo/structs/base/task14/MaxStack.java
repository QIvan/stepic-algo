package ru.stepik.algo.structs.base.task14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ivan Zemlyanskiy
 */
public final class MaxStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> maxStack;

    public MaxStack(int count) {
        this.stack = new ArrayDeque<>(count);
        this.maxStack = new ArrayDeque<>(count);
    }

    public final void push(int value) {
        this.stack.addFirst(value);
        if (this.maxStack.isEmpty() || this.maxStack.getFirst() < value) {
            this.maxStack.addFirst(value);
        } else {
            this.maxStack.addFirst(this.maxStack.getFirst());
        }
    }

    public final int pop() {
        this.maxStack.removeFirst();
        return this.stack.removeFirst();
    }

    public final int max() {
        return this.maxStack.getFirst();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(reader.readLine());
        MaxStack stack = new MaxStack(count);
        for (int i = 0; i < count; i++) {
            String[] nextLine = reader.readLine().split(" ");
            String op = nextLine[0];
            switch (op) {
                case "max":
                    System.out.println(stack.max());
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "push":
                    stack.push(Integer.valueOf(nextLine[1]));
                    break;

            }
        }
    }

}

