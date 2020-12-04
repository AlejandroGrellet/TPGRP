/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import Publicaciones.modelos.GestorPublicaciones;
import Publicaciones.modelos.Publicacion;
import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.Profesor;
import autores.modelos.Cargo;
import autores.vistas.VentanaAMAlumno;
import autores.vistas.VentanaAMProfesor;
import grupos.modelos.EnumRol;
import static grupos.modelos.EnumRol.ADMINISTRADOR;
import static grupos.modelos.EnumRol.COLABORADOR;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.vistas.VentanaAMGrupo;
import idiomas.modelos.Idioma;
import idiomas.vistas.VentanaAIdioma;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
        GestorPublicaciones GP1=GestorPublicaciones.crear();
        System.out.println(GP1.nuevaPublicacion("", null, LocalDate.now(), null, null, null, null, null, null));
   
           
        
    //     //<editor-fold defaultstate="collapsed" desc="Intefaz gráfica"> 
//         VentanaAMGrupo ventanaGrupo = new VentanaAMGrupo(null); //se instancia la ventana
///*
////        ventanaGrupo.setLocationRelativeTo(null); //se centra la ventana
////        ventanaGrupo.setVisible(true); //se hace visible la ventana
//        
////        VentanaAMAlumno ventanaAlumno = new VentanaAMAlumno(null); //se instancia la ventana
////        ventanaAlumno.setLocationRelativeTo(null); //se centra la ventana
////        ventanaAlumno.setVisible(true); //se hace visible la ventana
//*/        
//        VentanaAMProfesor ventanaProfesor = new VentanaAMProfesor(null); //se instancia la ventana
//        ventanaProfesor.setLocationRelativeTo(null); //se centra la ventana
//        ventanaProfesor.setVisible(true); //se hace visible la ventana        
///*        
////        VentanaAIdioma ventanaIdioma = new VentanaAIdioma(null); //se instancia la ventana
////        ventanaIdioma.setLocationRelativeTo(null); //se centra la ventana
////        ventanaIdioma.setVisible(true); //se hace visible la ventana                
//        
////        VentanaALugar ventanaLugar = new VentanaALugar(null); //se instancia la ventana
////        ventanaLugar.setLocationRelativeTo(null); //se centra la ventana
////        ventanaLugar.setVisible(true); //se hace visible la ventana                        
//        
////        VentanaAPalabraClave ventanaPalabraClave = new VentanaAPalabraClave(null); //se instancia la ventana
////        ventanaPalabraClave.setLocationRelativeTo(null); //se centra la ventana
////        ventanaPalabraClave.setVisible(true); //se hace visible la ventana                                
//        
////        VentanaATipo ventanaTipo = new VentanaATipo(null); //se instancia la ventana
////        ventanaTipo.setLocationRelativeTo(null); //se centra la ventana
////        ventanaTipo.setVisible(true); //se hace visible la ventana   
//*/
//
//     //</editor-fold>
    
    
    }
}



 
        
        
        
        
        
        
//        VentanaAMGrupo f = new VentanaAMGrupo(null);
//        f.setVisible (true);
//        
//        VentanaAMAlumno f1 = new VentanaAMAlumno(null);
//        f1.setVisible (true);
//        
//        VentanaAMProfesor f2 = new VentanaAMProfesor(null);
//        f2.setVisible (true);
//        
//        VentanaATipo f3 = new VentanaATipo(null);
//        f3.setVisible (true);
//        
//        VentanaALugar f4 = new VentanaALugar (null);
//        f4.setVisible (true);
//        
//        VentanaAIdioma f5 = new VentanaAIdioma (null);
//        f5.setVisible(true);
//        
//        VentanaAPalabraClave f6 = new VentanaAPalabraClave(null);
//        f6.setVisible(true);
//        
        
//    }
    
//}
