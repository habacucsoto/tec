package org.uv.tpcsw.practica01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Saludo extends Mensaje{

    @Override
    public void msg() {
        Logger.getLogger(Despedida.class.getName()).
                log(Level.INFO, "Hola Mundo...");       
    }
    
}
