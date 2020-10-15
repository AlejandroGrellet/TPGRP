/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.modelos.Alumno;
import autores.modelos.Profesor;
import autores.vistas.VentanaAMAlumno;
import autores.vistas.VentanaAMProfesor;
import grupos.modelos.Grupo;
import grupos.vistas.VentanaAMGrupo;
import idiomas.modelos.Idioma;
import idiomas.vistas.VentanaAIdioma;
import java.util.ArrayList;
import lugares.modelos.Lugar;
import lugares.vistas.VentanaALugar;
import palabrasclaves.modelos.PalabraClave;
import palabrasclaves.vistas.VentanaAPalabraClave;
import tipos.modelos.Tipo;
import tipos.vistas.VentanaATipo;

/**
 *
 * @author mbmnu
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Alumno> ListaAlumnos = new ArrayList();
        ArrayList<Profesor> ListaProfesores = new ArrayList();
        ArrayList<Idioma> ListaIdiomas = new ArrayList();
        ArrayList<Grupo> ListaGrupos = new ArrayList();
        ArrayList<PalabraClave> ListaPalClave = new ArrayList();
        ArrayList<Tipo> ListaTipos = new ArrayList();
        ArrayList<Lugar> ListaLugares = new ArrayList();
        Alumno AL1=new Alumno(1, "asd", "fgh", "2","3");
        Alumno AL2=new Alumno(1, "asd", "fgh", "2","3");
        Alumno AL3=new Alumno(1, "asd", "fgh", "2","3");
        Alumno AL4=new Alumno(1, "asd", "fgh", "2","3");
        Alumno AL5=new Alumno(1, "Rodriguez", "fgh", "2","3");
        ListaAlumnos.add(AL1);
        ListaAlumnos.add(AL2);
        ListaAlumnos.add(AL3);
        ListaAlumnos.add(AL4);
        ListaAlumnos.add(AL5);
        for (Alumno AL : ListaAlumnos) {
            AL.mostrar();
        }
        
     
        VentanaAMGrupo f = new VentanaAMGrupo(null);
        f.setVisible (true);
        
        VentanaAMAlumno f1 = new VentanaAMAlumno(null);
        f1.setVisible (true);
        
        VentanaAMProfesor f2 = new VentanaAMProfesor(null);
        f2.setVisible (true);
        
        VentanaATipo f3 = new VentanaATipo(null);
        f3.setVisible (true);
        
        VentanaALugar f4 = new VentanaALugar (null);
        f4.setVisible (true);
        
        VentanaAIdioma f5 = new VentanaAIdioma (null);
        f5.setVisible(true);
        
        VentanaAPalabraClave f6 = new VentanaAPalabraClave(null);
        f6.setVisible(true);
        
        
    }
    
}
