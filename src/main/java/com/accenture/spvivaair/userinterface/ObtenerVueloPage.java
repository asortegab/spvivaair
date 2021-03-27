package com.accenture.spvivaair.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ObtenerVueloPage {

    public static final Target FECHA_BUTTON = Target.the("fechabutton")
            .located(By.xpath("//*[@id=\"days-0\"]/button[4]"));

    public static final Target TARIFAS = Target.the("tarifas")
            .located(By.xpath("//*[@class=\"from-price\"]"));

    public static Target SELECT_TARIFA(String tarifa){
        return Target.the("selectarifa")
                .located(By.xpath("//div[@class=\"flights\"]//div[contains(text(),'"+tarifa+"')]"));
    }

    public static Target SELECT_SUBTARIFA(String tarifa){
        return Target.the("select subtarifa")
                .located(By.xpath("//div[@class=\"reduced-price\"]//div[contains(text(),'"+tarifa+"')]"));
    }
    //public static final Target SELECT_SUBTARIFA = Target.the("selectarifa").located(By.xpath("//div[@class=\"flights\"]//div[contains(text(),'{0}')]"));

    public static final Target CONTINUAR_BUTTON = Target.the("continuar")
            .located(By.xpath("//div[@class=\"form-group button-container next-button float-right\"]/child::button[@class=\"button with-icon-right\"]"));

}
