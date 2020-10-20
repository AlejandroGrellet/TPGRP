/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import grupos.modelos.EnumRol.Rol;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author mbmnu
 */
public class Grupo {
    private String nombre;
    private String descripcion;
    private ArrayList<MiembroEnGrupo> listaAutores=new ArrayList<>() ;
    private Autor autor;
    private Rol rol;
   
    public void mostrar()
    {
//            System.out.println(nombre);
//            System.out.println(descripcion);
            for (MiembroEnGrupo m:listaAutores)
                System.out.println(m);
            
    }     

    public Grupo(String nombre, String descripcion) {
        
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
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
    
     public ArrayList<MiembroEnGrupo> verListaAutores() {
        return listaAutores;
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
    
    public void agregarMiembro(Autor autor, Rol rol){
        MiembroEnGrupo miembro1=new MiembroEnGrupo(autor, rol, this);
    if(!listaAutores.contains(miembro1)){
        listaAutores.add(miembro1);
        autor.agregarGrupo(this, rol);
        
        }
    }
    public void quitarMiembro(Autor autor){
        
        MiembroEnGrupo miembro2=new MiembroEnGrupo(autor, rol, this);
            if(listaAutores.contains(miembro2))
            {
//                miembro2.getAutor().quitarMiembro(miembro2.getAutor());
                listaAutores.remove(miembro2);
                
            }
        
    }
    
    
    @Override
    public String toString() {
        return "Grupo{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

   
}