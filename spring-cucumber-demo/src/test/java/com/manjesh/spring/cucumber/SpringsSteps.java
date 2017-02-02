package com.manjesh.spring.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 2/1/2017.
 */

/*@ContextConfiguration(classes = SpringDemoApplication.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration // Don't ask
*/

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application.class )
public class SpringsSteps {

    @Autowired
    protected TestRestTemplate restTemplate;

    private String caller; // input

    private ResponseEntity<String> response; // output

    @Given("^I use the caller Ganesh$")
    public void iUseTheCallerGanesh() throws Throwable {
        this.caller = "Ganesh";
    }

    @When("^I request greeting$")
    public void iRequestGreeting() throws Throwable {
        response = restTemplate
                .exchange("/greetings/{caller}", HttpMethod.GET, null, String.class, caller);
    }

    @Then("^I should get a response with a HTTP status code (\\d+)$")
    public void iShouldGetAResponseWithAHTTPStatusCode(int arg0) throws Throwable {
        assertThat(response.getStatusCodeValue()).isEqualTo(arg0);
    }

    @And("^The response should contain message Jai Ganesh$")
    public void theResponseShouldContainMessageJaiGanesh() throws Throwable {
        assertThat(response.getBody()).isEqualTo("Jai Ganesh");
    }
}
