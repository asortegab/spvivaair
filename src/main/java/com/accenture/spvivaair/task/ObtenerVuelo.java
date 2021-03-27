package com.accenture.spvivaair.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.accenture.spvivaair.userinterface.ObtenerVueloPage.*;
import static com.accenture.spvivaair.userinterface.ObtenerVueloPage.SELECT_TARIFA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ObtenerVuelo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<String> tarifas= getList(actor,TARIFAS);
        String res = null;
        try {
            res = getTarifa(tarifas);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(
                Click.on(FECHA_BUTTON),
                Scroll.to(SELECT_TARIFA(res)).andAlignToBottom(),
                Click.on(SELECT_TARIFA(res)),
                Click.on(SELECT_SUBTARIFA(res)),
                Scroll.to(CONTINUAR_BUTTON).andAlignToBottom(),
                Click.on(CONTINUAR_BUTTON),
                WaitUntil.the(CONTINUAR_BUTTON,isNotCurrentlyVisible())
        );
    }

    public List<String> getList(Actor actor, Target target) {
        return Text.of(target)
                .viewedBy(actor)
                .asList();
    }

    public static String getTarifa(List<String> elements) throws ParseException {
        NumberFormat nf = NumberFormat.getInstance();
        List<Double> prices = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            String price[] = elements.get(i).split(" ");

            Number parse = nf.parse(price[1]);
            prices.add(parse.doubleValue());
        }
        Double min = Collections.min(prices);
        String res= nf.format(min);
        return res;
    }
}
