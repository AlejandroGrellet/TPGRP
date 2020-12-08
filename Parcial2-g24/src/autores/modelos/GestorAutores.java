/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import Publicaciones.modelos.GestorPublicaciones;
import grupos.modelos.Rol;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import interfaces.IGestorAutores;
import interfaces.IGestorPublicaciones;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mbmnu
 */
public class GestorAutores implements IGestorAutores{
    private static List<Autor>ListaAutores=new ArrayList<>();
    private static List<Profesor>ListaProfesores=new ArrayList<>();
    private static List<Alumno>ListaAlumnos=new ArrayList<>();
    private static int controlador_mod=0;
    public static final String ErrorMsj="ERROR"; //crear errores de clave y demás
     private static final String MENSAJE_CAMPOS_VACIOS="No se pudo crear el elemento, pues se ingresaron campos vacios";
    private static final String MENSAJE_CONTROL_CLAVE_ERROR="Las contraseñas no coinciden";
    private static final String MENSAJE_EXISTENTE="El elemento que se quiso ingresar ya existe";
    private static final String MENSAJE_EXITO="El autor se ingreso correctamente";
    private static final String MODIFICACION_EXITO="El autor se modifico correctamente";
    private static final String MODIFICACION_ERROR="No se pudo modificar, elemento inexistente";
    private static final String MODIFICACION_ERROR_BLANK="El autor no se pudo modificar, se ingresaron datos incorrectos";
   public static final String MENSAJE_BORRADO_CORRECTO = "La publicacion fue borrada con exito";
    public static final String MENSAJE_BORRADO_INCORRECTO = "La publicacion no se pudo borrar porque no existe";
    
   
    private static GestorAutores InstanceChek;
    

    private GestorAutores() {
    }
    

    public static GestorAutores crear(){
        if(InstanceChek==null)
          InstanceChek = new GestorAutores();
        return InstanceChek;   
    }
    
    public void mostrar(){
    for(Autor a: ListaAutores)
            System.out.println(a);
    }
    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        if ((dni>0)&&(nombres != null) && (!nombres.isBlank())&&(apellidos!=null)&& (!apellidos.isBlank())&&(cargo!=null)){
           if((clave==null)||(clave.equals(claveRepetida))){
            Autor profesor1 = new Profesor(dni, apellidos, nombres, clave, cargo);
                if(!ListaAutores.contains(profesor1)){
                    ListaAutores.add(profesor1);
                    ListaProfesores.add((Profesor) profesor1);
                    return profesor1.toString();
                }return ErrorMsj;
                
            } return ErrorMsj;
        }
         return ErrorMsj;
    }
//
    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
    if ((dni>0)&&(nombres != null) && (!nombres.isBlank())&&(apellidos!=null)&& (!apellidos.isBlank())&&(cx!=null)&&(!cx.isBlank())){
           if((clave==null)||(clave.equals(claveRepetida))){
            Autor alumno1 = new Alumno(dni, apellidos, nombres, clave, cx);
                if(!ListaAutores.contains(alumno1)){
                    ListaAutores.add(alumno1);
                    ListaAlumnos.add((Alumno) alumno1);
                    return alumno1.toString();
                }return ErrorMsj;
                
            } return ErrorMsj;
        }
    else return ErrorMsj;
    }
  
