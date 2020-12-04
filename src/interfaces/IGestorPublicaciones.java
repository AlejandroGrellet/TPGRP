/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Publicaciones.modelos.Publicacion;
import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 *
 * @author mbmnu
 */
public interface IGestorPublicaciones {
    
      public static final String MENSAJE_EXISTENTE="El elemento que se quiso ingresar ya existe";
      public static final String MENSAJE_CAMPOS_VACIOS="No se pudo crear el elemento, pues se ingresaron campos vacios";
      public static final String MENSAJE_BORRADO_CORRECTO = "La publicacion fue borrada con exito";
      public static final String MENSAJE_BORRADO_INCORRECTO = "La publicacion no se pudo borrar porque no existe";
      public static final String MENSAJE_MODIFICADA ="La publicacion fue modificada con exito";
      public static final String MENSAJE_NO_ENCONTRADA ="La publicacion ni fue encontrada";
      public static final String MENSAJE_ERROR = "No se pudo guardar la publicacion, ingrese bien los datos";
    
    
//    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo,LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar,ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen);
//    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar,ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen);    
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave);
    public boolean hayPublicacionesConEsteLugar(Lugar lugar);
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma);
    public boolean hayPublicacionesConEsteTipo(Tipo tipo);
    public boolean hayPublicacionesConEsteAutor(Autor autor);
    public boolean existeEstaPublicacion(Publicacion publicacion);
//    public ArrayList<Publicacion> verPublicaciones();
    public Publicacion verPublicacion(String titulo);
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo,LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar,List<PalabraClave> palabrasClaves, String enlace, String resumen);
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar,List<PalabraClave> palabrasClaves, String enlace, String resumen);
    public String borrarPublicacion(Publicacion publicacion);
    public List<Publicacion> buscarPublicaciones(String titulo);
    public List<Publicacion> verPublicaciones();
    
}
