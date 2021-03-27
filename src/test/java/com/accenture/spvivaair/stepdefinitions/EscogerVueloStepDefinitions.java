package com.accenture.spvivaair.stepdefinitions;

import com.accenture.spvivaair.model.Vuelo;
import com.accenture.spvivaair.task.EscogerVuelo;
import com.accenture.spvivaair.task.ObtenerVuelo;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EscogerVueloStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) quiere escoger un vuelo$")
    public void andresQuiereEscogerUnVuelo(String actorName) {
        // Write code here that turns the phrase above into concrete actions
        theActorCalled(actorName).wasAbleTo(Open.url("https://www.vivaair.com/"));
    }

    @When("^origen (.*) destino (.*)$")
    public void origenMedellinDestinoBogota(String origen,String destino) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(EscogerVuelo.with(new Vuelo(origen,destino)));

    }

    @Then("^obtener el vuelo mas barato$")
    public void obtenerElVueloMasBarato() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(new ObtenerVuelo());
    }
}
