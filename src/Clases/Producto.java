package Clases;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Producto {

    ArrayList<Producto> listaProducto = new ArrayList<Producto>();

    public int idN = 0;

    public Producto(int id, String titulo, double precio, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
       
    }

    public Producto() {

        listaProducto.add(new Producto(idN++, "Producto1", 15.50, "Helado"));
        listaProducto.add(new Producto(idN++,"Producto2", 20.25, "Frijoles en lata"));
        listaProducto.add(new Producto(idN++,"Producto2", 1.50, "libra de sal"));
        listaProducto.add(new Producto(idN++,"Producto2", 10.25, "Incaparina"));
        listaProducto.add(new Producto(idN++,"Producto2", 26.75, "Cereal"));
        listaProducto.add(new Producto(idN++,"Producto2", 30.25, "Jabon en Polvo"));
        listaProducto.add(new Producto(idN++,"Producto2", 10.30, "papel higienico"));
        
     
    }

   

    public int getIdN() {
        return idN;
    }

    public void setIdN(int idN) {
        this.idN = idN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    private int id;
    private String titulo;
    private double precio;
    private String descripcion;
  

  public void crear_producto() {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        Scanner scanSTR = new Scanner(System.in);
        
        String tituloPr = "";
        double precioPr = 0.00;
        String descripcionPr = "";

        System.out.println("Ingrese titulo del Prodcuto");
        tituloPr = scanSTR.nextLine();
        System.out.println("Ingrese precio del Producto");
        precioPr = scan.nextDouble();
        System.out.println("Ingrese Descripcion del Producto");
        descripcionPr = scanSTR.nextLine();
        
        listaProducto.add(new Producto(idN++, tituloPr, precioPr, descripcionPr));
        int a=0;

    }
  
  

//    public void actualizar_empleado() {
//        Scanner scan = new Scanner(System.in);
//        Scanner scan2 = new Scanner(System.in);
//        int opcionActualizar = 0;
//        int opcion = 0;
//        String nuevoNombre = "";
//        String nuevoApellido = "";
//        String nuevoRol;
//        String nuevoUsuario;
//        String nuevoContrasenia;
//        String nuevoLocal;
//        String nuevoCaja;
//        boolean nuevoEstado;
//        System.out.println("Ingrese el ID del empleado que desea actualizar");
//        opcionActualizar = scan.nextInt();
//        for (int i = 0; i < listaEmpleados.size(); i++) {
//            if (opcionActualizar == listaEmpleados.get(i).id) {
//                System.out.println("El nombre es: " + listaEmpleados.get(i).name);
//                System.out.println("Desea actualizarlo?");
//                System.out.println("1. SI");
//                System.out.println("2. NO");
//                opcion = scan.nextInt();
//                switch (opcion) {
//                    case 1:
//                        System.out.println("Ingrese nuevo nombre");
//                        nuevoNombre = scan2.nextLine();
//                        listaEmpleados.get(i).setName(nuevoNombre);
//                        opcion = 0;
//                        break;
//                    case 2:
//                        opcion = 0;
//                        break;
//                    default:
//                        System.out.println("Opción no existe");
//                }
//                System.out.println("El apellido es: " + listaEmpleados.get(i).lastName);
//                System.out.println("Desea actualizarlo?");
//                System.out.println("1. SI");
//                System.out.println("2. NO");
//                opcion = scan.nextInt();
//                switch (opcion) {
//                    case 1:
//                        System.out.println("Ingrese nuevo apellido");
//                        nuevoApellido = scan2.nextLine();
//                        listaEmpleados.get(i).setLastName(nuevoApellido);
//                        opcion = 0;
//                        break;
//                    case 2:
//                        opcion = 0;
//                        break;
//                    default:
//                        System.out.println("Opción no existe");
//                }
//                System.out.println("El rol es: " + listaEmpleados.get(i).rol);
//                System.out.println("Desea actualizarlo?");
//                System.out.println("1. SI");
//                System.out.println("2. NO");
//                opcion = scan.nextInt();
//                switch (opcion) {
//                    case 1:
//                        System.out.println("Ingrese nuevo rol");
//                        nuevoRol = scan2.nextLine();
//                        listaEmpleados.get(i).setRol(nuevoRol);
//                        opcion = 0;
//                        break;
//                    case 2:
//                        opcion = 0;
//                        break;
//                    default:
//                        System.out.println("Opción no existe");
//                }
//
//                System.out.println("El usuario actual es: " + listaEmpleados.get(i).usuario);
//                System.out.println("Desea actualizarlo?");
//                System.out.println("1. SI");
//                System.out.println("2. NO");
//                opcion = scan.nextInt();
//                switch (opcion) {
//                    case 1:
//                        System.out.println("Ingrese nuevo usuario");
//                        nuevoUsuario = scan2.nextLine();
//                        listaEmpleados.get(i).setUsuario(nuevoUsuario);
//                        opcion = 0;
//                        break;
//                    case 2:
//                        opcion = 0;
//                        break;
//                    default:
//                        System.out.println("Opción no existe");
//                }
//                System.out.println("La contraseña actual es: " + listaEmpleados.get(i).contrasenia);
//                System.out.println("Desea actualizarlo?");
//                System.out.println("1. SI");
//                System.out.println("2. NO");
//                opcion = scan.nextInt();
//                switch (opcion) {
//                    case 1:
//                        System.out.println("Ingrese nueva contrasenia");
//                        nuevoContrasenia = scan2.nextLine();
//                        listaEmpleados.get(i).setContrasenia(nuevoContrasenia);
//                        opcion = 0;
//                        break;
//                    case 2:
//                        opcion = 0;
//                        break;
//                    default:
//                        System.out.println("Opción no existe");
//                }
//                System.out.println("El local actual es: " + listaEmpleados.get(i).local);
//                System.out.println("Desea actualizarlo?");
//                System.out.println("1. SI");
//                System.out.println("2. NO");
//                opcion = scan.nextInt();
//                switch (opcion) {
//                    case 1:
//                        System.out.println("Ingrese nuevo local");
//                        nuevoLocal = scan2.nextLine();
//                        listaEmpleados.get(i).setLocal(nuevoLocal);
//                        opcion = 0;
//                        break;
//                    case 2:
//                        opcion = 0;
//                        break;
//                    default:
//                        System.out.println("Opción no existe");
//                }
//                System.out.println("El la caja actual es: " + listaEmpleados.get(i).caja);
//                System.out.println("Desea actualizarlo?");
//                System.out.println("1. SI");
//                System.out.println("2. NO");
//                opcion = scan.nextInt();
//                switch (opcion) {
//                    case 1:
//                        System.out.println("Ingrese la nueva caja");
//                        nuevoCaja = scan2.nextLine();
//                        listaEmpleados.get(i).setCaja(nuevoCaja);
//                        opcion = 0;
//                        break;
//                    case 2:
//                        opcion = 0;
//                        break;
//                    default:
//                        System.out.println("Opción no existe");
//                }
//               
//                System.out.println("El Estado actual es: " + listaEmpleados.get(i).estado);
//                System.out.println("Desea actualizarlo?");
//                System.out.println("1. SI");
//                System.out.println("2. NO");
//                opcion = scan.nextInt();
//                switch (opcion) {
//                    case 1:
//                        System.out.println("Ingrese nuevo estado");
//                        nuevoEstado = scan.nextBoolean();
//                        listaEmpleados.get(i).setEstado(nuevoEstado);
//                        opcion = 0;
//                        break;
//                    case 2:
//                        opcion = 0;
//                        break;
//                    default:
//                        System.out.println("Opción no existe");
//                }
//
//            }
//
//        }
//    }

  public void ver_producto() {
        for (int i = 0; i < listaProducto.size(); i++) {
            System.out.println("ID_PRODUCTO: " + listaProducto.get(i).id + " TITULO: "
                    + listaProducto.get(i).titulo + " PRECIO: Q" + listaProducto.get(i).precio
                    + " DESCRIPCION: " + listaProducto.get(i).descripcion);
        }
    }
}
