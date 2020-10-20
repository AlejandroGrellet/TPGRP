/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.modelos;

import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 *
 * @author mbmnu
 */
public class Publicacion {
    private String Titulo;
    private LocalDate FechaDePublicacion; 
    private String enlace;
    private String resumen;
    private MiembroEnGrupo Mgrupo;
    private Tipo tipo;
    private Idioma idioma;
    private Lugar lugar;
    private ArrayList <PalabraClave> PalabraClave= new ArrayList();
    
    
    

//    public Publicacion(String Titulo, String enlace, String resumen, MiembroEnGrupo Mgrupo, Tipo tipo, Idioma idioma, Lugar lugar) {
//        this.Titulo = Titulo;
//        this.enlace = enlace;
//        this.resumen = resumen;
//        this.Mgrupo = Mgrupo;
//        this.tipo = tipo;
//        this.idioma = idioma;
//        this.lugar = lugar;
//    }

    public Publicacion(String Titulo, LocalDate FechaDePublicacion, String enlace, String resumen, MiembroEnGrupo Mgrupo, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> PalabraClave) {
        this.Titulo = Titulo;
        this.FechaDePublicacion = FechaDePublicacion;
        this.enlace = enlace;
        this.resumen = resumen;
        this.Mgrupo = Mgrupo;
        this.tipo = tipo;
        this.idioma = idioma;
        this.lugar = lugar;
        this.PalabraClave = PalabraClave;
    }

    
    
    
    
    public void mostrar(){
        System.out.println("Titulo: " +Titulo);
        System.out.println(Mgrupo);
        System.out.println("Fecha de publicacion: : " +FechaDePublicacion);
        System.out.println("Tipo: " +tipo);
        System.out.println("Idioma: " +idioma);
        System.out.println("Lugar: " +lugar);
        System.out.println("Palabras Clave \n --------------------------------------- \n");
        for(PalabraClave PC:PalabraClave){
//        System.out.println("Palabras Claves: " +PalabraClave);
        PC.mostrar();
        }
        System.out.println("Enlace: " +enlace);
        System.out.println("Resumen: " +resumen);
        System.out.println("\n --------------------------------------- \n");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.Titulo);
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
        final Publicacion other = (Publicacion) obj;
        if (!Objects.equals(this.Titulo, other.Titulo)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
