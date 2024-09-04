package org.uv.tpcsw.practica01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Singleton {
    
    private static Singleton sin = null;
    
    public static Singleton getInstance(){
        if (sin==null)
            sin=new Singleton();

        return sin;
    }

    private Singleton() {
        
    }
    
    public void imprimir(){
                Logger.getLogger(Despedida.class.getName()).
                log(Level.INFO, "Mensaje...");       

    }
}
