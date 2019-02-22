/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.*;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author chrisloops
 */
public class CajaControlador {
     public static CajaControlador instance;
     private ArrayList<Factura> facturas = new ArrayList<Factura>();
    
     public static CajaControlador instance(){
        if(instance == null){
            instance = new CajaControlador();
        }
        
        return instance;
    }

    public static CajaControlador getInstance() {
        return instance;
    }

    public static void setInstance(CajaControlador instance) {
        CajaControlador.instance = instance;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
     
     //PROCESO DE REGISTRO DE FACTURA
      public void registrarFactura(){
         Scanner sc = new Scanner(System.in);
         Factura factura = new Factura();
         System.out.println("Ingrese el NIT del cliente.");
         String id = sc.next();
         
         Cliente cliente = Cliente.instance().buscarCliente(id);
         
         if(cliente == null){
             System.out.println("Lo sentimos no encontramos al usuario en el sistema por favor ingresa sus datos.");
             cliente = Cliente.instance().crear_cliente();
         }
         
         factura.setCliente(cliente);
         factura.setEmpleado(Login.instance().getUsuario_logueado());
         
         ArrayList<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
         
         String continuar = "";
         do{
             
             DetalleFactura dtalle = new DetalleFactura();
             
             //BUSCAR PRODUCTO PARA AGREGARLO AL DETALLE
             Producto producto = null;
             
             do{
                System.out.print("Ingresa el codigo del producto ");
                producto = new Producto();
                
                if(producto == null){
                   System.out.println("\n\nEl producto no se encuentra en nuestros registros vuelve a intentar.\n\n");
                }
                
             }while(producto == null);
             dtalle.setProducto(producto);
             
             System.out.print("Ingresa la cantidad.\n\n");
             dtalle.setCantidad(sc.nextInt());
             detalles.add(dtalle);
             
             
             System.out.println("Deseas ingresar otro detalle y/n.");
             
             continuar = sc.next();
             
             
             
         }while(continuar == "Y" || continuar == "y");
         
         factura.setDetalles(detalles);
         
         TipoPago tipoPago = null;
         do{
            System.out.println("\n\nSelecciona el tipo de Pago");

            for(TipoPago pago:TipoPagoControlador.instance().getTipos_de_pago()){ 
               System.out.println(pago.getId()+". "+pago.getFormaPago());
            }
            
           tipoPago = TipoPagoControlador.instance().buscar(sc.nextInt());
           
           if(tipoPago == null){
               System.out.print("\n\nSelecciona un tipo de pago valido\n\n");
           }
         
         }while(tipoPago == null);
         
         factura.setTipoPago(tipoPago);
         
         this.facturas.add(factura);
     }
}
