package com.manjesh.experiments.ocjp.stream;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by aadhya on 12/2/2016.
 */
public class DemoStream {

    // https://www.safaribooksonline.com/library/view/oracle-certified-professional/9781484218365/9781484218358_Ch05.xhtml

    // TODO : Stopped at Constructor reference https://www.safaribooksonline.com/library/view/oracle-certified-professional/9781484218365/9781484218358_Ch05.xhtml
    public static void main(String[] args) {
        demoSimpleStream();
        demoPredicate();
        demoRemoveIf();
        demofunction();
        demoCompostion();
        demoSupplier();
    }

    private static void demoSupplier() {
        Random random = new Random();
        Stream.generate(random::nextDouble)
                .limit(5)
                .forEach(System.out::println);

        Supplier<String> now = () -> LocalDateTime.now().toString();
        Stream.generate(now)
                .limit(10)
                .forEach(DemoStream::print);
    }

    private static void print(String s){
        System.out.println(s);
    }

    private static void demoCompostion() {

        Function<String, String> one = str -> {
            System.out.println("From function 1");
            return str + " ==> I am in one";
        };
        Function<String, String> two = str -> {
            System.out.println("From function 2");
            return str + " ==> I am in two";
        };
        Function<String, String> three = str -> {
            System.out.println("From function 3");
            return str + " ==> I am in three";
        };

        one.andThen(two).andThen(three).apply("Ganesh");
        one.compose(two).compose(three).apply("Jai Ganesh");

        Function<String, String> andThenDemo = one.andThen(two).andThen(three);
        Function<String, String> composeDemo = one.compose(two).compose(three);

        Stream.of("Test Manjesh")
                .map(andThenDemo)
                .forEach(System.out::println);

        Stream.of("Test Ganesh")
                .map(composeDemo)
                .forEach(System.out::println);

    }

    private static void demofunction() {
        Arrays.stream("1,2,3".split(","))
                .map(Integer::parseInt)
                .map(i -> i > 0 ? i++ : i--)
                .forEach(System.out::println);
    }

    private static void demoRemoveIf() {
        System.out.println("Demo --> Remove IF");
        //List<String> arrayList = Arrays.asList("Jai", "Ganesh");

        List<String> arrayList = new ArrayList<>();
        arrayList.add("Jai");
        arrayList.add("Ganesh");

        arrayList.removeIf(str -> str.length() < 4);
        arrayList.forEach(System.out::println);

        arrayList.add("Jai");
        arrayList.add("Ganesh");

        System.out.println("Demo --> Remove IF negate");
        arrayList.removeIf(((Predicate<String>) str -> str.length() < 4).negate());
        arrayList.forEach(System.out::println);

        Consumer<String> myConsumer = str -> System.out.println(str);
        Consumer<String> myConsumerTerse = System.out::println;
        arrayList.forEach(myConsumer);
        myConsumer.accept("Gajodhar");
        myConsumerTerse.accept("Aadhya");
    }

    private static void demoPredicate() {
        Predicate<String> nullCheck = arg -> arg != null;
        Predicate<String> emptyCheck = arg -> arg.length() > 0;

        Predicate<String> notNullAndEmptyCheck = nullCheck.and(emptyCheck);

        System.out.println(notNullAndEmptyCheck.test("Jai Ganesh"));
        System.out.println(notNullAndEmptyCheck.test(null));
        System.out.println(notNullAndEmptyCheck.test(""));

    }

    private static void demoSimpleStream() {
        Stream.of("Jai", "Ganesh")
                .filter(str -> str.length() > 1)
                .forEach(System.out::println);
    }

}
