package com.collection_pr.programs_collection;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.collection_pr.programs_collection.cuncurrentHM.ConcurHM;
import com.collection_pr.programs_collection.cuncurrentHM.HM_Cun_Check;
import com.collection_pr.programs_collection.designPatterns.SingltonEx;

@SpringBootApplication
public class ProgramsCollectionApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ProgramsCollectionApplication.class, args);

		String str1 = "abacdabbcccd";
		Map<Character, Integer> countMap = new HashMap<>();
		char[] charArray = str1.toCharArray();
		for (char c : charArray) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		System.out.println("Count Map: " + countMap);
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			sb.append(entry.getKey()).append(entry.getValue());
		}
		System.out.println(" char count in string: " + sb.toString());
		// checkSingletone();
		// getCuncureHM();
		// getExceptionInHM();
	}

	private static void checkSingletone() {
		SingltonEx instance0 = SingltonEx.getInstance();
		SingltonEx instance00 = SingltonEx.getInstance();
		SingltonEx instance1 = SingltonEx.getInstace1();
		SingltonEx instance11 = SingltonEx.getInstace1();
		SingltonEx instance2 = SingltonEx.getInstance2();
		SingltonEx instance22 = SingltonEx.getInstance2();
		System.out.println("instance0: " + instance0);
		System.out.println("instance00: " + instance00);
		System.out.println("instance1: " + instance1);
		System.out.println("instance11: " + instance11);
		System.out.println("instance2: " + instance2);
		System.out.println("instance22: " + instance22);
	}

	private static void getCuncureHM() throws InterruptedException {
		System.out.println("In Concurrent Hash Map:");
		ConcurHM.chm.put("One", 1);
		ConcurHM.chm.put("Two", 2);
		ConcurHM.chm.put("Three", 3);
		ConcurHM forThread = new ConcurHM();
		forThread.start();
		for (Map.Entry<String, Integer> entry : ConcurHM.chm.entrySet()) {
			System.out.println("The key is: " + entry.getKey() + " value is: " + entry.getValue());
			Thread.sleep(2000);
		}
	}

	private static void getExceptionInHM() throws InterruptedException {
		System.out.println("In Hash Map for exception:");
		HM_Cun_Check.hm.put("One", 1);
		HM_Cun_Check.hm.put("Two", 2);
		HM_Cun_Check.hm.put("Three", 3);
		HM_Cun_Check forThread = new HM_Cun_Check();
		forThread.start();
		for (Map.Entry<String, Integer> entry : HM_Cun_Check.hm.entrySet()) {
			System.out.println("The key is: " + entry.getKey() + " value is: " + entry.getValue());
			Thread.sleep(2000);
		}
	}

}
