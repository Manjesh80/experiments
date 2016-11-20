package com.manjesh.experiments.common;

import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/14/2016.
 */
public class State {

    private String name;
    private String code;
    private Set<City> mainCities = new HashSet<City>();
    private Region region;

    public State(String name, String code, Set<City> mainCities, Region region) {
        this.name = Preconditions.checkNotNull(name, "Name can't be null");
        this.code = Preconditions.checkNotNull(code, "Code can't be null");
        this.mainCities = Preconditions.checkNotNull(mainCities, "Cities can't be null");
        this.region = Preconditions.checkNotNull(region);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Region getRegion() {
        return region;
    }

    public Set<City> getMainCities() {
        return mainCities;
    }
}
