package com.manjesh.experiments.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/16/2016.
 */
public class Review {

    @Getter @Setter private String reviewerName;

    public Review(String reviewerName ) {
        this.reviewerName = reviewerName;
    }
}
