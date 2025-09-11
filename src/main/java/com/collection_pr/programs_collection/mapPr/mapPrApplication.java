package com.collection_pr.programs_collection.mapPr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class mapPrApplication {
    public static void main(String[] args) {

        FrequencyProg fp = new FrequencyProg();
        fp.problems();
        getKey_ValuesList();
        addMapElement();
    }

    private static void getKey_ValuesList() {
        /*
         * keySet() : Returns set of keys.
         * values() : Returns collection of values.
         * entrySet() : Returns set of all entries
         */
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "one");
        map1.put(2, "two");
        map1.put(3, "three");
        System.out.println("Printing map1 values");
        map1.forEach((key, valule) -> System.out.println("key: " + key + " value: " + valule));
        List<Integer> intKeyList = map1.keySet().stream().collect(Collectors.toList());
        List<String> valuesList = map1.values().stream().collect(Collectors.toList());
        System.out.println("Key Set: " + intKeyList);
        System.out.println("Values in map: " + valuesList);
    }

    private static void addMapElement() {
        /*
         * put() : Adds single key-value pair into a HashMap
         * putAll() : Copies all key-value pairs of a specified map into current map.
         * putIfAbsent() : Inserts given key-value pair into a HashMap if it is not
         * present
         * or given key is mapping to null.
         */
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "one");
        map1.put(2, "two");
        map1.put(3, "three");
        System.out.println("Printing map1 values: used put()");
        map1.forEach((key, value) -> System.out.println("key: " + key + " value: " + value));
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(4, null);
        map2.put(5, "five");
        map2.putAll(map1);
        System.out.println("Printing map2 values: used putAll()");
        map2.forEach((key, value) -> System.out.println("key: " + key + " value: " + value));
        map2.putIfAbsent(4, "four");
        System.out.println("Printing map2 values: used putIfAbsent()");
        map2.forEach((key, value) -> System.out.println("key: " + key + " value: " + value));
    }
}
