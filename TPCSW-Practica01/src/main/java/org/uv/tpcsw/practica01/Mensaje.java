package org.uv.tpcsw.practica01;

public abstract class Mensaje {
    public void imprimir(){
        msg();
    }
    
    protected abstract void msg();
}
