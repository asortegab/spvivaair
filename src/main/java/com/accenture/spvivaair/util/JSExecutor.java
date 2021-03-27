package com.accenture.spvivaair.util;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.sourceforge.htmlunit.corejs.javascript.Script;
import org.openqa.selenium.JavascriptExecutor;

public class JSExecutor {

    JavascriptExecutor js;

    public JSExecutor(Actor actor) {
        this.js=(JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
    }

    public JavascriptExecutor getJs(String script) {
        return (JavascriptExecutor) js.executeScript(script);
    }

    public JavascriptExecutor getJs(String script, Object object) {
        return (JavascriptExecutor) js.executeScript(script,object);
    }
}
