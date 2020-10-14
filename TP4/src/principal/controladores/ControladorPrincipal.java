/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.modelos.Alumnos;
import autores.modelos.Profesores;
import grupos.modelos.grupos;
import idiomas.modelos.Idioma;
import java.util.ArrayList;
import lugares.modelos.lugar;
import palabrasclave.modelos.palabraclave;
import tipos.modelos.tipos;

/**
 *
 * @author mbmnu
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Alumnos> ListaAlumnos = new ArrayList();
        ArrayList<Profesores> ListaProfesores = new ArrayList();
        ArrayList<Idioma> ListaIdiomas = new ArrayList();
        ArrayList<grupos> ListaGrupos = new ArrayList();
        ArrayList<palabraclave> ListaPalClave = new ArrayList();
        ArrayList<tipos> ListaTipos = new ArrayList();
        ArrayList<lugar> ListaLugares = new ArrayList();
        Alumnos AL1=new Alumnos(1, "asd", "fgh", "2"," 3");
        Alumnos AL2=new Alumnos(1, "asd", "fgh", "2"," 3");
        Alumnos AL3=new Alumnos(1, "asd", "fgh", "2"," 3");
        Alumnos AL4=new Alumnos(1, "asd", "fgh", "2"," 3");
        Alumnos AL5=new Alumnos(1, "Rodriguez", "fgh", "2"," 3");
        ListaAlumnos.add(AL1);
        ListaAlumnos.add(AL2);
        ListaAlumnos.add(AL3);
        ListaAlumnos.add(AL4);
        ListaAlumnos.add(AL5);
        for (Alumnos AL : ListaAlumnos) {
            AL.mostrar();
        }
        
    }
    
}
