package com.collection_pr.programs_collection.default_static_method;

public class ClassI implements InterfaceA, InterfaceB {

    @Override
    public void print() {
        System.out.println("print method");
    }

    @Override
    public void show() {
        System.out.println("show method from ClassI:");
        InterfaceB.super.show();
    }

}
