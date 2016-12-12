package com.manjesh.experiments.nuggets.genericlimitations;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/2/2016.
 */
public class DemoGenerics {

    //https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html

    public static void main(String[] args) {
        System.out.println("Number 1 => List<int> on Genrics on Primitive type is not allowed");
        System.out.println("Number 2 => Cannot instance a Generic type directly -- T newNumber = new T(); ");

        System.out.println("Number 3 => Cannot Declare Static Fields Whose Types are Type Parameters, because you don't " +
                "know which instance to associate with");

        System.out.println("Number 4 => Cannot use Cast and instanceof on Generic Types");

        System.out.println("Number 5 => Cannot create array of generic types");

        System.out.println("Number 6 => Cannot Create, Catch, or Throw Objects of Parameterized Types " +
                "Mobile<T> extends Exception");

        System.out.println("Number 7 => Cannot Overload a Method Where the Formal Parameter Types " +
                "of Each Overload Erase to the Same Raw Type, method1(List<Integet>), method1(List<String>) ");

    }

    public static <I> void Number4(List<I> integerList) throws Exception {
        //boolean isInteger = integerList instanceof ArrayList<Integer>;
        boolean isInteger = integerList instanceof ArrayList<?>; // but allowed in REIFIABLE types

        List<Integer> li = new ArrayList<>();
        //List<Number>  ln = (List<Number>) li;  // compile-time error
        List<Integer> l2 = (ArrayList<Integer>) li; // allowed
    }


    public <T> void Number5(T myType) {
        Integer[] integerArray = new Integer[100];
        int[] intArray = new int[100];

        //T[] genericArray = new T[100];
        //List<Integer>[] arrayOfListWithInteger = new List<Integer>[2];

    }

    public static <T> void Add2(T number, Class<T> classOfT) throws Exception {
        //T newNumber = new T();
        T newNumber = classOfT.newInstance();
    }

}
