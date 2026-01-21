package com.collection_pr.programs_collection.default_static_method;

public interface InterfaceA {

    void print();

    default void show() {
        System.out.println("default method from Interface A.");
    }

    default void singleMethod() {
        System.out.println("Default singlMethod in InterfaceA");
    }
}
