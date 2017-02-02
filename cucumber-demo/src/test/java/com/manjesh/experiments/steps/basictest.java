package com.manjesh.experiments.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Test;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 1/31/2017.
 */
public class basictest {

    @Given("^user is on Application landing page$")
    public void user_is_on_Application_landing_page() throws Throwable {
        System.out.println("user_is_on_Application_landing_page");

    }

    @Then("^user is on home page$")
    public void user_is_on_home_page() throws Throwable {
        System.out.println("user_is_on_home_page");
    }
}
