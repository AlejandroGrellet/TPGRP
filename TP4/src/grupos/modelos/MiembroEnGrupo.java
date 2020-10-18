/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.Profesor;
import grupos.modelos.EnumRol.Rol;

/**
 *
 * @author mbmnu
 */
public class MiembroEnGrupo {
    private Autor autor;
    private Rol Rol;
    private Grupo grupo;

    public MiembroEnGrupo(Autor autor,Rol Rol,Grupo grupo) {
        this.autor = autor;
        this.Rol = Rol;
        this.grupo=grupo;

    }
//
//    public MiembroEnGrupo(Rol Rol,Grupo grupo) {
//        this(Rol);
//    }
//public MiembroEnGrupo(Rol Rol,Profesor profesor) {
//        this(Rol);
//        this.profesor=profesor;
//    }
//
//    public void setProfesor(Profesor profesor) {
//        this.profesor = profesor;
//    }
//
//    public void setGrupo(Grupo grupo) {
//        this.grupo = grupo;
//    }



    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol Rol) {
        this.Rol = Rol;
    }
    

    @Override
    public String toString() {
        return  "Autor:" + autor.getApellidos() + "," + autor.getNombres() +  "\n Grupo :" + grupo.getNombre() + "\nRol :" + Rol ;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    
   
}
