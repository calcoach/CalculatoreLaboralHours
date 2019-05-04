/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public class FieldString {
    
    
    public static String fieldNum(String str){
       
        String string = deleteWhiteSpaces(str);
        char[] cadena = string.toCharArray();
        int n = cadena.length - 1;
        char[] cadena2 = new char[100];
        int cont = 0;
        int cont2 = 0;

        for (int i = n; i >= 0; i--) {
            if ((cont + 1) % 4 == 0) {

                cadena2[cont] = ' ';
                cont++;
                cont2++;
            }
            cadena2[cont] = cadena[i];
            cont++;

        }
        
        cadena = new char[cont+1];

        for (int i = 0; i <= cont; i++) {

            cadena[cont - i] = cadena2[i];
        }
        
        
        return String.copyValueOf(cadena, 1, cont);
    }
    
    public static String fieldNum(double num){
        
        int numInt = (int) num;
        String numStr = String.valueOf(numInt);
        
        
        return fieldNum(numStr);
    }
    
    public static String deleteWhiteSpaces(String str){
        
        return str.replaceAll(" ", "");
    }
    
    public static void moveCaret(int caretPosition, JTextField field, java.awt.event.KeyEvent evt) {

        int size = field.getText().length();

        if (caretPosition > size) {
            caretPosition = caretPosition - (caretPosition - size);

        } else if (!evt.isActionKey() & evt.getKeyCode() != 8 &(size>caretPosition)) {
            caretPosition++;
        }

        field.setCaretPosition(caretPosition);
    }
}
