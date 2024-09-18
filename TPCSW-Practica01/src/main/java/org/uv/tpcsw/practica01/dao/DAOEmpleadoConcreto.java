package org.uv.tpcsw.practica01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEmpleadoConcreto implements IDAOGeneral<EmpleadoPojo, String> {

    @Override
    public boolean save(EmpleadoPojo pojo) {
        
        ConexionDB con = ConexionDB.getInstance();
        String sql = "insert into empleados (clave, nombre, direccion, telefono) values "
                + "('" + pojo.getClave() + "', '" + pojo.getNombre() + "', '"
                + pojo.getDireccion() + "', '" + pojo.getTelefono() + "');";
        
        return con.execute(sql);
    }

    @Override
    public boolean delete(String id) {
        
        ConexionDB con = ConexionDB.getInstance();
        String sql = "delete from empleados where clave =" + id;
        
        return con.execute(sql);
    }

    @Override
    public boolean update(EmpleadoPojo pojo, String id) {
        
        ConexionDB con = ConexionDB.getInstance();
        String sql = "update empleados "
                + "set clave = " + pojo.getClave() + ", "
                + "set nombre = " + pojo.getNombre() + ", "
                + "set telefono = " + pojo.getTelefono() + ", "
                + "set direccion = " + pojo.getDireccion() +
                "where clave = " + id;
        
        return con.execute(sql);
    }

    @Override
    public List<EmpleadoPojo> findAll() {
        
        List<EmpleadoPojo> empleados = new ArrayList<>();
       
        ConexionDB conexionDB = ConexionDB.getInstance();
        String sql = "select * from empleados";
        
        try(Connection con = conexionDB.getCon();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery()) {
       
            while(rs.next()){
                EmpleadoPojo empleado = new EmpleadoPojo();
                empleado.setClave(rs.getString("clave"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setDireccion(rs.getString("direccion"));
                
                empleados.add(empleado);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return empleados;
    }

    @Override
    public EmpleadoPojo findById(String id) {

        EmpleadoPojo empleadoPojo = null;
        
        ConexionDB conexionDB = ConexionDB.getInstance();
        String sql = "select * from empleados where clave = ?";
        
        try (Connection con = conexionDB.getCon();
             PreparedStatement stm = con.prepareStatement(sql)) {
            
            stm.setString(1, id);
            
            try(ResultSet rs = stm.executeQuery()){
                if(rs.next()) {
                    empleadoPojo = new EmpleadoPojo();
                    empleadoPojo.setClave(rs.getString("clave"));
                    empleadoPojo.setNombre(rs.getString("nombre"));
                    empleadoPojo.setTelefono(rs.getString("telefono"));
                    empleadoPojo.setDireccion(rs.getString("direccion"));
                        
                }
            }
        }  catch (SQLException ex) {
                Logger.getLogger(DAOEmpleadoConcreto.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return empleadoPojo;
    }
    
}
