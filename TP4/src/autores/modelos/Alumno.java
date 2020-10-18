/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

/**
 *
 * @author mbmnu
 */
public class Alumno extends Autor{
    
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
    

    public void setCx(String cx) {
        this.cx = cx;
    }   
}
