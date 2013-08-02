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
       		String com = ""+temp1.charAt (0)+temp1.charAt (1)+temp1.charAt (2);
       		if(com.equals ("c:/"))
       		{
       			dir = temp1;
       			conso.escribeConsola("c:/");
       		}
       		else if (com.equals ("../"))
       		{
       			String dirTemp = System.getProperty("user.dir");
       			char sl = ' ';
       			conso.escribeConsola (dirTemp);
       			int i = dirTemp.length()-1;
       			char slash = '\\';
       			while (( sl!='\\' && sl!='/') && i>=0)
       			{	
       				sl = dirTemp.charAt(i);

       				i--;
       			}
       			String temp2 = dirTemp.substring(0,i+1);
       			conso.escribeConsola (temp2);
       			
       			if(temp2.equals ("c:"))
       				dir = "c:/";
       			else
       				dir = temp2;
       		}
       		else
       		{
       			conso.escribeConsola("....");
       			dir = System.getProperty("user.dir")+"\\"+temp1;
       		}
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