
package Clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class LineaCredito {
    ArrayList<LineaCredito> listaLineasCredito = new ArrayList<LineaCredito>();

    public int idN = 0;
    
     public static LineaCredito instance;
    
     public static LineaCredito instance(){
        if(instance == null){
            instance = new LineaCredito();
        }
        
        return instance;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
     public String getNITCliente() {
        return NITCliente;
    }

    public void setNITCliente(String NITCliente) {
        this.NITCliente = NITCliente;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LineaCredito(int id, String factura,String cliente, String NITCliente,  String plazo, String fechaVencimiento, String fechaRegistro, double monto, boolean activo) {
        this.id = id;
        this.factura = factura;
        this.cliente = cliente;
        this.NITCliente = NITCliente;
        this.plazo = plazo;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaRegistro = fechaRegistro;
        this.monto = monto;
        this.activo= activo;
    }
    public LineaCredito(){
        
       listaLineasCredito.add(new LineaCredito(idN++, "112312", "Juan Ramon", "234-5", "30 días", "30/01/2019", "01/01/2019", 2000.00,  false ));
       listaLineasCredito.add(new LineaCredito(idN++, "2342", "Alejadro hernandez", "234-3", "30 días", "30/12/2018", "01/12/2018", 1000.00,  true ));
       listaLineasCredito.add(new LineaCredito(idN++, "545345", "mario pineda", "23412-3", "30 días", "30/11/2019", "01/11/2019", 2400.00,  false ));
       listaLineasCredito.add(new LineaCredito(idN++, "1231", "Juan velasquez", "234-4", "30 días", "30/01/2019", "01/01/2019", 2500.00,  false ));
       listaLineasCredito.add(new LineaCredito(idN++, "234222", "Alejandra Ramona", "333-32", "30 días", "30/01/2019", "01/01/2019", 2000.00,  false ));
       listaLineasCredito.add(new LineaCredito(idN++, "423555", "Pedro ramirez", "1233-2", "30 días", "30/01/2019", "01/01/2019", 2000.00,  false ));
         
    }
    private int id;
    private String factura;
    private String cliente;
    private String NITCliente;
    private String plazo;
    private String fechaVencimiento;
    private String fechaRegistro;
    private double monto;
    private boolean activo;
    
    public void crear_linea_credito(String numFactura, String nombreCliente, String NIT, String valor){
        
        Date fecha = new Date();
        Calendar calendar = Calendar.getInstance(); 
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(calendar.DATE,30);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        String fechaActual = sdf.format(calendar2.getTime()).toString();
        String fechaVence = sdf.format(calendar.getTime());
        double valorDB = Double.parseDouble(valor);
    //    for (int i = 0; i < listaLineasCredito.size(); i++) {
//            if(listaLineasCredito.get(i).NITCliente.equals(NIT)){
//                System.out.println("El cliente no tiene disponibilidad para asignar linea de credito");
//            }else{
                listaLineasCredito.add(new LineaCredito(id++,numFactura,nombreCliente,NIT,"30 días",fechaVence, fechaActual, valorDB, true));
                
                System.out.println("Exitoso!!!");
                
//            }
            int a= 0;
       // }
        
       
        
        
        
    }
    
    public LineaCredito buscar_linea_credito(String NIT){
        for (LineaCredito linea : this.listaLineasCredito){
            
            if(linea != null && linea.getNITCliente().equals(NIT)){
                return linea;
            }
        }
        
        return null;
    }
}
