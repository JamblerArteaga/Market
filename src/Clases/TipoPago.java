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
public class TipoPago {
    private int id;
    private String formaPago;
    private boolean aBanco;

    public TipoPago(int id, String formaPago, boolean aBanco) {
        this.id = id;
        this.formaPago = formaPago;
        this.aBanco = aBanco;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public boolean isaBanco() {
        return aBanco;
    }

    public void setaBanco(boolean aBanco) {
        this.aBanco = aBanco;
    }

    
}
