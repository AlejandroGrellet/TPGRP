/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.modelos.Alumnos;

/**
 *
 * @author mbmnu
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        Alumnos UnAlumno = new Alumnos(1,"Pérez","Ana","1234","5555");
        UnAlumno.mostrar();
    }
    
}
