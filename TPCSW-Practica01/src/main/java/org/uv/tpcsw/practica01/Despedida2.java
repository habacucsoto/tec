package org.uv.tpcsw.practica01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Despedida2 implements IMensaje {

    @Override
    public void imprimir() {
        Logger.getLogger(Despedida.class.getName()).
                log(Level.INFO, "Adios Mundo...");           }
    
}
