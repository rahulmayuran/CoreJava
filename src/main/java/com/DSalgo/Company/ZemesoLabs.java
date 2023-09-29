package com.DSalgo.Company;

import java.util.*;

public class ZemesoLabs {

    private static final Map<Integer, List<Integer>> map = new HashMap<>();
    private static final Map<Integer, List<Integer>> safeMap = new HashMap<>();

    public static void main(String[] args) {

        //Fetch all the Values for the given input
        //1 => 1, 2, 3, 4, 5, 6, 7, 8, 9
        map.put(1, Arrays.asList(2, 3, 4, 5));
        map.put(3, Arrays.asList(5, 6, 7));
        map.put(5, Arrays.asList(8, 9, 1));

        System.out.println(findAllValuesForTheHashMap(map, 1));


        //Fetch all the Values for the given input using Recursion
        //1 => 2, 3, 4, 5, 6, 7, 8, 9, 10
        safeMap.put(1, Arrays.asList(2, 3, 4, 5));
        safeMap.put(3, Arrays.asList(6, 7, 8));
        safeMap.put(5, Arrays.asList(9, 10));

        System.out.println(findAllValuesForTheHashMapUsingRecursion(safeMap, 1));
    }

    private static List<Integer> findAllValuesForTheHashMapUsingRecursion(Map<Integer, List<Integer>> map, int i) {
        return new ArrayList<>();
    }

    private static List<Integer> findAllValuesForTheHashMap(Map<Integer, List<Integer>> map, int input){
        return new ArrayList<>();
    }
}
