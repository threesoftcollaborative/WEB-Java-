/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Max
 */
public class Utils {

    public Utils() {
    }
    
    //Metodo que formatea numeros a peso Chileno
    public String formatPrecio(int precio) {
        Locale locale = new Locale("es","CL"); 
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(precio).replace("Ch$", "$ ");
    }
    
    
}
