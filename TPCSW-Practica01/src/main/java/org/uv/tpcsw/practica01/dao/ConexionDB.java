package org.uv.tpcsw.practica01.dao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    
    private static ConexionDB cx = null;
    
    private Connection con = null;
    
    public static ConexionDB getInstance() {
        if(cx == null){
            cx = new ConexionDB();
        }
        
        return cx;
    }
    
    private ConexionDB(){
        try {
            Dotenv dotenv = Dotenv.load();
            
            String url = "jdbc:postgresql://localhost:5432/tecp1";

            String user = dotenv.get("DB_USERNAME");
            String password = dotenv.get("DB_PASSWORD");
            
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex ) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public boolean execute(TransactionDB transaction){
        return transaction.execute(con);
    }
    
    public boolean execute(String sql){
        Statement stm = null;
        
        try { 
           stm = con.createStatement();
           return stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, "Error al cerrar statement", ex);
                }
            }
        }
        
        
        // Utilizando try-with-resources
        
        /*
//        try (Statement stm = con.createStatement()) {
//            return stm.execute(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
           */
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
