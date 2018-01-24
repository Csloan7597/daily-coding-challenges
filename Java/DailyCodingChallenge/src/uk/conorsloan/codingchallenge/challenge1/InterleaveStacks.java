package uk.conorsloan.codingchallenge.challenge1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a stack of N elements, interleave the first half of the stack with the second half reversed using only one other queue. This should be done in-place.

 Recall that you can only push or pop from a stack, and enqueue or dequeue from a queue.

 For example, if the stack is [1, 2, 3, 4, 5], it should become [1, 5, 2, 4, 3]. If the stack is [1, 2, 3, 4], it should become [1, 4, 2, 3].
 */
public class InterleaveStacks {

    public static void main(String[] args) {
        Stack<Integer> testStack = new Stack<>();
        testStack.addAll(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("Before: " + testStack);
        interleaveStack(testStack);
        System.out.println("After: " + testStack);
    }

    public static void interleaveStack(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<>();

        // From N - 1 to 1
        for (int i = stack.size() - 1; i > 0; i--) {
            // First put i elements from the stack onto the queue
            for (int j = 0; j < i; j++) {
                queue.add(stack.pop());
            }
            // Then push the whole queue back onto the stack
            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
        }
    }
}
