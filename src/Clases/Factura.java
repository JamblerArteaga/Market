/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.*;
import java.time.DateTimeException;
/**
 *
 * @author chrisloops
 */
public class Factura {
    private int id;
    private Date fecha;
    private Cliente cliente;
    private Empleado empleado;
    private ArrayList<DetalleFactura> detalles;
    private TipoPago tipoPago;

    public Factura(){
    }
    
    public Factura(int id, Date fecha, Cliente cliente, Empleado empleado, ArrayList<DetalleFactura> detalles, TipoPago tipoPago) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.detalles = detalles;
        this.tipoPago = tipoPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ArrayList<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    
}
