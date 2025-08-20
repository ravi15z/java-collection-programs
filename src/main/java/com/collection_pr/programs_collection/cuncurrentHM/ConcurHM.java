package com.collection_pr.programs_collection.cuncurrentHM;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurHM extends Thread {

    public static Map<String, Integer> chm = new ConcurrentHashMap<>();

    public void run() {
        System.out.println("In run Method:");
        chm.put("Four", 4);
    }
}
