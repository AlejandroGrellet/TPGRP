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
public class MiembroEnGrupo {
//    private ArrayList<Autor> autorList=new ArrayList<>();
    private Autor autor;
//    private ArrayList<Rol> rolList=new ArrayList<>();
    private Rol Rol;
    private Grupo grupo;

    public MiembroEnGrupo(Autor autor,Rol Rol,Grupo grupo) {
        this.autor = autor;
        this.Rol = Rol;
        this.grupo=grupo;
    }
    
    public Grupo verGrupo() {
        return grupo;
    }

    public void asignarGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Rol verRol() {
        return Rol;
    }

    public void asignarRol(Rol Rol) {
        this.Rol = Rol;
    }
    
     public Autor verAutor() {
        return autor;
    }

    public void asignarAutor(Autor autor) {
        this.autor = autor;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.autor);
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
        final MiembroEnGrupo other = (MiembroEnGrupo) obj;
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return  "Autor:" + this.autor.verApellidos() + "," + this.autor.verNombres() +  "\n Grupo :" + this.grupo.verNombre() + "\nRol :" + this.Rol ;
    }

//    public void agregarM(Autor autor, Rol rol) {
//            autorList.add(autor);
//            rolList.add(rol);
//        }
    }

   

