/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import interfaces.IGestorAutores;
import java.util.ArrayList;

/**
 *
 * @author mbmnu
 */
public class GestorAutores implements IGestorAutores{
    private static ArrayList<Autor>ListaAutores=new ArrayList<>();
    private static ArrayList<Profesor>ListaProfesores=new ArrayList<>();
    private static ArrayList<Alumno>ListaAlumnos=new ArrayList<>();
    private static int controlador_mod=0;
    public static final String ErrorMsj="ERROR"; //crear errores de clave y demás
     private static final String MENSAJE_CAMPOS_VACIOS="No se pudo crear el elemento, pues se ingresaron campos vacios";
    private static final String MENSAJE_CONTROL_CLAVE_ERROR="Las contraseñas no coinciden";
    private static final String MENSAJE_EXISTENTE="El elemento que se quiso ingresar ya existe";
    private static final String MENSAJE_EXITO="El autor se ingreso correctamente";
    private static final String MODIFICACION_EXITO="El autor se modifico correctamente";
    private static final String MODIFICACION_ERROR="No se pudo modificar, elemento inexistente";
    private static final String MODIFICACION_ERROR_BLANK="El autor no se pudo modificar, se ingresaron datos incorrectos";

   
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
                }
                return profesor1.toString();
            }else return ErrorMsj;
        }
        else return ErrorMsj;
    }
//
    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
         if((dni!=0)&&(apellidos!=null)&&(!"".equals(apellidos))&&(nombres!=null)&&(!"".equals(nombres))&&(cx!=null)&&(!"".equals(cx))&&(clave.equals(claveRepetida))){
            Autor t = new Alumno(dni, apellidos, nombres, clave, cx);
            if(!this.ListaAutores.contains(t)){
                this.ListaAutores.add(t);
                this.ListaAlumnos.add((Alumno) t);
                return MENSAJE_EXITO;
            }
            else
                return MENSAJE_EXISTENTE;
        }
        else
            return MODIFICACION_ERROR_BLANK; 
    }
    private boolean ControlClave(String clave,String claveRepetida){
        if((clave!=null)&&(claveRepetida!=null)){
            if(clave.equals(claveRepetida))
                return true;
            else
                return false;
        }
        return false;
    }

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

    public static void BorrarProfesor(Autor autor){
        if(ListaProfesores.contains((Profesor)autor))
            ListaProfesores.remove((Profesor)autor);
        if(ListaAutores.contains(autor))
            ListaAutores.remove(autor);
    }
    
    public static void BorrarAlumno(Autor autor){
        if(ListaAlumnos.contains((Alumno)autor))
            ListaAlumnos.remove((Alumno)autor);
        if(ListaAutores.contains(autor))
            ListaAutores.remove(autor);
    }
    

    @Override
    public boolean existeEsteAutor(Autor autor) {
    return false;
    }

    @Override
    public ArrayList<Autor> verAutores() {
    return ListaAutores;
    }

    @Override
    public ArrayList<Profesor> verProfesores() {
    return ListaProfesores;
    }

    @Override
    public ArrayList<Alumno> verAlumnos() {
    return ListaAlumnos;
    }

    @Override
    public Autor verAutor(int dni) {
    return verAutor(dni);
    }

    public static int getControlador_modificacion() {
        return controlador_mod;
    }
    
}