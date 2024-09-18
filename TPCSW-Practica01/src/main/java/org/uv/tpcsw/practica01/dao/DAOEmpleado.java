package org.uv.tpcsw.practica01.dao;

import java.util.List;

public class DAOEmpleado {
    
    public boolean guardar(EmpleadoPojo empleado){
        empleado.getClave();
        return false;
    }
    
    public boolean eliminar(EmpleadoPojo empleado){
        empleado.getClave();
        return true;
    }
    
    public boolean modificar(EmpleadoPojo empleado){
        empleado.getClave();
        return true;
    }
    
    public List<EmpleadoPojo> findAll(){
        return null;
    }
   
    public EmpleadoPojo findById(EmpleadoPojo empleado){
        empleado.getClave();
        return null;
    }
    
}
