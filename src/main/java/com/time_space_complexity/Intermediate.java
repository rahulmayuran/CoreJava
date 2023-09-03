package com.time_space_complexity;

import java.util.Arrays;

import static com.LogHelper.loghelper;

public class Intermediate {

    public static void main(String[] args) {

        Intermediate interExamples = new Intermediate();
        interExamples.iterateArrayTwice(new int[]{1, 2, 3, 4});
        interExamples.printPairsInArray(new int[]{1, 2, 3, 4});
        interExamples.printPairsInArrayWithCondition(new int[]{1, 2, 3, 4});
        interExamples.printUnOrderedPairsInTwoArrays(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        interExamples.reverseAnArray(new int[]{1, 2, 3, 4});
        interExamples.sortArrayOfStringsAndTotalArray(new String[]{"Cat", "Ant", "Bat"});

    }

    /**
     * Time -> O(N), Space -> O(N),
     * Even if the array is iterated twice, it doesn't make any difference
     *
     * @param array
     */
    private void iterateArrayTwice(int[] array) {
        int sum = 0;
        int product = 1;
        for (int k : array) {
            sum += k;
        }
        for (int j : array) {
            product *= j;
        }
        loghelper.info("sum is " + sum + ", product is " + product);
    }

    /**
     * Time -> O(N^2)
     * @param array
     */
    private void printPairsInArray(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                builder.append("[").append(i).append(", ").append(j).append("]");
            }
        }
        loghelper.info("Pairs for the provided array are " + builder);

    }

    /**
     * Time -> O(N^2)
     * @param array
     */
    private void printPairsInArrayWithCondition(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                builder.append("[").append(i).append(", ").append(j).append("]");
            }
        }
        loghelper.info("Conditional Pairs for the provided array are " + builder);

    }

    /**
     * Time -> O(a*b)
     * @param arrayA
     * @param arrayB
     */
    private void printUnOrderedPairsInTwoArrays(int[] arrayA, int[] arrayB) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if(arrayA[i]>arrayB[j])
                    builder.append("[").append(i).append(", ").append(j).append("]");
            }
        }
        loghelper.info("Unordered pairs for the 2 arrays are " + builder);
    }

    /**
     * Time -> O(N) and not O(log N) as you guessed.
     * Even though it divides array to half, it still iterates the whole array
     * @param array
     */
    private void reverseAnArray(int[] array){
        for (int i = 0; i < array.length/2; i++) {
            int start = array[i];
            int end = array.length-i-1;
            array[i] = array[end];
            array[end] = start;
        }
        loghelper.info("Reversed Array is " + Arrays.toString(array));
    }

    private void sortArrayOfStringsAndTotalArray(String[] array){
        // s is length of string
        // a is length of array
        // O(a*s(log a + log s))
        Arrays.sort(array);
        //But here the strings aren't sorted, so Time -> O(a*s*log a)
        loghelper.info("Sorted string array is "+ Arrays.toString(array));
    }

    /**
     * Time -> O(N) because of O(2^logN) => O(N)
     */
//    private int sumNodesInBalancedBSTree(Node node){
//        if(node == 0){
//            return 0;
//        }
//        return sumNodesInBalancedBSTree(node.left) + sumNodesInBalancedBSTree(node) + sumNodesInBalancedBSTree(node.right);
//    }
}
