package org.uv.tpcsw.practica01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Saludo2 implements IMensaje {

    private static final Logger logger = Logger.getLogger(Saludo2.class.getName());
    
    @Override
    public void imprimir() {
        logger.log(Level.INFO, "Holaaaa");
    }

}
