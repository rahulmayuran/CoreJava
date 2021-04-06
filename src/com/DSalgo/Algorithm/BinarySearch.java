package com.DSalgo.Algorithm;

/*
Efficient way of searching the target element in the array of elements
by breaking the array into two parts with a mid element,

1. If mid element is the target element, return it
2. If target element appears on left, then decrement from mid element
3. If target element appears on right, then increment from mid element
*/
public class BinarySearch { //Time complexity is O(logn)

    public static void main(String[] args) {

        int[] arrayToSearch = {2,4,6,8,10,12,14}; //sorted array
        int target = 14; // Element to search

        int low = 0; //left
        int high = arrayToSearch.length - 1; //right


        while (low <= high) {
            int mid = (low + high)/2;
            System.out.println("Mid Value is ("+low+" + "+high+")/2 = "+mid);
            if (arrayToSearch[mid] == target) { //pos{3} is mid
                System.out.println("The target element -> " + arrayToSearch[mid] + " is found at position " + mid);

                if(arrayToSearch[mid] != target) {
                    System.out.println("Element not found in array tray");
                }
                break;
            }
            else if (arrayToSearch[mid] < target) { //If target is greater than 8, traversing right side
                low = mid + 1;
                System.out.println("Low value -> "+low+" is incremented from mid "+mid);
            } else if (arrayToSearch[mid] > target) {  //If target is lesser than 8, traversing left side
                high = mid - 1;
                System.out.println("High value -> "+high+" is decremented from mid "+mid);
            }

        }


    }

}
