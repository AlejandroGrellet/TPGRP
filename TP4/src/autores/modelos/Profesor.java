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
public class Profesor extends Autor{
    
    private final Cargo cargo;
    private ArrayList <MiembroEnGrupo> Miembro=new ArrayList();
    
    public void mostrar()
    {
        super.mostrar();
        System.out.println(cargo);
        
    }

   

    public Profesor(int dni, String apellidos,String nombres, String clave,Cargo cargo ) {
        super(dni, apellidos, nombres, clave);
        this.cargo = cargo;
    }

        
    }
   

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 79 * hash + this.DNI;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Profesor other = (Profesor) obj;
//        if (this.DNI != other.DNI) {
//            return false;
//        }
//        return true;
//    }

    
    

    

