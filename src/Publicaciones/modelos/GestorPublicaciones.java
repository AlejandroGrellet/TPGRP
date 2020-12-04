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
import java.util.Comparator;
import java.util.List;
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
    private Publicacion publicacion;
    private static final String MENSAJE_EXISTENTE="El elemento que se quiso ingresar ya existe";
    private static final String MENSAJE_CAMPOS_VACIOS="No se pudo crear el elemento, pues se ingresaron campos vacios";
    public static final String MENSAJE_BORRADO_CORRECTO = "La publicacion fue borrada con exito";
    public static final String MENSAJE_BORRADO_INCORRECTO = "La publicacion no se pudo borrar porque no existe";
    public static final String MENSAJE_MODIFICADA ="La publicacion fue modificada con exito";
    public static final String MENSAJE_NO_ENCONTRADA ="La publicacion ni fue encontrada";
    public static final String MENSAJE_ERROR = "No se pudo guardar la publicacion, ingrese bien los datos";

    
    public static GestorPublicaciones crear(){
        if(InstanceChek==null)
          InstanceChek = new GestorPublicaciones();
        return InstanceChek;
    }

    private GestorPublicaciones() {
    }
    

    @Override
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, List<PalabraClave> palabrasClaves, String enlace, String resumen) {
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
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, List<PalabraClave> palabrasClaves, String enlace, String resumen) {
        
        if(publicacion!= null && miembroEnGrupo!=null && fechaPublicacion!= null && tipo!=null && idioma!=null && lugar!=null && palabrasClaves!=null && palabrasClaves.size()!=0 && enlace!= null && enlace!="" && resumen!=null && resumen!="")
        {
            if(this.ListaPublicaciones.contains(publicacion))
            {
                publicacion.setEnlace(enlace);
                publicacion.setFechaDePublicacion(fechaPublicacion);
                publicacion.setIdioma(idioma);
                publicacion.setLugar(lugar);
                publicacion.setMgrupo(miembroEnGrupo);
                publicacion.setPalabraClave(palabrasClaves);
                publicacion.setResumen(resumen);
                publicacion.setTipo(tipo);
                return MENSAJE_MODIFICADA;
            }else
            {
                return MENSAJE_NO_ENCONTRADA;
            }
        }else
        {
            return MENSAJE_ERROR;
        }
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
    public String borrarPublicacion(Publicacion publicacion) {
        
       if(ListaPublicaciones.contains(publicacion))
       {
           ListaPublicaciones.remove(publicacion);
           return MENSAJE_BORRADO_CORRECTO;
       }
       else
       {
           return MENSAJE_BORRADO_INCORRECTO;
       }
    }
    
    
    @Override
    public List<Publicacion> buscarPublicaciones(String titulo) {
        
        List<Publicacion> publicacionesBuscar = new ArrayList<> ();
      for(Publicacion publicacion: ListaPublicaciones)
      {
          if(publicacion.getTitulo().contains(titulo))
          {
              publicacionesBuscar.add(publicacion);
          }
      }
      Comparator<Publicacion> cp = (p1, p2) -> p1.getTitulo().compareTo(p2.getTitulo());
      publicacionesBuscar.sort(cp);
      return publicacionesBuscar;
    }
    

    @Override
    public Publicacion verPublicacion(String title) {
  
        for(Publicacion publicacion: ListaPublicaciones)
        {
            if(publicacion.getTitulo()==title)
            {
                return publicacion;
            }
        }
        return null;
        
    }
    
}
