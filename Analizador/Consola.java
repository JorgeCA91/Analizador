/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Console;

/**
 *
 * @author Jorge
 */
public class Consola 
{
    private String cadena;
    boolean lee;
    Console console = System.console();
    
    public void setCadena(String cadena) 
    {
        this.cadena = cadena;
    }

    public String getCadena() 
    {
        return cadena;
    }

    public void setLee(boolean lee) 
    {
        this.lee = lee;
    }

    public boolean isLee() 
    {
        return lee;
    }
    
    public void leeConsola()
    {
        if (console == null) 
        {
            System.err.println("No hay consola.");
            System.exit(1);
        }

        console.printf(/*System.getProperty("user.dir")+*/">>>");
        cadena = console.readLine();
    }
    
    public void escribeConsola(String str)
    {
    	console.printf(str+"\n");
    }
}