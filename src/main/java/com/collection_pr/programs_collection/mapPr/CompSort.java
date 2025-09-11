package com.collection_pr.programs_collection.mapPr;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CompSort {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("qwer", "asd", "asdfg", "zx");
        Map<String, Integer> map = strList.stream()
                .collect(Collectors.toMap(Function.identity(), s -> s.length()));
        System.out.println(map);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
        // sortPrograms();
        // HighestOccuarance();
    }

    static void sortPrograms() {
        int[] inputArray = { 4, 7, 2, 9, 1, 7, 1, 4, 7, 8 };
        HashMap<Integer, Integer> elementFrequencyMap = new HashMap<Integer, Integer>();
        for (int i : inputArray) {
            elementFrequencyMap.put(i, elementFrequencyMap.getOrDefault(i, 0) + 1);
        }
        System.out.println("element of array are: " + Arrays.toString(inputArray));
        System.out.println("sorting in reverse order:");
        elementFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("sorting in natural order by value:");
        elementFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("sorting in natural order by Key:");
        elementFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

    }

    static void HighestOccuarance() {
        int[] inputArray = { 4, 7, 2, 9, 1, 7, 1, 4, 7, 8 };
        HashMap<Integer, Integer> elementFrequencyMap = new HashMap<Integer, Integer>();
        for (int i : inputArray) {
            elementFrequencyMap.put(i, elementFrequencyMap.getOrDefault(i, 0) + 1);
        }
        elementFrequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .forEach(entry -> System.out.println("Highest Occurance " + entry.getKey() + " : " + entry.getValue()));

    }
}
