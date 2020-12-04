/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

import interfaces.IGestorLugares;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mbmnu
 */
public class GestorLugares implements IGestorLugares{
    ArrayList<Lugar> ListaLugares=new ArrayList<>();
    private static GestorLugares InstanceChek;
    private Lugar lugar;
    private boolean marcador;
    private final String MSJ_REPETIDO="Elemento repetido";
    private final String EXITO="Elemento guardado";
    private final String EXITO_BORRAR="Elemento borrado";
    private final String ERROR_ARCH="Error al crear el archivo";
    private final String ERROR_BORRAR="Error al borrar el elemento";
    private final String NOMBRE_ARCHIVO="ArchivoLugares.txt";



    
    public static GestorLugares crear(){
        if(InstanceChek==null)
          InstanceChek = new GestorLugares();
        return InstanceChek;
    }
    
     private GestorLugares() {
         this.leerArchivo();
    }
    
     @Override
    public String nuevoLugar(String nombre) {
        marcador =true;
        this.leerArchivo();
        if ((nombre != null) && (!nombre.isBlank())){ 
            this.lugar = new Lugar(nombre);
        
            if(!this.ListaLugares.contains(lugar)) {
                ListaLugares.add(lugar);
                this.escribirArchivho();
                return EXITO;
            }return MSJ_REPETIDO;
        } return null;
        
    }
    @Override
    public List<Lugar> verLugares(){
        Comparator<Lugar> cl = (l1, l2) -> l1.getNombre().compareTo(l2.getNombre());
        this.ListaLugares.sort(cl);
        return this.ListaLugares;
    }

    public void asignarListaLugares(ArrayList<Lugar> ListaLugares) {
        this.ListaLugares = ListaLugares;
    }

    @Override
    public Lugar verLugar(String nombre) {
        return lugar;
    }

    @Override
    public String borrarLugar(Lugar lugar) {
        this.leerArchivo();
        marcador=false;
        if (ListaLugares.contains(lugar)){
            ListaLugares.remove(lugar);
        this.escribirArchivho();
        return EXITO_BORRAR;
        }
        return ERROR_BORRAR;
    }

    @Override
    public List<Lugar> buscarLugares(String nombre) {
        List<Lugar> lugaresBuscar = new ArrayList<> ();
            for(Lugar lugar: ListaLugares)
            {
                if(lugar.getNombre().contains(nombre))
            {
              lugaresBuscar.add(lugar);
            }
      }
      Comparator<Lugar> cl = (l1, l2) -> l1.getNombre().compareTo(l2.getNombre());
      lugaresBuscar.sort(cl);
      return lugaresBuscar;     }

    @Override
    public boolean existeEsteLugar(Lugar lugar) {
    if (ListaLugares.contains(lugar))
            return true;
        return false;
    }
    private File obtenerArchivo(){
         File file = new File(NOMBRE_ARCHIVO);
        try {
            if (!file.exists())
                file.createNewFile();
            return file;
        }
        catch(IOException e) {
            return null;
            
        } 
    }
        private String escribirArchivho(){
            File file = this.obtenerArchivo();
            if (file != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {     
                for(Lugar l : ListaLugares) {
                    String cadena = l.getNombre();
                    bw.write(cadena); 
                    bw.newLine();
                }      
                return EXITO;
            } 
            catch (IOException ioe) {
                return MSJ_REPETIDO;            
            }
        }
        else
            return ERROR_ARCH;   
        }
        private String leerArchivo(){
            File file = this.obtenerArchivo();
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String nombre;
                while((nombre = br.readLine()) != null) {
                    Lugar l = new Lugar(nombre);
                    if(!ListaLugares.contains(l))
                    ListaLugares.add(l);
                }
                return null;
            }
            catch(NullPointerException | IOException ioe) {
                
            }            
        }return null;
        }
}
        
        
    


