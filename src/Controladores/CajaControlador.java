/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.*;
import java.text.SimpleDateFormat;
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
      public boolean registrarFactura(){
          
          Helper.instance().clean();
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
         
         String choice = "";
         do{
             Helper.instance().clean();
             System.out.println("Factura Serie A "+factura.getId()+"\n\n");
             
             
             System.out.println("NIT "+factura.getCliente().getNIT());
             System.out.println("Cliente "+factura.getCliente().getNombre()+" "+factura.getCliente().getApellido());
             
             System.out.println("Le atiende "+factura.getEmpleado().getName()+" "+factura.getEmpleado().getLastName()+"\n\n");
             
             for(DetalleFactura detalle: detalles){
                System.out.println("ID("+detalle.getId()+"): "+detalle.getProducto().getTitulo()+"(Q."+detalle.getProducto().getPrecio()+")*"+detalle.getCantidad()+"..........Q."+detalle.getTotal());
                 
             }
             
             
             
             System.out.println("\n\nOpciones");
             System.out.println("1. Agregar Detalle");
             System.out.println("2. Eliminar Detalle");
             System.out.println("3. Terminar Facturacion");
             System.out.println("4. Cancelar Factura");
             
             choice = sc.next();
             
             switch(choice){
                 case "1":
                     
                     //AGREGAR DETALLE A FACTURA
                     DetalleFactura dtalle = new DetalleFactura();
             
                    //BUSCAR PRODUCTO PARA AGREGARLO AL DETALLE
                    Producto producto = null;

                    do{
                       System.out.print("Ingresa el codigo del producto ");
                       producto = Producto.instance().buscar_producto(sc.nextInt());

                       if(producto == null){
                          System.out.println("\n\nEl producto no se encuentra en nuestros registros vuelve a intentar.\n\n");
                       }

                    }while(producto == null);
                    dtalle.setProducto(producto);

                    System.out.print("Ingresa la cantidad.\n\n");
                    dtalle.setCantidad(sc.nextInt());
                    dtalle.setTotal(dtalle.getProducto().getPrecio()*dtalle.getCantidad());

                    detalles.add(dtalle);

                     
                     break;
                 case "2":
                     System.out.println("Escribe el ID del item a borrar");
                     int toErase = sc.nextInt();
                     boolean hasErased =false;
                    
                         for (int i=detalles.size()-1;i>=0;i--) {    
                         if(detalles.get(i).getId() == toErase){
                             detalles.remove(i);
                             hasErased = true;
                         }
                     }
                     
                     if(hasErased){
                         System.out.println("Se ha borrado el detalle.");
                     }else{
                         
                         System.out.println("NO se ha borrado el detalle. Intenta de nuevo.");
                     }
                     
                     break;
                     
                 case "3":
                     
                     break;
                     
                 case "4":
                     return true;
                 default:
                     System.out.println("Por favor elija una opcion valida");
                     break;
             }
             
             
         }while(!choice.equals("3"));
         
         factura.setDetalles(detalles);
         
         TipoPago tipoPago = null;
         do{
            System.out.println("\n\nSelecciona el tipo de Pago");

            for(TipoPago pago:TipoPagoControlador.instance().getTipos_de_pago()){ 
               System.out.println(pago.getId()+". "+pago.getFormaPago());
            }
            
               System.out.println("4. Cancelar factura");
            
              int id_tipo_pago = sc.nextInt();
              
              if(id_tipo_pago == 4){
                  return true;
              }
               
           tipoPago = TipoPagoControlador.instance().buscar(id_tipo_pago);
           
           
           if(tipoPago == null){
               System.out.print("\n\nSelecciona un tipo de pago valido\n\n");
           }
           
           
           if(LineaCredito.instance().buscar_linea_credito(cliente.getNIT()) != null){
               System.out.print("\n\nEl usuario ya cuenta con una linea de credito activa por favor selecciona otro metodo de pago\n\n");
               tipoPago = null;
           }
         
         }while(tipoPago == null);
         
         
         
         factura.setTipoPago(tipoPago);
         
         if(tipoPago.getId() == 3){
             LineaCredito.instance().crear_linea_credito(String.valueOf(factura.getId()), cliente.getNombre(), cliente.getNIT(), factura.getTotal().toString());
         }
         
         factura.setFecha(new Date());
         
         this.facturas.add(factura);
         
         return true;
     }
      
      
      public void desplegarReporte(){
          Helper.instance().clean();
          SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
          Date date = new Date();
          String today = format.format(date);
          System.out.println("Reporte del dia :"+today);
          
          Double total = 0.00;
          Double aBanco = 0.00;
          for(TipoPago tipo: TipoPagoControlador.instance().getTipos_de_pago()){
          
              Double subtotal = 0.00;
              for(Factura factura :this.facturas){
                  if(factura.getTipoPago().getId() == tipo.getId() && format.format(factura.getFecha()).equals(today)){
                      subtotal +=factura.getTotal();
                  }
              }
              
              total+= subtotal;
              if(tipo.isaBanco()){
                  aBanco+=subtotal;
              }
              
              System.out.println(tipo.getFormaPago()+"----------Q."+subtotal);
          }
          
              System.out.println("\n\nTotal----------Q."+total);
              
              
              System.out.println("\n\nSe debe depositar en el banco----------Q."+aBanco);
          
      }
}
