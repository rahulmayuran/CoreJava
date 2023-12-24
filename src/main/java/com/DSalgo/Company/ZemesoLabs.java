package com.DSalgo.Company;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ZemesoLabs {

    private static final Map<Integer, List<Integer>> map = new HashMap<>();
    private static final Map<Integer, List<Integer>> safeMap = new HashMap<>();

    public static void main(String[] args) {

        //Fetch all the Values for the given input
        //1 => 1, 2, 3, 4, 5, 6, 7, 8, 9
        map.put(1, Arrays.asList(2, 3, 4, 5));
        map.put(3, Arrays.asList(5, 6, 7));
        map.put(5, Arrays.asList(8, 9, 1));

        log.info("Best Approach to fill the List: {}", findAllValuesForTheHashMap());


        //Fetch all the Values for the given input using Recursion
        //1 => 2, 3, 4, 5, 6, 7, 8, 9, 10
        safeMap.put(1, Arrays.asList(2, 3, 4, 5));
        safeMap.put(3, Arrays.asList(6, 7, 8));
        safeMap.put(5, Arrays.asList(9, 10));

        log.info("All added elements to the List: {}", findAllValuesForTheHashMapUsingRecursion());
    }

    private static List<Integer> findAllValuesForTheHashMapUsingRecursion() {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for(List<Integer> n : safeMap.values()){
            res.addAll(n);
        }
        return res;
    }

    //Hint : Use a Set and a Queue
    private static List<Integer> findAllValuesForTheHashMap(){

        //Define a Queue
        Queue<Integer> queue = new LinkedList<>();

        //Define a Set
        Set<Integer> set = new HashSet<>();

        //Define a Resultant List
        List<Integer> res = new ArrayList<>();

        //Add the input number to both the set and the queue
        queue.offer(1);
        set.add(1);

        //Find BFS Traversal to reach all values
        while(!queue.isEmpty()){
            int currentKey = queue.poll();
            List<Integer> currentValues = map.get(currentKey);
            if(currentValues != null){
                //Add all the values of provided input used as a Map key and fetched values
                for(int u : currentValues){
                    res.add(u);
                }

                //BFS - Now iterate through these values to make it as a new Map Key
                //This gets looped until the queue is emptied
                for(int nextKey : currentValues){
                    //This condition makes sure to remove duplicates
                    if(!set.contains(nextKey)){
                        set.add(nextKey);
                        queue.offer(nextKey);
                    }
                }
            }
        }
        return res;
    }
}
