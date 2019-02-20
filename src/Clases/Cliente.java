package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    public int idN = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public Cliente(int id, String nombre, String apellido, String NIT) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.NIT = NIT;
    }

    public Cliente() {

        listaClientes.add(new Cliente(idN++, "Mario Juan", "Perez Vasquez", "1234-2"));
        listaClientes.add(new Cliente(idN++, "Pedro Luis", "Hernandez Vasquez", "5421-2"));
        listaClientes.add(new Cliente(idN++, "Fernando Alejandro", "Hernandez Vasquez", "1453-1"));
        listaClientes.add(new Cliente(idN++, "Luis", "Velasquez", "5663-5"));
        listaClientes.add(new Cliente(idN++, "Jose", "Garcia", "4322-3"));

    }

    private int id;
    private String nombre;
    private String apellido;
    private String NIT;

    public void crear_cliente() {
        Scanner scan = new Scanner(System.in);
        String nombreCl = "";
        String apellidoCl = "";
        String NITCl = "";

        System.out.println("Ingrese nombres del cliente");
        nombreCl = scan.nextLine();
        System.out.println("Ingrese apellidos del cliente");
        apellidoCl = scan.nextLine();
        System.out.println("Ingrese NIT del cliente");
        NITCl = scan.nextLine();
        listaClientes.add(new Cliente(idN++, nombreCl, apellidoCl, NITCl));

    }

    public void ver_clientes() {
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("ID_CLIENTE: " + listaClientes.get(i).id + " NOMBRES: "
                    + listaClientes.get(i).nombre + " APELLIDOS: " + listaClientes.get(i).apellido
                    + " NIT: " + listaClientes.get(i).NIT);
        }
    }
}
