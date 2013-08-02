import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Cat
{
	private Consola conso;
	private String[][] comAn;
	private Vector archivos = new Vector();
	private String linea;
	private Errores errores;
	Object num = 5;
	
    public Cat(Consola cons,String[][] com)
    {
    	this.conso = cons;
    	this.comAn = com;
    	errores = new Errores(conso);
    	analliza();
    }
    public void analliza()
    {
    	if(comAn[0][1].isEmpty())
    	{
    		conso.escribeConsola("");
    		int x = (int) num;
    		conso.escribeConsola (""+x);
    	}
    	else
    	{
    		String temp = comAn[0][1].toString();
	   		int j = 0;
    		while(temp.charAt(j) == ' ')
   				{
   					j++;
 	  				if(j<temp.length())
   					{
   						continue;
   					}
   					else
	   				{
   						break;
   					}
   				}
   			String temp1 = temp.substring(j);
       		linea = temp1;
       		char carTem ;
    		String[] archivo = linea.split (" ");
	    	for (int i = 0; i<archivo.length; i++)
	    	{
    			archivos.add(archivo[i]);	    		
		    }
/*	    	for (int i = 0; i<archivos.size(); i++)
	    	{
	    		
	    		conso.escribeConsola(""+archivos.get(i));
		    }
		    conso.escribeConsola(""+archivos.size());
*/
    		despliegaArchivos();    		
    	}   
    }
    public void despliegaArchivos()
    {
    	for (int i = 0; i<archivos.size(); i++)
    	{
    		String ruta=archivos.get(i).toString();
    		BufferedReader a=cargaAr(ruta);
    		String l=leeAr(a);
    		while(l!=null)
    		{
    			conso.escribeConsola(l);
    			l=leeAr(a);
    		}
	    }
    }
    	
    public BufferedReader cargaAr(String nombre)
    {   
    	BufferedReader a=null;	 
        try
        {   
            a = new BufferedReader(new FileReader(nombre));
            
        }
        catch (FileNotFoundException e)
        {   
        	errores.setError(6,"El archivo "+nombre+" no existe.");
        	errores.despliegaErrror();
        }
        return a;
    } 
 
    public  String leeAr(BufferedReader d)
    {
        String linea = "";
        String data="";
        try
        {   
        	
            linea =d.readLine().toString ();
        }
        catch (Exception e)
        {
        	    if(linea.isEmpty ())
        	    {
        	    	return null;
        	    }
        	    {
        	    	errores.setError(6,"Error en lectura de el archivo...");
        			errores.despliegaErrror();
        			return null;
        	    }
        	

        }
        
        	if(linea!=null)
        	{
            	data = linea;
            	return data;
        	}
        	else
        	{
           		return  null;
        	}
    }
}