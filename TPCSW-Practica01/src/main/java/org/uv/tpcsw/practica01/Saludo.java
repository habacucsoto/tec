package org.uv.tpcsw.practica01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Saludo extends Mensaje {

    private static final Logger logger = Logger.getLogger(Saludo.class.getName());
    
    @Override
    public void msg() {
        logger.log(Level.INFO, "Hola mundo...");
    }
    
}
