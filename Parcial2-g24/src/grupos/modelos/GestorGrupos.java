/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mbmnu
 */
public class GestorGrupos implements IGestorGrupos{
    public ArrayList<MiembroEnGrupo> Miembros = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();
    private static final String MENSAJE_BORRADO_CORRECTO = "La publicacion fue borrada con exito";
    private static final String MENSAJE_BORRADO_INCORRECTO = "La publicacion no se pudo borrar porque no existe";
    
     private static GestorGrupos instanceCheck;

    public static GestorGrupos crear(){
        if(instanceCheck==null)
            instanceCheck = new GestorGrupos();
        return instanceCheck;
    }
    

    @Override
    public String nuevoGrupo(String nombre, String descripcion) {
        if(nombre!=null && nombre!="")
        {
            Grupo grupo = new Grupo(nombre, descripcion);
            if(!this.grupos.contains(grupo))
            {
                this.grupos.add(grupo);
                return null;
            }
            else
            {
               return null;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public String modificarGrupo(Grupo grupo, String descripcion) {
    if(grupo!=null && descripcion!=null && descripcion!="")
        {
            if(this.grupos.contains(grupo))
            {
                grupo.asignarDescripcion(descripcion);
                return null;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }    }

   

    @Override
    public List<Grupo> verGrupos() {
    Comparator<Grupo> cg = (g1, g2) -> g1.verNombre().compareTo(g2.verNombre());
        this.grupos.sort(cg);
        return this.grupos;    
    }

    @Override
    public boolean existeEsteGrupo(Grupo grupo) {
    return grupos.contains(grupo);
    }
    
     @Override
    public List<Grupo> buscarGrupos(String nombre) {
      List<Grupo> grupoBuscado = new ArrayList<> ();
      for(Grupo grupo: grupos)
      {
          if(grupo.verNombre().contains(nombre))
          {
              grupoBuscado.add(grupo);
          }
      }
      Comparator<Grupo> cg = (g1, g2) -> g1.verNombre().compareTo(g2.verNombre());
      grupoBuscado.sort(cg);
      return grupoBuscado;
    }
    
    @Override
    public String borrarGrupo(Grupo grupo) {
        IGestorAutores ga = GestorAutores.crear();
        if(!ga.hayAutoresConEsteGrupo(grupo))
        {
            grupos.remove(grupo);
            return MENSAJE_BORRADO_CORRECTO;
        }
        else
        {
            return MENSAJE_BORRADO_INCORRECTO;
        }
    }

    @Override
    public String agregarMiembros(Grupo grupo, List<MiembroEnGrupo> miembros) {
        for( MiembroEnGrupo MEG: miembros)
            if(!Miembros.contains(MEG)){
                MEG.asignarGrupo(grupo);
                Miembros.add(MEG);
            }return null;
    }

    

 
    @Override
    public String quitarMiembros(Grupo grupo, List<MiembroEnGrupo> miembros) {
        for( MiembroEnGrupo MEG: miembros)
            if(Miembros.contains(MEG)){
//                MEG.(grupo);
                Miembros.remove(MEG);
            }return null;
    }

    @Override
    public Grupo verGrupo(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizarGrupos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<MiembroEnGrupo> verMiembros() {
        return Miembros;
    }
    
    
    
}
