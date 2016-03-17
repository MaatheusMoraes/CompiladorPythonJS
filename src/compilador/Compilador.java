/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AnalisadorLexico al = new AnalisadorLexico();
        
        String codigo = "#teste int a \n int a\n";
        
        ArrayList<String> tokens = al.getTokens(codigo);
        
        for(int i=0; i<tokens.size(); i++)
        {
            System.out.println(tokens.get(i));
        }
            
    }
    
}
