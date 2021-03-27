package com.accenture.spvivaair.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EscogerVueloPage {
    public static final Target POP_UP1= Target.the("popup1")
            .located(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]"));
    //public static final Target POP_UP2= Target.the("popup2").located(By.xpath("//i[contains(@class,\"newsletter_popup_close\")]"));
    public static final Target IDA_CHECKBOX = Target.the("soloida")
            .located(By.xpath("//*[@id=\"criteria\"]/div/div[1]/label/span[1]"));
    public static final Target ORIGEN_BUTTON = Target.the("origen button")
            .located(By.xpath("//*[@id=\"criteria-airport-select-departure\"]/div"));
    public static final Target ORIGEN_FIELD = Target.the("origen")
            .located(By.xpath("//*[@id=\"criteria-airport-select-departure-input\"]"));
    public static final Target DESTINO_FIELD = Target.the("destino")
            .located(By.xpath("//*[@id=\"criteria-airport-select-destination-input\"]"));
    public static final Target FECHA_FIELD = Target.the("fechafield")
            .located(By.xpath("//button[@date=\""+getFecha()+"\"]"));
    public static final Target BUSCAR_BUTTON = Target.the("buscar")
            .located(By.xpath("//*[@id=\"criteria-search-button-desktop\"]"));

    public static String getFecha(){
        LocalDate localDate= LocalDate.now();
        LocalDate dateTomorrow=localDate.plusDays(1);
        String formatter = dateTomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return formatter;
    }

}





























































