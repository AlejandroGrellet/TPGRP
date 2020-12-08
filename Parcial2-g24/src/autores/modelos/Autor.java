/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.Rol;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public abstract class Autor {
    
   private int dni;
   private String apellidos;
   private String nombres;
   private String clave;
   private Grupo grupo;
   private Rol rol;
   private ArrayList <MiembroEnGrupo> listaGrupo = new ArrayList<>();


    public Autor(int dni, String apellidos, String nombres, String clave) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
    }

    public ArrayList<MiembroEnGrupo> getListaGrupo() {
        return listaGrupo;
    }
   
 

    public int verDni() {
        return dni;
    }

    public void asignarDni(int dni) {
        this.dni = dni;
    }

    public String verApellidos() {
        return apellidos;
    }

    public void asignarApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String verNombres() {
        return nombres;
    }

    public void asignarNombres(String nombres) {
        this.nombres = nombres;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }

    public Rol verRol() {
        return rol;
    }
    
    public ArrayList <MiembroEnGrupo> verListaGrupo() {
        return listaGrupo;
    }
    
    public void mostrar()
    {
        System.out.println("["+dni+"]");
        System.out.println(apellidos+",");
        System.out.println(nombres);
        for(MiembroEnGrupo g: listaGrupo){
            System.out.println(g);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.dni;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
       
    }

    @Override
    public String toString() {
        return  apellidos +" " + nombres ;
    }
    
    public void agregarGrupo(Grupo grupo,Rol rol){
          MiembroEnGrupo miembro1=new MiembroEnGrupo(this, rol, grupo);
          int c=0;
        for(MiembroEnGrupo lg:listaGrupo){
          if(lg.verGrupo().equals(miembro1.verGrupo()))
            c++;
        }
        if(c==0){
        this.listaGrupo.add(miembro1);
        miembro1.verGrupo().agregarMiembro(this, rol);
    }   
    }
    public void quitarGrupo(Grupo grupo){
        MiembroEnGrupo miembro2=new MiembroEnGrupo(this, rol, grupo);
         if(listaGrupo.contains(miembro2)){
             listaGrupo.remove(miembro2);
             miembro2.verGrupo().quitarMiembro(this);
         }
    }


    public boolean esSuperAdministrador()
        {
        for(MiembroEnGrupo mg : listaGrupo)
        {
            if(mg.verGrupo().esSuperAdministradores())
                return true;
        }
        return false;
        }
}


    
 
//            
//        
    

