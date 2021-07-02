package com.DSalgo.Algorithm;

/*
Efficient way of searching the target element in the array of elements
by breaking the array into two parts with a mid element,

1. If mid element is the target element, return it
2. If target element appears on left, then decrement from mid element
3. If target element appears on right, then increment from mid element
*/
public class BinarySearch {

    public static void main(String[] args) {
        binarySearch();
    }

    public static int binarySearch() {
        int arrayToSearch[] = {12, 22, 10, 9, 18, 19, 20};
        int target = 19;

        int low = 0; //left
        int high = arrayToSearch.length - 1; //right
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arrayToSearch[mid] == target) { //pos{3} is mid
                System.out.println("The target element -> " + arrayToSearch[mid] + " is found at position " + mid);
                return mid;
            } else if (arrayToSearch[mid] < target) {
                mid = mid - 1;
            } else if (arrayToSearch[mid] > target) {
                mid = mid + 1;
            }

        }
        return mid;
    }

}
