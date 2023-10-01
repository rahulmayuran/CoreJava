package com.DSalgo.Company;

import java.util.*;

public class ComCast {

    public static void main(String[] args) {

        System.out.println("Miniumum Sum: " + findMinimumSum(Arrays.asList(30, 10, 7), 4));
        System.out.println("Miniumum Sum Best TC: " + findMinimumSumUsingQueue(Arrays.asList(30, 10, 7), 4));

        System.out.println(findNonDupe("REARED"));
        System.out.println(findNonDupe2("REARED"));

    }

    private static int findMinimumSumUsingQueue(List<Integer> asList, int k) {

        //Initialize the queue with the decreasing order using a priority queue.
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;

        //Fill the queue with the list items.
        for(int j : asList){
            queue.offer(j);
        }

        //Loop the elements k times and queue size times.
        //Find the max-element, which is the polled element.
        //add it back to the queue with itself cut and ceil'ed into its half
        //Decrement the k count
        while(!queue.isEmpty() && k > 0){
            double maxElement = queue.poll();
            queue.offer((int) Math.ceil(maxElement/ 2.0));
            k--;
        }

        //Now, sum up the queue.
        for(int a : queue){
            sum += a;
        }
        //return it
        return sum;
    }

    private static int findMinimumSum(List<Integer> asList, int k) { //[30, 10, 7]

        int sum = 0;

        //Run the loop k times, and then List size times inside k.
        for (int i = 0; i < k; i++) {
            //It should be inside the first loop, because max and maxIndex are reset for every i.
            int max = 0;
            int maxIndex = 0;
            //Now run the loop arrayList's size times to find the max and max-index.
            for (int j = 0; j < asList.size(); j++) {
                if(max < asList.get(j)){
                    max = asList.get(j);
                    maxIndex = j;
                }
            }
            //Set the ArrayList elements back to the i'th loop. K loop times matters, not the arrayList loop.
            asList.set(maxIndex, (int) Math.ceil(max/2.0));
        }

        for(int a : asList){
            sum += a;
        }

        return sum;
    }

    public static char findNonDupe(String str){

        Map<Character, Integer> charCount = new HashMap<>();

        for(char c : str.toCharArray()){

//            This can also be used
//            charCount.put(c, charCount.getOrDefault(c, 1) + 1);

            if(charCount.containsKey(c)){
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        for(char c : str.toCharArray()){
            if(charCount.get(c) == 1){
                return c;
            }
        }
        return '\0';
    }

    public static char findNonDupe2(String str){

        //Array to store character counts
        int[] charr = new int[256];

        //Load the character array with the given string, to update the frequencies.
        for(char c : str.toCharArray()){
            charr[c]++;
        }

        //When the frequency is 1, then print it
        for(char c : str.toCharArray()){
            if(charr[c] == 1){
                return c;
            }
        }
        return '\0';
    }

}