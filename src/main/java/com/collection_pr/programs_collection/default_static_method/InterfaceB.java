package com.collection_pr.programs_collection.default_static_method;

public interface InterfaceB {
    void print();

    default void show() {
        System.out.println("default method from Interface A.");
    }
}
