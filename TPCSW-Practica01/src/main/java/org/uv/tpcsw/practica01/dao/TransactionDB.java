package org.uv.tpcsw.practica01.dao;

import java.sql.Connection;

public abstract class TransactionDB<T> {
    protected T pojo;
    protected TransactionDB(T pojo){
        this.pojo=pojo;
    }
    
    public abstract boolean execute(Connection con);
}
