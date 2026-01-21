package com.collection_pr.programs_collection.streamapi;

import java.util.Optional;

public class OptionalFun {

    public static void main(String[] args) {
        Optional<String> optional1 = Optional.of("Hello"); // must be non-null
        Optional<String> optional2 = Optional.ofNullable(null); // can be null
        Optional<String> empty = Optional.empty();

        System.out.println(optional1.get()); // ✅ prints "Hello"
        // System.out.println(optional2.get()); //❌ throws NoSuchElementException

        System.out.println("\n orElse(defaultValue)" +
                "If value is present → returns it." +
                "If empty → returns given default.\n");
        System.out.println(optional1.orElse("Default")); // prints "Hello"
        System.out.println(optional2.orElse("Default")); // prints "Default"
        System.out.println(empty.orElse("Default")); // prints "Default"
        System.out.println(optional1.orElse(getOrDefault())); // prints "Hello"

        System.out.println("\n orElseGet(Supplier)" + //
                "Similar to orElse, but lazy (only calls Supplier if empty).\n");
        System.out.println(optional1.orElseGet(() -> "Generated")); // "Hello"
        System.out.println(optional2.orElseGet(() -> "Generated"));
        System.out.println(empty.orElseGet(() -> "Generated \n")); // "Generated"

        System.out.println("getOrDefault calling in case of");
        System.out.println("orElse not null:");
        System.out.println(optional1.orElse(getOrDefault())); // prints "Hello"
        System.out.println("orElseGet not null:");
        System.out.println(optional1.orElseGet(() -> getOrDefault())); // "Hello"

    }

    private static String getOrDefault() {
        System.out.println("getDefault method called!");
        return "Default";
    }
}
