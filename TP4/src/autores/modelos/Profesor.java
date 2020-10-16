package autores.modelos;

import autores.modelos.enumeracion.Cargo;
import grupos.modelos.EnumRol;
import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mbmnu
 */
public class Profesor {
    private int DNI;
    private String apellidos;
    private String nombres;
    private String clave;
    private final Cargo cargo;
    private ArrayList <MiembroEnGrupo> Miembro=new ArrayList();
    
    public void mostrar()
    {
        System.out.println(apellidos);
        System.out.println(nombres);
        System.out.println(DNI);
        System.out.println(clave);
        System.out.println(cargo);
        
    }

    public Profesor(int DNI, String apellidos, String nombres, String clave, Cargo cargo) {
        this.DNI = DNI;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
        this.cargo = cargo;
        
    }
    public void AsignarGrupo(MiembroEnGrupo e){
        this.Miembro.add(e);
        
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
//
//  public Cargo getCargo() {
//        return cargo;
//  }
//
//    public void setCargo(Cargo cargo) {
//        this.cargo = cargo;
//  }


    
}
