package org.uv.tpcsw.practica01;

import java.util.logging.Logger;
import org.uv.tpcsw.practica01.dao.DAOEmpleadoConcreto;
import org.uv.tpcsw.practica01.dao.EmpleadoPojo;

public class TPCSWPractica01 {

    private static final Logger logger = Logger.getLogger(TPCSWPractica01.class.getName());
    
    public static void main(String[] args) {
        
        /*  
        
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
    */
//        Singleton s1 = Singleton.getInstance();
//        Singleton s2 = Singleton.getInstance();
//        
//        Logger.getLogger(TPCSW_Practica01.class.getName()).log(Level.INFO, null, "Adiossss");
//        
//        logger.log(Level.INFO, "Singleton Instance 1: {0}", s1);
//        logger.log(Level.INFO, "Singleton Instance 2: {0}", s2);

    DAOEmpleadoConcreto dao = new DAOEmpleadoConcreto();
        EmpleadoPojo empleado = new EmpleadoPojo();
        empleado.setClave("12");
        empleado.setNombre("Yamile");
        empleado.setDireccion("Calle 13");
        empleado.setTelefono("1234");
        
        dao.save(empleado);
    }
}
