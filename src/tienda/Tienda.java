
package tienda;

import Clases.Empleado;
import Clases.Helper;
import Clases.Login;
import java.util.Scanner;

public class Tienda {

    public static void main(String[] args){
        
        
       do{
           Helper.instance().clean();
            System.out.println("******************** LA TIENDITA ********************");
            System.out.println("******************** BIENVENIDO ********************");
            System.out.println("\n");
            Login.instance().inicio();
        
        }while(true);
       // Empleado emp = new Empleado();
//        accionLogin=log.ingresar_sistema();
//        if(accionLogin.equals("crearCajero")){
//            emp.crear_empleado("cajero");
//            log.ingresar_sistema();
//        }
        
        
        
        
        
        
        
    }
    
}
