/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.modelos;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import interfaces.IGestorPublicaciones;
import java.time.LocalDate;
import java.util.ArrayList;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 *
 * @author mbmnu
 */
public class GestorPublicaciones implements IGestorPublicaciones{
    ArrayList<Publicacion> ListaPublicaciones=new ArrayList<>();
    private static GestorPublicaciones InstanceChek;
    private Publicacion publicación;
    private static final String MENSAJE_EXISTENTE="El elemento que se quiso ingresar ya existe";
         private static final String MENSAJE_CAMPOS_VACIOS="No se pudo crear el elemento, pues se ingresaron campos vacios";

    
    public static GestorPublicaciones crear(){
        if(InstanceChek==null)
          InstanceChek = new GestorPublicaciones();
        return InstanceChek;
    }

    private GestorPublicaciones() {
    }
    

    @Override
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
    if((!titulo.isBlank())&& (titulo!=null) && (miembroEnGrupo!=null) && (fechaPublicacion != null) && (tipo!=null)&&(idioma!= null)&&(lugar!=null)){
       Publicacion publicacion = new Publicacion(titulo, fechaPublicacion, enlace, resumen, miembroEnGrupo, tipo, idioma, lugar, palabrasClaves);
                if(!ListaPublicaciones.contains(publicacion)){
                    ListaPublicaciones.add(publicacion);
                  return publicacion.toString();
                }return MENSAJE_EXISTENTE;
    }
    return MENSAJE_CAMPOS_VACIOS;
    }

    @Override
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
    return null;
    }

    @Override
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave) {
        for (Publicacion p:ListaPublicaciones)
            if(p.getPalabraClave().equals(palabraClave))
                return true;
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteLugar(Lugar lugar) {
        for (Publicacion p:ListaPublicaciones)
            if(p.getLugar().equals(lugar))
                return true;
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma) {
        for (Publicacion p:ListaPublicaciones)
            if(p.getIdioma().equals(idioma))
                return true;
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteTipo(Tipo tipo) {
        for (Publicacion p:ListaPublicaciones)
            if(p.getTipo().equals(tipo))
                return true;
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteAutor(Autor autor) {
        for (Publicacion p:ListaPublicaciones)
            if(p.getMgrupo().verAutor().equals(autor))
                return true;
        return false;
    }

    @Override
    public boolean existeEstaPublicacion(Publicacion publicacion) {
        if(ListaPublicaciones.contains(publicacion))
            return true;
        return false;
    }

    @Override
    public ArrayList<Publicacion> verPublicaciones() {
        return ListaPublicaciones;
    }

    @Override
    public Publicacion verPublicacion(String titulo) {
        return publicación;
    }
    
}
