package org.uv.tpcsw.practica01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MensajeConcreto {

    private String name = "";

    public MensajeConcreto(String name) {
        this.name = name;
    }

    public MensajeConcreto() {
        this.name = "Nombre";
        Logger.getLogger(Despedida.class.getName()).
                log(Level.INFO, "Se ejecuta constructor...");
    }

    public void imprimir() {
        Logger.getLogger(Despedida.class.getName()).
                log(Level.INFO, "{0} :Mensaje...",name);
    }
}
