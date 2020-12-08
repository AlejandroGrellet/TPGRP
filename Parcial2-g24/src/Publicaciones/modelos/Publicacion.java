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
import java.util.List;
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
    private List <PalabraClave> palabrasclaves;
    
    
    

//    public Publicacion(String Titulo, String enlace, String resumen, MiembroEnGrupo Mgrupo, Tipo tipo, Idioma idioma, Lugar lugar) {
//        this.Titulo = Titulo;
//        this.enlace = enlace;
//        this.resumen = resumen;
//        this.Mgrupo = Mgrupo;
//        this.tipo = tipo;
//        this.idioma = idioma;
//        this.lugar = lugar;
//    }

    public Publicacion(String Titulo, LocalDate FechaDePublicacion, String enlace, String resumen, MiembroEnGrupo Mgrupo, Tipo tipo, Idioma idioma, Lugar lugar, List<PalabraClave> PalabraClave) {
        this.Titulo = Titulo;
        this.FechaDePublicacion = FechaDePublicacion;
        this.enlace = enlace;
        this.resumen = resumen;
        this.Mgrupo = Mgrupo;
        this.tipo = tipo;
        this.idioma = idioma;
        this.lugar = lugar;
        this.palabrasclaves = PalabraClave;
    }

    
    
    
    
    public void mostrar(){
        System.out.println("Titulo: " +Titulo);
        System.out.println(Mgrupo);
        System.out.println("Fecha de publicacion: : " +FechaDePublicacion);
        System.out.println("Tipo: " +tipo);
        System.out.println("Idioma: " +idioma);
        System.out.println("Lugar: " +lugar);
        System.out.println("Palabras Clave \n --------------------------------------- \n");
        for(PalabraClave PC:palabrasclaves){
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

    public MiembroEnGrupo getMgrupo() {
        return Mgrupo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public List <PalabraClave> getPalabraClave() {
        return palabrasclaves;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setFechaDePublicacion(LocalDate FechaDePublicacion) {
        this.FechaDePublicacion = FechaDePublicacion;
    }

    public String getEnlace() {
        return enlace;
    }

    public String getResumen() {
        return resumen;
    }

    public List<PalabraClave> getPalabrasclaves() {
        return palabrasclaves;
    }

    
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public void setMgrupo(MiembroEnGrupo Mgrupo) {
        this.Mgrupo = Mgrupo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public void setPalabraClave(List<PalabraClave> PalabraClave) {
        this.palabrasclaves = PalabraClave;
    }

    public LocalDate getFechaDePublicacion() {
        return FechaDePublicacion;
    }

    @Override
    public String toString() {
        return "Publicacion:" + "\nTitulo=" + Titulo + "\n FechaDePublicacion=" + FechaDePublicacion + "\n enlace=" + enlace + "\n resumen=" + resumen + "\n Mgrupo=" + Mgrupo + "\n tipo=" + tipo + "\n idioma=" + idioma + "\n lugar=" + lugar + "\n palabrasclaves=" + palabrasclaves ;
    }
    
    
    
    
    
}
