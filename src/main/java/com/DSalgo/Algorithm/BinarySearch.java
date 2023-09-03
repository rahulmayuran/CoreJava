package com.DSalgo.Algorithm;

/** Efficient way of searching the target element in the array of elements
 * by breaking the array into two parts with a mid element.
 *
 * Array must be sorted to do this.
 * If mid element is the target element, return it
 *

*/
public class BinarySearch {

    public static void main(String[] args) {

        int[] arrayToSearch = {12, 22, 10, 9, 18, 19, 20};
        System.out.println("Iterative ->" + iterativeBinarySearch(arrayToSearch, 18));
        System.out.println("Recursive -> " + recursiveBinarySearch(arrayToSearch, 18));
    }

    public static String iterativeBinarySearch(int[] intArray, int value) {

        int start = 0;
        int end = intArray.length;

        while(start < end){
            int mid = (start + end) / 2;
            if(intArray[mid] == value) {
                return "Value is located at index " + mid;
                // Right half
            } else if (intArray[mid] < value) {
                 start = mid + 1;
            } else {
                end = mid;
            }
        }
        return "The provided value -> " + value + " is not found";
    }

    public static String recursiveBinarySearch(int[] intArray, int value){
        return recursiveSearch(intArray, 0, intArray.length, value);
    }

    private static String recursiveSearch(int[] intArray, int start,  int end,  int value) {

            if(start >= end){
                return "Value not found";
            }
            int mid = (start + end) / 2;
            if(intArray[mid] == value){
                return "Value is found at index -> " + mid ;
            } else if (intArray[mid] < value) {
                return recursiveSearch(intArray, mid + 1, end, value);
            } else {
                return recursiveSearch(intArray, start, mid, value);
            }
    }
}
