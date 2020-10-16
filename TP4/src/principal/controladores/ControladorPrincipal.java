/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import Publicaciones.modelos.Publicaciones;
import autores.modelos.Alumno;
import autores.modelos.Profesor;
import autores.modelos.enumeracion;
import autores.vistas.VentanaAMAlumno;
import autores.vistas.VentanaAMProfesor;
import static grupos.modelos.EnumRol.Rol.ADMINISTRADOR;
import static grupos.modelos.EnumRol.Rol.COLABORADOR;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
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
//        ArrayList<Alumno> ListaAlumnos = new ArrayList();
//        ArrayList<Profesor> ListaProfesores = new ArrayList();
//        ArrayList<Idioma> ListaIdiomas = new ArrayList();
//        ArrayList<Grupo> ListaGrupos = new ArrayList();
//        ArrayList<PalabraClave> ListaPalClave = new ArrayList();
//        ArrayList<Tipo> ListaTipos = new ArrayList();
//        ArrayList<Lugar> ListaLugares = new ArrayList();
//        Profesor PRF1 =new Profesor(1, "DDDDD", "FFFFF", "BBBBB", enumeracion.Cargo.ADG);
//        Profesor PRF2 =new Profesor(1, "CCCCC", "GGGGG", "AAAAA", enumeracion.Cargo.ADJUNTO);
//        Grupo G1=new Grupo("Warframe", "Ninjas play free");
//        Grupo G2=new Grupo("LOL", "Para petes");
//        MiembroEnGrupo M1 = new MiembroEnGrupo(PRF1,COLABORADOR, G1);
//        MiembroEnGrupo M2 = new MiembroEnGrupo(PRF2,ADMINISTRADOR,G1);
//        MiembroEnGrupo M3 = new MiembroEnGrupo(PRF2, COLABORADOR, G2);
//        PRF1.AsignarGrupo(M1);
//        PRF1.AsignarGrupo(M2);
//        PRF2.AsignarGrupo(M3);
//        PRF2.AsignarGrupo(M1);
//        G2.AgregarMiembro(M3);
//        Publicaciones P1=new Publicaciones("Juego", "www.google.com", "puto el que lee", M3);
//        P1.mostrar();
//        PRF1.mostrar();
        
        
        
        //SECTOR DE PRUEBA      NO PASAR
        
        
        
        
        
        
        
        
        
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
