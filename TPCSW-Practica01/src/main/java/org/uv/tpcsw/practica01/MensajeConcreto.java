package org.uv.tpcsw.practica01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MensajeConcreto {

    private static final Logger logger = Logger.getLogger(MensajeConcreto.class.getName());
    
    private String name="";
    
    public MensajeConcreto(){
        this.name="Nombre";
        logger.log(Level.INFO, "Se ejecuta el constructor");
    }
    
    public MensajeConcreto(String name){
        this.name=name;
    }
    
    public void imprimir(){
        logger.log(Level.INFO, "{0}:Mensaje...", name);
    }
    
}
