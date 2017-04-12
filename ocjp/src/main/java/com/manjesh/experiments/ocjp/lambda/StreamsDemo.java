package com.manjesh.experiments.ocjp.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Consumer;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 4/12/2017.
 */
public class StreamsDemo {

    public static void main(String[] args) {
        StreamsDemo.demoMap();
    }

    public static void SimpleStream() {

        Stream.of("Jai", "Ganesh")
                .filter(StreamsDemo::SelectGanesh)
                .forEach(s -> System.out.println(s));
                        /*.findFirst()
                        .get()*/

    }

    public static boolean SelectGanesh(String name) {
        boolean result = name.toLowerCase().equals("ganesh");
        System.out.println(
                "Received " + name + " ==> returned ==> " + result
        );

        return result;
    }

    public static void demoRemoveIf() {
        List<String> greeting = new ArrayList<>();
        greeting.add("hello");
        greeting.add("world");

        greeting.removeIf(str -> !str.startsWith("h"));
    }

    public static void demoConsumer() {
        Stream.of("Jai", "Ganesh")
                .forEach(StreamsDemo::ImAConsumer);
    }

    public static void ImAConsumer(String s) {
        System.out.println(s);
    }

    public static void demoMap() {
        Stream.of("Jai", "Ganesh")
                .map(StreamsDemo::ImMapper)
                .forEach(System.out::println);

        Function<String, String> upperCase =
                str -> str.toUpperCase();
    }

    public static String ImMapper(String str) {
        return str.toUpperCase();
    }
}