//    private boolean ControlClave(String clave,String claveRepetida){
//        if((clave!=null)&&(claveRepetida!=null)){
//            if(clave.equals(claveRepetida))
//                return true;
//            else
//                return false;
//        }
//        return false;
//    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        if((autor!=null)&&(apellidos!=null)&&(!"".equals(apellidos))&&(nombres!=null)&&(!"".equals(nombres))&&(cargo!=null)&&(clave.equals(claveRepetida))){
            if(this.ListaAutores.contains(autor)){
                Profesor profesor = (Profesor) autor;
                autor.asignarApellidos(apellidos);
                autor.asignarNombres(nombres);
                autor.asignarClave(clave);
                profesor.asignarCargo(cargo);
                return MODIFICACION_EXITO;
            }
            else
                return MODIFICACION_ERROR;
        }
        else
            return MODIFICACION_ERROR_BLANK;

    }
            

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
   if((autor!=null)&&(apellidos!=null)&&(!"".equals(apellidos))&&(nombres!=null)&&(!"".equals(nombres))&&(cx!=null)&&(clave.equals(claveRepetida))){
            if(this.ListaAutores.contains(autor)){
                Alumno alumnos = (Alumno) autor;
                autor.asignarApellidos(apellidos);
                autor.asignarNombres(nombres);
                autor.asignarClave(clave);
                alumnos.asignarCx(cx);
                return MODIFICACION_EXITO;
            }
            else
                return MODIFICACION_ERROR;
        }
        else
            return MODIFICACION_ERROR_BLANK;
    }
     @Override
    public String borrarAutor(Autor autor) {
        IGestorPublicaciones gp= GestorPublicaciones.crear();
        if(!gp.hayPublicacionesConEsteAutor(autor))
        {
            ListaAutores.remove(autor);
            
            if(ListaAlumnos.contains(autor))
                ListaAlumnos.remove(autor);
            else if(ListaProfesores.contains(autor))
                ListaProfesores.remove(autor);
            
            return MENSAJE_BORRADO_CORRECTO;
        }
        else
        {
            return MENSAJE_BORRADO_INCORRECTO;
        }

    }
    
    

    public static void BorrarProfesor(Autor autor){
        if(ListaProfesores.contains((Profesor)autor))
            ListaProfesores.remove((Profesor)autor);
        if(ListaAutores.contains(autor))
            ListaAutores.remove(autor);
    }
    
     @Override
    public List<Profesor> buscarProfesores(String apellidos) {
      List<Profesor> profesoresBuscar = new ArrayList<> ();
      for(Profesor profesor: ListaProfesores)
      {
          if(profesor.verApellidos().contains(apellidos))
          {
              profesoresBuscar.add(profesor);
          }
      }
      Comparator<Profesor> cp = (p1, p2) -> p1.toString().compareTo(p2.toString());
      profesoresBuscar.sort(cp);
      return profesoresBuscar;
    }
    
     @Override
    public List<Alumno> buscarAlumnos(String apellidos) {
      List<Alumno> alumnosBuscar = new ArrayList<> ();
      for(Alumno alumno: ListaAlumnos)
      {
          if(alumno.verApellidos().contains(apellidos))
          {
              alumnosBuscar.add(alumno);
          }
      }
      Comparator<Alumno> ca = (a1, a2) -> a1.toString().compareTo(a2.toString());
      alumnosBuscar.sort(ca);
      return alumnosBuscar;
    }
    
    public static void BorrarAlumno(Autor autor){
        if(ListaAlumnos.contains((Alumno)autor))
            ListaAlumnos.remove((Alumno)autor);
        if(ListaAutores.contains(autor))
            ListaAutores.remove(autor);
    }
    
    @Override
    public boolean hayAutoresConEsteGrupo(Grupo grupo)
        {
            for(Autor autor : ListaAutores)
            {
            for(MiembroEnGrupo meg: autor.verListaGrupo())
            {
                if(meg.verGrupo().equals(grupo))
                    return true;
            }
            }
        return false;
    }
        
            
    

    @Override
    public boolean existeEsteAutor(Autor autor) {
    if (ListaAutores.contains(autor))
        return true;
    return false;
    }

    @Override
    public List<Autor> verAutores() {
    Comparator<Autor> ca = (a1, a2) -> a1.verNombres().compareTo(a2.verNombres());
        this.ListaAutores.sort(ca);
        return this.ListaAutores;
    }

    @Override
    public List<Profesor> verProfesores() {
    Comparator<Profesor> cp = (p1, p2) -> p1.verNombres().compareTo(p2.verNombres());
        this.ListaProfesores.sort(cp);
        return this.ListaProfesores;    
    }

    @Override
    public List<Alumno> verAlumnos() {
        Comparator<Alumno> cal = (al1, al2) -> al1.verNombres().compareTo(al2.verNombres());
        this.ListaAlumnos.sort(cal);
    return ListaAlumnos;
    }

    @Override
    public Autor verAutor(int dni) {
    return verAutor(dni);
    }

    public static int getControlador_modificacion() {
        return controlador_mod;
    }

    @Override
    public String agregarGrupos(Autor autor, List<MiembroEnGrupo> grupos) {
       for(MiembroEnGrupo grupo:grupos)
//           if(!autor.getListaGrupo().contains(grupo))
           autor.agregarGrupo(grupo.verGrupo(), grupo.verRol());
       return null;
    }

    @Override
    public String quitarGrupos(Autor autor, List<MiembroEnGrupo> grupos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}