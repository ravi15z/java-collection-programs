package com.collection_pr.programs_collection.default_static_method;

public class MainClass {

    public static void main(String[] args) {
        InterfaceA a = new ClassI();
        a.print();
        a.show();

        ClassI a1 = new ClassI();
        a1.print();
        a1.show();
        /*
         * if only one interface contain default method then we dont need to override
         * it.
         * ->class obj can directly calls it.
         * but
         * if two or more Interface contain same default method then it will give an
         * compile time error.
         * ->need to override it and if we need call default metho
         * a1.singleMethod();
         */
    }
}
