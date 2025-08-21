package com.collection_pr.programs_collection.mapPr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyProg {

    void problems() {
        intFreqProg();

        stringFreqProg();
    }

    private void stringFreqProg() {
        // Find the frequency of each character of a string using HashMap?
        String inputString = "Java Concept Of The Day";
        Map<Character, Integer> map1 = new HashMap<>();
        System.out.println("Java Concept Of The Day");
        for (char c : inputString.toCharArray()) {
            if (c != ' ') {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println("frequency of each character in the String: " + map1);
        // Find the frequency of each word of a sentence using HashMap?
        System.out.println("============================");
        String sentence = "Java Python JavaScript HTML Java CSS Hibernate Python Java";
        System.out.println("Java Python JavaScript HTML Java CSS Hibernate Python Java");
        Map<String, Long> stringFreq = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("frequency of each word in the sentence: " + stringFreq);
    }

    private void intFreqProg() {
        /*
         * Find the frequency of each element of an array using HashMap?
         */

        int[] intArray = { 4, 7, 2, 9, 1, 7, 1, 4, 7, 8 };
        Map<Integer, Long> intMap = new HashMap<>();
        /*
         * intMap = Arrays.stream(intArray)
         * .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
         * boxed() is required because intArray is a primitive int[],
         * and streams over primitives (like IntStream) don't work with
         * Function.identity()
         * — you need to convert to Stream<Integer> first.
         */
        intMap = Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("element with occurance: " + intMap);

        // without stream
        Map<Integer, Integer> intMap2 = new HashMap<>();
        for (int i = 0; i <= intArray.length - 1; i++) {
            intMap2.put(intArray[i], intMap2.getOrDefault(intArray[i], 0) + 1);
        }
        System.out.println("without stream, element with occurance: " + intMap2);
    }
}
