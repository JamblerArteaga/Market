/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author chrisloops
 */
public class DetalleFactura {
    private int id;
    private Producto producto;
    private int cantidad;
    private Double total;
    private static int tID=0;

    public DetalleFactura(){
        tID++;
        this.id = tID;
        
    }
    
    public DetalleFactura(Producto producto, int cantidad, Double total) {
        tID++;
        this.id = tID;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
