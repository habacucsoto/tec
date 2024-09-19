package org.uv.tpcsw.practica01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.uv.tpcsw.practica01.dao.DAOEmpleadoConcreto;
import org.uv.tpcsw.practica01.dao.EmpleadoPojo;
import org.uv.tpcsw.practica01.Inyeccion.*;
import org.uv.tpcsw.practica01.dao.*;

public class TPCSWPractica01 {

//    private static final Logger logger = Logger.getLogger(TPCSWPractica01.class.getName());
    
    public static void main(String[] args) {
        
        ConexionDB conexion = ConexionDB.getInstance();
        EmpleadoPojo pojo = new EmpleadoPojo();
        pojo.setClave("01");
        pojo.setNombre("tony");
        pojo.setDireccion("AV");
        pojo.setTelefono("3289459");
        TransactionDB <EmpleadoPojo> transaction= new TransactionDB<EmpleadoPojo>(pojo){
            @Override
            public boolean execute(Connection con) {
                
                
                try {
                    String sql ="insert into empleados (clave, nombre, direccion, telefono) values"
                            +"(?,?,?,?) ";
                    PreparedStatement pst = con.prepareStatement(sql);
                    
                    pst.setString(1, pojo.getClave());
                    pst.setString(2, pojo.getNombre());
                    pst.setString(3, pojo.getDireccion());
                    pst.setString(4, pojo.getTelefono());
                     
                    return pst.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(TPCSWPractica01.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }

            }
           
        };
        conexion.execute(transaction);
        
        
        
        
        
        
        
        
        
        
//        MensajeCotroller controller =new MensajeCotroller();
//        SaludoConcreto skudo = new SaludoConcreto();
//        DespedidaConcreto despedida = new DespedidaConcreto();
//        IMensajeID msg = new IMensajeID() {
//            @Override
//            public void imprimir() {
//                System.out.println("otro mensaje id ");
//            }
//        };
//                controller.mostrar(msg);
        
//        Mensaje msgV = null;
//        msgV = new Saludo();
//        msgV.imprimir();
//        
//        msgV = new Despedida();
//        msgV.imprimir();
// 
//        msgV = new Mensaje() {
//           @Override
//           protected void msg(){
//               System.out.println("Otro mensaje");
//           }
//       };
//        
//        msgV.imprimir();
        
//        MensajeConcreto msg = null;
//        msg = new MensajeConcreto("Daniel");
//        msg.imprimir();
//      
//        System.out.println("Hello World!");

//        IMensaje msgV = null;
//        msgV = new Saludo2();
//        msgV.imprimir();
//        
//        msgV = new Despedida2();
//        msgV.imprimir();
// 
//        msgV = () -> {
//            System.out.println("Otro mensaje...");
//        };
//
//        msgV.imprimir();
   
//        Singleton s1 = Singleton.getInstance();
//        Singleton s2 = Singleton.getInstance();
//        
//        Logger.getLogger(TPCSW_Practica01.class.getName()).log(Level.INFO, null, "Adiossss");
//        
//        logger.log(Level.INFO, "Singleton Instance 1: {0}", s1);
//        logger.log(Level.INFO, "Singleton Instance 2: {0}", s2);
//
//    DAOEmpleadoConcreto dao = new DAOEmpleadoConcreto();
//        EmpleadoPojo empleado = new EmpleadoPojo();
//        empleado.setClave("12");
//        empleado.setNombre("Yamile");
//        empleado.setDireccion("Calle 13");
//        empleado.setTelefono("1234");
//        
//        dao.save(empleado);
    }
}
