package uk.conorsloan.codingchallenge.challenge2;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of
 * all the numbers in the original array except the one at i. Solve it without using division and in O(n) time.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
public class ExcludingProduct {

    public static void main(String[] args) {
        int[] input = new int[] { 1, 2, 3, 4, 5 };
        System.out.println("Before: " + Arrays.toString(input));
        System.out.println("After: " + Arrays.toString(excludedProducts(input)));
    }

    public static double[] excludedProducts(int[] arr) {
        // For index i, will contain the value of products to left and right, respectively.
        double[] productsToLeft = new double[arr.length];
        double[] productsToRight = new double[arr.length];
        double[] excludedProducts = new double[arr.length];

        // First get the cumulative product of all the things to the left of i.
        double cumulative = 1;
        productsToLeft[0] = 1; // Because * 1 = self. This makes it neutral.
        for (int i = 1; i < arr.length; i++) {
            cumulative *= arr[i - 1];
            productsToLeft[i] = cumulative;
        }

        // Second get the cumulative product of all the things to the right if i.
        cumulative = 1;
        productsToRight[arr.length - 1] = 1; // Because * 1 = self. This makes it neutral.
        for (int i = arr.length - 2; i >= 0; i--) {
            cumulative *= arr[i + 1];
            productsToRight[i] = cumulative;
        }

        // Finally, generate the answer by multiplying all to left and to right.
        for (int i = 0; i < arr.length; i++) {
            excludedProducts[i] = productsToLeft[i] * productsToRight[i];
        }

        return excludedProducts;
    }

}
