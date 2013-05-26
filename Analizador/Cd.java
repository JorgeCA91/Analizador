/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
/**
 *
 * @author Jorge
 */
public class Cd 
{
    private Object cd;
    private String[][] comAn;
	private Consola conso;
	private Errores errores;
	private String dir;
    public Cd(String[][] com,Consola cons) 
    {
        this.comAn = com;
        this.conso = cons;
        errores = new Errores(conso);
        funcionCd();
    }
    
    public void funcionCd()
    {
    	analizaDir();
    }
    
    public void setDir()
    {
    	if(comAn[0][1].isEmpty())
    	{
    		conso.escribeConsola("");
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
       		dir = temp1;
    	}
    }
    
    public String getDir()
    {
    	return dir;
    }
    public void analizaDir()
    {
		setDir();
		try
		{
			File f = new File(getDir());
    		if (f.exists())
    		{ 
    			conso.escribeConsola("1");
    			System.setProperty("user.dir",getDir()); 
    		}
			else 
			{ 
				errores.setError(0,"No Existe el directorio especificado...");
				errores.despliegaErrror();
			}
		}
		catch(Exception e)
		{
			
		}
    }
}