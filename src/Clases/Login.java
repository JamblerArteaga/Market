package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    ArrayList<Login> listaUsuarios = new ArrayList<Login>();
    Empleado emp = new Empleado();
    Cliente cl = new Cliente();
    Scanner scan = new Scanner(System.in);

    public Login(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    private String usuario;
    private String contrasenia;

    public void ingresar_sistema() {
        if (listaUsuarios.size() == 0) {
            listaUsuarios.add(new Login("admin", "admin"));
            listaUsuarios.add(new Login("cajero", "cajero"));
        }
        String validacion = "";
        int opcion = 0;
        /**
         * ************INICIO ACCIONES GERENTE GENERAL************************
         */
        if (this.getUsuario().equals(listaUsuarios.get(0).usuario) && this.getContrasenia().equals(listaUsuarios.get(0).contrasenia)) {
            System.out.println("\n");
            System.out.println("BIENVENIDO ADMINISTRADOR");

            System.out.println("¿Que desea hacer?:");
            System.out.println("1. Desplegar reporte");
            System.out.println("2. Crear cliente");
            System.out.println("3. Crear o asignar linea de credito");
            System.out.println("4. Administración de locales");
            System.out.println("5. Administrar personal");
            System.out.println("6. Ver Clientes");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    cl.crear_cliente();
                    this.ingresar_sistema();
                    break;
                case 3:
                    System.out.println("1. Crear nueva linea de credito");
                    System.out.println("2. Asignar nueva linea de credito");
                    opcion = scan.nextInt();
                    switch (opcion) {
                        case 1:

                            break;
                        case 2:

                            break;
                        default:
                            System.out.println("Opcion no existe");
                    }
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
                                    emp.crear_empleado("cajero");
                                    this.ingresar_sistema();
                                    break;
                                case 2:
                                    validacion = "crearGerenteTienda";
                                    emp.crear_empleado("gerente");
                                    this.ingresar_sistema();
                                    break;
                                default:
                                    System.out.println("Opción no existe");
                            }
                            break;
                        case 2:

                            emp.actualizar_empleado();
                            this.ingresar_sistema();

                            break;
                        case 3:
                            emp.ver_personal();
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
                default:
                    System.out.println("Opción no existe");
            }
            /**
             * ************FIN ACCIONES GERENTE GENERAL************************
             */
            /**
             * ************INICIO ACCIONES CAJERO ************************
             */
        } else if (this.getUsuario().equals(listaUsuarios.get(1).usuario) && this.getContrasenia().equals(listaUsuarios.get(1).contrasenia)) {
            System.out.println("\n");
            System.out.println("BIENVENIDO CAJERO");
            System.out.println("¿Que desea hacer?:");
            System.out.println("1. Crear factura");
            System.out.println("2. Agregar detalle");
            System.out.println("3. Calcular total");
            System.out.println("4. Registrar cliente");
            System.out.println("5. Asignar metodo de pago");
            System.out.println("6. Desplegar reporte");
            System.out.println("7. Crear cliente");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Opción no existe");
            }
            /**
             * ************FIN ACCIONES CAJERO************************
             */
        }
        // return validacion;
    }

}
