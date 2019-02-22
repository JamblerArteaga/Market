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
    
    public static Producto instance = null;
    
     public static Producto instance(){
        if(instance == null){
            instance = new Producto();
        }
        
        return instance;
    }
    
    
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
  
  

  public void ver_producto() {
        for (int i = 0; i < listaProducto.size(); i++) {
            System.out.println("ID_PRODUCTO: " + listaProducto.get(i).id + " TITULO: "
                    + listaProducto.get(i).titulo + " PRECIO: Q" + listaProducto.get(i).precio
                    + " DESCRIPCION: " + listaProducto.get(i).descripcion);
        }
    }
  
  
  public Producto buscar_producto(int id){
      for(Producto producto: this.listaProducto){
          if(producto.getId() == id){
              return producto;
          }
      }
      return null;
  }
}
