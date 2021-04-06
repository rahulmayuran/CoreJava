package com.DSalgo.Algorithm;

import java.util.logging.Logger;

/*
Efficient way of searching the target element in the array of elements
by breaking the array into two parts with a mid element,

1. If mid element is the target element, return it
2. If target element appears on left, then decrement high=(array.length)-1 from mid element
3. If target element appears on right, then increment low from mid element
*/
public class BinarySearch { //Time complexity is O(logn)

    private static final Logger LOGGER = Logger.getLogger(BinarySearch.class.getCanonicalName());

    public static void main(String[] args) {

        int[] arrayToSearch = new int[]{2,4,6,8,10,12,14}; //sorted array
        int target = 12; // Element to search

        int low = 0; //left
        int high = arrayToSearch.length - 1; //right


        while (low <= high) { //low should be greater than high to exit this loop.
            int mid = (low + high)/2;
            LOGGER.info("Mid Value is ("+low+" + "+high+")/2 = "+mid);

            if (arrayToSearch[mid] == target) { //pos{3} is mid
                LOGGER.info("The target element -> " + arrayToSearch[mid] + " is found at position " + mid);

                if(arrayToSearch[mid] != target) {
                    LOGGER.info("Element not found in array tray");
                }
                break;
            }

            //If target is greater than 8, traversing right side by increasing low value from 0 to mid+1
            else if (target > arrayToSearch[mid]) { //if(8<14), you should look in right side
                low = mid + 1;
                LOGGER.info("Low value -> " + low + " is incremented from mid " + mid);
            }

            //If target is lesser than 8, traversing left side by decreasing high value from 6 to mid-1=2
             else if (target < arrayToSearch[mid]) { //if(8>2), you should search left side
                high = mid - 1;
                LOGGER.info("High value -> "+high+" is decremented from mid "+mid);
            }

        }


    }

}
