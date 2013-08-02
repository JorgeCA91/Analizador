/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;

/**
 *
 * @author Jorge
 */
public class Ls 
{
    private Object ls;
    Consola conso;
    
    public Ls(Consola cons)
    {
    	this.conso = cons;
    	String url = System.getProperty("user.dir");
    	setLs(url);
        funcionLs();
    }

    public Object getLs() {
        return ls;
    }

    public void setLs(Object ls) {
        this.ls = ls;
    }
    
    public void funcionLs()
    {
    	File f = new File(getLs().toString());
    	if (f.exists())
    	{ 
    		File[] ficheros = f.listFiles();
			for (int x=0;x<ficheros.length;x++)
			{
				conso.escribeConsola(ficheros[x].getName());
			} 
    	}
		else 
		{ 
			conso.escribeConsola("No hay archivos!!!\n");
		}
    }
}