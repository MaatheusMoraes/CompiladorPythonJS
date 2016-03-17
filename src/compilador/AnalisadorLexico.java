/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Matheus
 */
public class AnalisadorLexico {
    
    String codigo; 
    
    String comentarios = "(#.*?\\n)"; 
    /* 
        Comentários será o grupo 1 e ele não será incluído nos Tokens!
    */
    String fimdelinha = "(\\r\\n|\\r|\\n)";
    String identificadores = "([\\p{L}-_\\d]+)";
    String numeros = "(\\d+\\.\\d*)";
    String comparadores = "(==)|(<=)|(=<)|(>=)|(=>)|(!=)|(=!)";
    
    String pattern = comentarios+"|"+fimdelinha+"|"+identificadores+"|"+numeros+"|"+comparadores;
    
    public ArrayList<String> getTokens(String codigo)
    {
        ArrayList<String> tokens = new ArrayList<String>();
        
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(codigo);
        
        int linhas = 0;
        
        while(m.find())
        {
            if(m.group(2)!=null)
            {
                linhas++; // Se for do grupo 2, linhas++ para saber em qual linha estava!
                tokens.add(";"); // ";" representará a quebra de linha
            }
            
            
            /*
                Se não for do grupo 1, insere o token
            */
            if(m.group(1)==null){
                tokens.add(m.group(0));
            }
        }
        
        System.out.println("Possui "+linhas+" linhas");
        
        return tokens;
    }
    
}
