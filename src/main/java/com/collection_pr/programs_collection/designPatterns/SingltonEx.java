package com.collection_pr.programs_collection.designPatterns;

public class SingltonEx {

    private static SingltonEx instance;

    private SingltonEx() {
    }

    // simple, not thread safe.
    public static SingltonEx getInstance() {
        if (instance == null) {
            instance = new SingltonEx();
        }
        return instance;
    }

    // thread safe, but performance is low
    public static synchronized SingltonEx getInstace1() {
        if (instance == null) {
            instance = new SingltonEx();
        }
        return instance;
    }

    // thread safe, but performance is fast
    public static SingltonEx getInstance2() {
        if (instance == null) {
            synchronized (SingltonEx.class) {
                instance = new SingltonEx();
            }

        }
        return instance;
    }

}
