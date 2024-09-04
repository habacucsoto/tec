package org.uv.tpcsw.practica01.dao;

import java.util.List;

public class DAOEmpleado {

    public boolean guardar(EmpleadoPojo pojo) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "insert into empleados (clave, nombre, direccion, telefono) values "
                + " ('" + pojo.getClave() + "','" + pojo.getNombre() + "','"
                + pojo.getDireccion() + "','" + pojo.getTelefono() + "')";
        return con.execute(sql);
    }

    public boolean eliminar(EmpleadoPojo pojo) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "delete"
                + " ('" + pojo.getClave() + "','" + pojo.getNombre() + "','"
                + pojo.getDireccion() + "','" + pojo.getTelefono() + "')";
        return con.execute(sql);
    }

    public boolean modificar(EmpleadoPojo pojo) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "update"
                + " ('" + pojo.getClave() + "','" + pojo.getNombre() + "','"
                + pojo.getDireccion() + "','" + pojo.getTelefono() + "')";
        return con.execute(sql);
    }

    public List<EmpleadoPojo> buscarAll() {
        String sql = "select ";
        return null;
    }

    public EmpleadoPojo buscarById(EmpleadoPojo pojo) {
        String sql = "select by id"+ pojo;
        return null;
    }

}
