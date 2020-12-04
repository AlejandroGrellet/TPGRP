/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import java.util.Objects;

/**
 *
 * @author mbmnu
 */
public class Alumno extends Autor{
//    private int dni=super.getDni();
    private String cx;

    public Alumno(int dni,  String apellidos,String nombres, String clave, String cx) {
        super(dni, apellidos, nombres, clave);
        this.cx = cx;
    }
    
    
    @Override
   public void mostrar()
   {
       super.mostrar();
       System.out.println(cx);
   }
    

    public void asignarCx(String cx) {
        this.cx = cx;
    }   
    public String verCx() {
        return cx;
    }

    @Override
    public int hashCode() {
        return super.hashCode()+Objects.hashCode(this.cx);
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)){
            if(obj instanceof Alumno){
                return Objects.equals(this.cx, ((Alumno)obj).verCx());
            }else{
                return false;
            }
        }
        return true;
    }
}
   

    


