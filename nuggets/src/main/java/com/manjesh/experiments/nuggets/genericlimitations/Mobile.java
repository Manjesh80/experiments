package com.manjesh.experiments.nuggets.genericlimitations;

import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/2/2016.
 */
public class Mobile<T> {

    //public static List<T> features ;
    // This is not allowed becuase if you crete Mobile<Apple>, Mobile<Samsung> then there is confusion above to which
    // it should assign as it's only one instance
}
