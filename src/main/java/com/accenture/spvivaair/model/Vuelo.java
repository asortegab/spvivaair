package com.accenture.spvivaair.model;

import net.serenitybdd.screenplay.Performable;

public class Vuelo {

    private String origen;
    private String destino;

    public Vuelo(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }
    public String getDestino() {
        return destino;
    }
}
