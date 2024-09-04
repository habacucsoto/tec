package org.uv.tpcsw.practica01.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOEmpleadoConcreto implements IDAOGeneral<EmpleadoPojo, String>{

    @Override
    public boolean save(EmpleadoPojo pojo) {
        ConexionDB con=ConexionDB.getInstance();
        String sql="insert into empleados (clave, nombre, direccion, telefono) values "
                + " ('"+ pojo.getClave() + "','" + pojo.getNombre() + "','" +
                pojo.getDireccion() +"','" + pojo.getTelefono() + "')";
        return con.execute(sql);
    }

    @Override
    public boolean delete(EmpleadoPojo pojo) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "DELETE FROM empleados WHERE clave = '" + pojo.getClave() + "'";
        return con.execute(sql);
    }

    @Override
    public boolean update(EmpleadoPojo pojo, String id) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "UPDATE empleados SET nombre = '" + pojo.getNombre() + 
                "', direccion = '" + pojo.getDireccion() + 
                "', telefono = '" + pojo.getTelefono() + 
                "' WHERE clave = '" + id + "'";
        return con.execute(sql);
    }

    @Override
    public List<EmpleadoPojo> findAll() {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "SELECT * FROM empleados";
        List<EmpleadoPojo> empleados = new ArrayList<>();
        ResultSet rs = con.query(sql);
        try {
            while (rs.next()) {
                EmpleadoPojo empleado = new EmpleadoPojo();
                empleado.setClave(rs.getString("clave"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setTelefono(rs.getString("telefono"));
                empleados.add(empleado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados;
    }

    @Override
    public EmpleadoPojo findById(String id) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "SELECT * FROM empleados WHERE clave = '" + id + "'";
        ResultSet rs = con.query(sql);
        try {
            if (rs.next()) {
                EmpleadoPojo empleado = new EmpleadoPojo();
                empleado.setClave(rs.getString("clave"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setTelefono(rs.getString("telefono"));
                return empleado;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
