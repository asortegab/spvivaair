package com.accenture.spvivaair.task;

import com.accenture.spvivaair.model.Vuelo;
import com.accenture.spvivaair.util.JSExecutor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import static com.accenture.spvivaair.userinterface.EscogerVueloPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EscogerVuelo implements Task {

    private Vuelo vuelo;

    public EscogerVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JSExecutor jsExecutor= new JSExecutor(actor);
        jsExecutor.getJs("window.scrollBy(0,400)");

        actor.attemptsTo(
                Check.whether(POP_UP1.resolveFor(actor).isDisplayed()).andIfSo(Click.on(POP_UP1)),
                Click.on(IDA_CHECKBOX),
                Click.on(ORIGEN_BUTTON),
                SendKeys.of(vuelo.getOrigen() + Keys.ENTER).into(ORIGEN_FIELD),
                SendKeys.of(vuelo.getDestino() + Keys.ENTER).into(DESTINO_FIELD),
                Click.on(FECHA_FIELD),
                Click.on(BUSCAR_BUTTON)
        );
    }

    public static EscogerVuelo with(Vuelo vuelo) {
        return instrumented(EscogerVuelo.class, vuelo);
    }
}
