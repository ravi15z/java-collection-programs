package com.collection_pr.programs_collection.cuncurrentHM;

import java.util.HashMap;
import java.util.Map;

public class HM_Cun_Check extends Thread {

    public static Map<String, Integer> hm = new HashMap<>();

    public void run() {
        System.out.println("In run Method:");
        hm.put("Four", 4);
    }
}
