/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.modelos;

import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import java.util.ArrayList;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 *
 * @author mbmnu
 */
public class Publicaciones {
    private String Titulo;
//    private LocalDateTime FechaDePublicacion; 
    private String enlace;
    private String resumen;
    private MiembroEnGrupo Mgrupo;
    private Tipo tipo;
    private Idioma idioma;
    private Lugar lugar;
    private ArrayList <PalabraClave> PalabraClave;

    public Publicaciones(String Titulo, String enlace, String resumen, MiembroEnGrupo Mgrupo, Tipo tipo, Idioma idioma, Lugar lugar) {
        this.Titulo = Titulo;
        this.enlace = enlace;
        this.resumen = resumen;
        this.Mgrupo = Mgrupo;
        this.tipo = tipo;
        this.idioma = idioma;
        this.lugar = lugar;
    }

    
    
    
    
    public void mostrar(){
        System.out.println(Titulo);
        System.out.println(Mgrupo);
        System.out.println(enlace);
        System.out.println(resumen);
    
    }
    
    
}
