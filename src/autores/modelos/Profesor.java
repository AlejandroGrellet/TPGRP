package autores.modelos;

import autores.modelos.Cargo;
import grupos.modelos.EnumRol;
import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;
import java.util.Objects;

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
    
    private Cargo cargo;
    private ArrayList <MiembroEnGrupo> Miembro=new ArrayList();
    
    public void mostrar()
    {
        super.mostrar();
        System.out.println(cargo);
        
    }

   public void asignarCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Profesor(int dni, String apellidos,String nombres, String clave,Cargo cargo ) {
        super(dni, apellidos, nombres, clave);
        this.cargo = cargo;
    }

}
   


    
    

    

