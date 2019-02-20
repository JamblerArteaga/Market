package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {

    ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

    public int idN = 0;

    public Empleado(int id, String name, String lastName, String rol, String usuario, String contrasenia, String local, String caja, boolean estado) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.local = local;
        this.caja = caja;
        this.estado = estado;

//        listaEmpleados.add(new Empleado(idN++, "jose", "Perez Rodriguez", "Cajero", "cajero", "cajero", "local 1", true));
//        listaEmpleados.add(new Empleado(idN++, "Pedro jose", "Perez Rodriguez", "Cajero", "cajero", "cajero", "local 1", true));
//        listaEmpleados.add(new Empleado(idN++, "Pedro jose", "Perez Rodriguez", "Cajero", "cajero", "cajero", "local 1", true));
//        listaEmpleados.add(new Empleado(idN++, "Pedro jose", "Perez Rodriguez", "Cajero", "cajero", "cajero", "local 1", true));
//        listaEmpleados.add(new Empleado(idN++, "Pedro jose", "Perez Rodriguez", "Cajero", "cajero", "cajero", "local 1", true));
    }

    public Empleado() {

        listaEmpleados.add(new Empleado(idN++, "Pedro jose", "Perez Rodriguez", "Cajero", "cajero", "cajero", "local 1", "caja 2", true));
        listaEmpleados.add(new Empleado(idN++, "Maria", "Perez Marroquin", "Cajero", "cajero", "cajero", "local 1", "caja 1", true));
        listaEmpleados.add(new Empleado(idN++, "Juan Ramon", "Velasquez", "Cajero", "cajero", "cajero", "local 2", "caja 2", true));
        listaEmpleados.add(new Empleado(idN++, "Juan Carlos", "Vasquez", "Gerente Tienda", "admin", "admin", "local 1", "caja 2", true));
        listaEmpleados.add(new Empleado(idN++, "Alejandro", "Argueta Marroquin", "Gerente Tienda", "admin", "admin", "local 2", "caja 1", true));
        listaEmpleados.add(new Empleado(idN++, "Pedro", "Echavarria", "Cajero", "cajero", "cajero", "local 2", "caja 1", true));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    private int id;
    private String name;
    private String lastName;
    private String rol;
    private String usuario;
    private String contrasenia;
    private String local;
    private String caja;
    private boolean estado;

    public void crear_empleado(String rol) {
        Scanner scan = new Scanner(System.in);
        String nombreEmp = "";
        String apellidoEmp = "";
        int localNT = 0;
        int cajaNT = 0;
        local = "";
        caja = "";
        boolean estado = true;
        if (rol.equals("cajero")) {
            System.out.println("Ingrese nombres del empleado");
            nombreEmp = scan.nextLine();
            System.out.println("Ingrese apellidos del empleado");
            apellidoEmp = scan.nextLine();
            do {
                System.out.println("Seleccione el local donde pertenecera el empleado");
                System.out.println("1. Local 1");
                System.out.println("2. Local 2");
                localNT = scan.nextInt();
                if (localNT == 1) {
                    local = "local 1";
                } else if (localNT == 2) {
                    local = "local 2";
                }
            } while (localNT < 1 || localNT > 2);

            do {
                System.out.println("Seleccione la caja del empleado");
                System.out.println("1. Caja 1");
                System.out.println("2. Caja 2");
                cajaNT = scan.nextInt();
                if (cajaNT == 1) {
                    caja = "Caja 1";
                } else if (cajaNT == 2) {
                    caja = "Caja 2";
                }
            } while (cajaNT < 1 || cajaNT > 2);
            listaEmpleados.add(new Empleado(idN++, nombreEmp, apellidoEmp, "Cajero", "cajero", "cajero", local, caja, true));
            int b = 0;
        } else {
            System.out.println("Ingrese nombres del gerente");
            nombreEmp = scan.nextLine();
            System.out.println("Ingrese apellidos del gerente");
            apellidoEmp = scan.nextLine();
            do {
                System.out.println("Seleccione el local donde pertenecera el gerente");
                System.out.println("1. Local 1");
                System.out.println("2. Local 2");
                localNT = scan.nextInt();
                if (localNT == 1) {
                    local = "local 1";
                } else if (localNT == 2) {
                    local = "local 2";
                }
            } while (localNT < 1 || localNT > 2);
            listaEmpleados.add(new Empleado(idN++, nombreEmp, apellidoEmp, "Gerente Tienda", "admin", "admin", local, "", true));

        }

    }

    public void actualizar_empleado() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int opcionActualizar = 0;
        int opcion = 0;
        String nuevoNombre = "";
        String nuevoApellido = "";
        String nuevoRol;
        String nuevoUsuario;
        String nuevoContrasenia;
        String nuevoLocal;
        String nuevoCaja;
        boolean nuevoEstado;
        System.out.println("Ingrese el ID del empleado que desea actualizar");
        opcionActualizar = scan.nextInt();
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (opcionActualizar == listaEmpleados.get(i).id) {
                System.out.println("El nombre es: " + listaEmpleados.get(i).name);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nuevo nombre");
                        nuevoNombre = scan2.nextLine();
                        listaEmpleados.get(i).setName(nuevoNombre);
                        opcion = 0;
                        break;
                    case 2:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
                System.out.println("El apellido es: " + listaEmpleados.get(i).lastName);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nuevo apellido");
                        nuevoApellido = scan2.nextLine();
                        listaEmpleados.get(i).setLastName(nuevoApellido);
                        opcion = 0;
                        break;
                    case 2:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
                System.out.println("El rol es: " + listaEmpleados.get(i).rol);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nuevo rol");
                        nuevoRol = scan2.nextLine();
                        listaEmpleados.get(i).setRol(nuevoRol);
                        opcion = 0;
                        break;
                    case 2:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }

                System.out.println("El usuario actual es: " + listaEmpleados.get(i).usuario);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nuevo usuario");
                        nuevoUsuario = scan2.nextLine();
                        listaEmpleados.get(i).setUsuario(nuevoUsuario);
                        opcion = 0;
                        break;
                    case 2:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
                System.out.println("La contraseña actual es: " + listaEmpleados.get(i).contrasenia);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nueva contrasenia");
                        nuevoContrasenia = scan2.nextLine();
                        listaEmpleados.get(i).setContrasenia(nuevoContrasenia);
                        opcion = 0;
                        break;
                    case 2:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
                System.out.println("El local actual es: " + listaEmpleados.get(i).local);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nuevo local");
                        nuevoLocal = scan2.nextLine();
                        listaEmpleados.get(i).setLocal(nuevoLocal);
                        opcion = 0;
                        break;
                    case 2:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
                System.out.println("El la caja actual es: " + listaEmpleados.get(i).caja);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la nueva caja");
                        nuevoCaja = scan2.nextLine();
                        listaEmpleados.get(i).setCaja(nuevoCaja);
                        opcion = 0;
                        break;
                    case 2:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
               
                System.out.println("El Estado actual es: " + listaEmpleados.get(i).estado);
                System.out.println("Desea actualizarlo?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nuevo estado");
                        nuevoEstado = scan.nextBoolean();
                        listaEmpleados.get(i).setEstado(nuevoEstado);
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

    public void ver_personal() {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("ID_EMPLEADO: " + listaEmpleados.get(i).id + " NOMBRES: "
                    + listaEmpleados.get(i).name + " APELLIDOS: " + listaEmpleados.get(i).lastName
                    + " ROL: " + listaEmpleados.get(i).rol + " LOCAL_DE_TRABAJO: " + listaEmpleados.get(i).local
                    + " CAJA_DE_TRABAJO: " + listaEmpleados.get(i).caja + " ESTADO_ACTUAL: " + listaEmpleados.get(i).estado);
        }

    }
}
