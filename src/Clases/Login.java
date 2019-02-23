package Clases;

import Controladores.CajaControlador;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    ArrayList<Login> listaUsuarios = new ArrayList<Login>();
    Cliente cl = new Cliente();
    Producto Pr = new Producto();
    
    LineaCredito linCre = new LineaCredito();
    Scanner scan = new Scanner(System.in);
    private Empleado usuario_logueado = null;
    
   
    public static Login instance;
    
     public static Login instance(){
        if(instance == null){
            instance = new Login();
        }
        
        return instance;
    }
    
    public Login(){
    }

    public Empleado getUsuario_logueado() {
        return usuario_logueado;
    }

    public void setUsuario_logueado(Empleado usuario_logueado) {
        this.usuario_logueado = usuario_logueado;
    }
    
    
    public void inicio(){
        //Intentos de login
        do{
            System.out.println("Ingrese su usuario:");
            Scanner scan = new Scanner(System.in);
            String usuarioIngresado = scan.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contraseniaIngresado = scan.nextLine();
        
            this.usuario_logueado = Empleado.instance().intentoLogin(usuarioIngresado, contraseniaIngresado);
            
            if (this.usuario_logueado == null){
                System.out.println("\n\nEl usuario y la contraseña no coincide con nuestros registros vuelve a intentar.\n\n");
            }
        }while(this.usuario_logueado == null );
        
        this.ingresar_sistema();
    }

    public void ingresar_sistema() {
        String validacion = "";
        int opcion = 0;
        
        /**
         * ************INTENTO DE LOGIN************************
         */
        /**
         * ************INICIO ACCIONES GERENTE GENERAL************************
         */
        
        switch(this.usuario_logueado.getRol()){
            case "Gerente Tienda":
                 System.out.println("\n");
            System.out.println("BIENVENIDO ADMINISTRADOR");

            System.out.println("¿Que desea hacer?:");
            System.out.println("1. Desplegar reporte");
            System.out.println("2. Crear cliente");
            System.out.println("3. Crear o asignar linea de credito");
            System.out.println("4. Administración de locales");
            System.out.println("5. Administrar personal");
            System.out.println("6. Ver Clientes");
            System.out.println("7. Agregar productos");
            System.out.println("8. Ver Productos");
            System.out.println("9. Actualizar Producto");
                
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    cl.crear_cliente();
                    this.ingresar_sistema();
                    break;
                case 3:
                    Scanner scanCre = new Scanner(System.in);
                    Scanner scanDoubleCre = new Scanner (System.in).useLocale(Locale.US);
                    String numFact = "";
                    String nombreCl = "";
                    String NITCl = "";
                    String valorCL = "0.00";
                    System.out.println("En esta opción se deben de crear/asignar las lineas de creditos ");
                    System.out.println("");
                    System.out.println("Ingrese numero de factura");
                    numFact =scanCre.nextLine();
                    System.out.println("Ingrese nombre de cliente");
                    nombreCl =scanCre.nextLine();
                    System.out.println("Ingrese NIT de cliente");
                    NITCl =scanCre.nextLine();
                    System.out.println("Ingrese monto a cobrar");
                    valorCL =scanCre.nextLine();
                    linCre.crear_linea_credito(numFact, nombreCl, NITCl, valorCL);
                    this.ingresar_sistema();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("1. Crear empleado");
                    System.out.println("2. Actualizar empleado");
                    System.out.println("3. Ver todo el personal");
                    opcion = scan.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("1. Crear Cajero");
                            System.out.println("2. Crear Gerente de tienda");
                            opcion = scan.nextInt();
                            switch (opcion) {
                                case 1:
                                    validacion = "crearCajero";
                                    Empleado.instance().crear_empleado("cajero");
                                    this.ingresar_sistema();
                                    break;
                                case 2:
                                    validacion = "crearGerenteTienda";
                                    Empleado.instance().crear_empleado("gerente");
                                    this.ingresar_sistema();
                                    break;
                                default:
                                    System.out.println("Opción no existe");
                            }
                            break;
                        case 2:

                            Empleado.instance().actualizar_empleado();
                            this.ingresar_sistema();

                            break;
                        case 3:
                            Empleado.instance().ver_personal();
                            this.ingresar_sistema();
                            break;
                        default:
                            System.out.println("Opción no existe");

                    }
                    break;
                case 6:
                    cl.ver_clientes();
                    this.ingresar_sistema();
                    break;
                 case 7:
                    Pr.crear_producto();
                    this.ingresar_sistema();
                    break;
                case 8:
                    Pr.ver_producto();
                    this.ingresar_sistema();
                    break; 
                case 9:
                    Pr.actualizar_pruducto();
                    this.ingresar_sistema();
                    break;
                    
                default:
                    System.out.println("Opción no existe");
            }
            /**
             * ************FIN ACCIONES GERENTE GENERAL************************
             */
                break;
                
            case "Cajero":
                
                 System.out.println("\n");
            System.out.println("BIENVENIDO CAJERO");
            System.out.println("¿Que desea hacer?:");
            System.out.println("1. Crear factura");
            System.out.println("2. Hacer corte y desplegar reporte");
            System.out.println("3. Crear cliente");
            System.out.println("4. Logout");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    CajaControlador.instance().registrarFactura();
                    this.ingresar_sistema();
                    break;
                case 2:
                    CajaControlador.instance().desplegarReporte();
                    this.ingresar_sistema();
                    break;
                case 3:
                    Cliente.instance().crear_cliente();
                    this.ingresar_sistema();
                    break;
                    
                case 4:
                    this.usuario_logueado = null;
                    break;
                default:
                    System.out.println("Opción no existe");
                    this.ingresar_sistema();
                    break;
            }
            /**
             * ************FIN ACCIONES CAJERO************************
             */
            
                break;
        }
        // return validacion;
    }

}
