/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        

    }
    
    public void actualizar_pruducto() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in).useLocale(Locale.US);
        Scanner scan3 = new Scanner(System.in);
        
        int opcionActualizar = 0;
        int opcion = 0;
        String nuevoTitulo = "";
        double nuevoPrecio = 0.00;
        String nuevoDescripcion ="";
        
        
        System.out.println("Ingrese el ID del producto que desea actualizar");
        opcionActualizar = scan.nextInt();
        for (int i = 0; i < listaProducto.size(); i++) {
            if (opcionActualizar == listaProducto.get(i).id) {
                System.out.println("El titulo es: " + listaProducto.get(i).titulo);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nuevo titulo");
                        nuevoTitulo = scan2.nextLine();
                        listaProducto.get(i).setTitulo(nuevoTitulo);
                        opcion = 0;
                        break;
                    case 2:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
                
                
                System.out.println("El precio es: " + listaProducto.get(i).precio);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nuevo precio");
                        nuevoPrecio = scan2.nextDouble();
                        listaProducto.get(i).setPrecio(nuevoPrecio);
                        opcion = 0;
                        break;
                    case 2:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
                System.out.println("La Descripcion es: " + listaProducto.get(i).descripcion);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nueva descripcion");
                        nuevoDescripcion = scan3.nextLine();
                        listaProducto.get(i).setDescripcion(nuevoDescripcion);
                        opcion = 0;
                        break;
                    case 2:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }

            }

        }
    }
  
  

  public void ver_producto() {
        for (int i = 0; i < listaProducto.size(); i++) {
            System.out.println("ID_PRODUCTO: " + listaProducto.get(i).id + " TITULO: "
                    + listaProducto.get(i).titulo + " PRECIO: Q" + listaProducto.get(i).precio
                    + " DESCRIPCION: " + listaProducto.get(i).descripcion);
        }
    }
}
