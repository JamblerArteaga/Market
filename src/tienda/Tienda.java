
package tienda;

import Clases.Empleado;
import Clases.Login;
import java.util.Scanner;

public class Tienda {

    public static void main(String[] args){
        String usuarioIngresado="";
        String contraseniaIngresado="";
        String accionLogin = "";
        System.out.println("******************** LA TIENDITA ********************");
        System.out.println("******************** BIENVENIDO ********************");
        System.out.println("\n");
        System.out.println("Ingrese su usuario:");
        Scanner scan = new Scanner(System.in);
        usuarioIngresado = scan.nextLine();
        System.out.println("Ingrese su contraseña:");
        contraseniaIngresado = scan.nextLine();
        Login log = new Login(usuarioIngresado,contraseniaIngresado);
        log.ingresar_sistema();
       // Empleado emp = new Empleado();
//        accionLogin=log.ingresar_sistema();
//        if(accionLogin.equals("crearCajero")){
//            emp.crear_empleado("cajero");
//            log.ingresar_sistema();
//        }
        
        
        
        
        
        
        
    }
    
}
