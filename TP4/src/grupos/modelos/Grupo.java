/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author mbmnu
 */
public class Grupo {
    private String nombre;
    private String descripcion;
    private ArrayList <MiembroEnGrupo> Miembro = new ArrayList<>();
    
    
    public void mostrar()
    {
            System.out.println(nombre);
            System.out.println(descripcion);
        for(MiembroEnGrupo m:Miembro)
            System.out.println( m.getGrupo()+ " " +m.getRol());
            
    }     

    public Grupo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

//    public void AgregarMiembro(MiembroEnGrupo m){
//    this.Miebro.add(m);
//    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.nombre);
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

   
    public void agregarMiembro(MiembroEnGrupo miembro){
        this.Miembro.add(miembro);
        miembro.setGrupo(this);
    }

    @Override
    public String toString() {
        return "Grupo{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    
}
