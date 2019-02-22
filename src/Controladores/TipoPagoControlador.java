/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.*;
import java.util.*;
/**
 *
 * @author chrisloops
 */
public class TipoPagoControlador {
    public static TipoPagoControlador instance;
    private ArrayList<TipoPago> tipos_de_pago = new ArrayList<TipoPago>();
    
     public static TipoPagoControlador instance(){
        if(instance == null){
            instance = new TipoPagoControlador();
        }
        
        return instance;
    }
     
     public TipoPagoControlador(){
         this.tipos_de_pago.add(new TipoPago(1, "Efectivo", true));
         this.tipos_de_pago.add(new TipoPago(2, "Cheque", true));
         this.tipos_de_pago.add(new TipoPago(3, "Linea de Credito", false));
     }

    public ArrayList<TipoPago> getTipos_de_pago() {
        return tipos_de_pago;
    }

    public void setTipos_de_pago(ArrayList<TipoPago> tipos_de_pago) {
        this.tipos_de_pago = tipos_de_pago;
    }
    
    public TipoPago buscar(int id){
        for (TipoPago pago : this.tipos_de_pago){
            if(pago.getId() == id){
                return pago;
            }
        }
        
        return null;
    }
}
