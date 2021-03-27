package com.accenture.spvivaair.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/escoger_vuelo.feature"},
        glue = {"com.accenture.spvivaair.stepdefinitions"},
        snippets = SnippetType.CAMELCASE)
public class EscogerVuelo {
}
