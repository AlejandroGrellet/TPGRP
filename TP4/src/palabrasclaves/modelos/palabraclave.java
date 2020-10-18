/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import java.util.Objects;

/**
 *
 * @author mbmnu
 */
public class PalabraClave {
    private String nombre;

    public PalabraClave(String nombre) {
        this.nombre = nombre;
    }
    
    

    public String getNombre() {
        return nombre;
    }

//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void mostrar()
    {
        System.out.println(nombre);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        final PalabraClave other = (PalabraClave) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
    
      

    @Override
    public String toString() {
        return "Palabra Clave:"+nombre;
    }
    
    
}
