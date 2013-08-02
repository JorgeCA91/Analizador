/**
 *
 *
 * @author 
 * @version 1.00 2013/5/13
 */

import java.util.Hashtable;

public class Echo 
{
	private Consola conso;
	private String[][] comAn;
	private int contEs;
	int conTemp;
	private Hashtable varGlob;
	private Errores errores;
    public Echo(String[][] com,Consola cons,Hashtable var) 
    {
    	this.conso = cons;
    	this.comAn = com;
    	this.varGlob = var;
    	errores = new Errores(conso);
    	ejecutaEcho();
    }
    
    public void ejecutaEcho()
    {
    	if(comAn[0][1].isEmpty())
    	{
    		conso.escribeConsola("");
    	}
    	else
    	{
    		String linea="";
    		String temp = comAn[0][1].toString();
    		for (int i = 0; i<temp.length(); i++)
    		{
    			char c = temp.charAt(i);
    			if(c == '"')
    			{
    				contEs++;
    			}
    			else
    			{
    				linea = linea + c;
    			}
	    	}
	    	temp = linea;
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
   			temp = "";
   			char cc=' ';
   			boolean coma = false;
   			for(int n=0;n<temp1.length();n++)
   			{
   				cc=temp1.charAt(n);
   				if(cc==',')
   				{
   					coma=true;
   				}
   				
   			}
   			String msj[]=null;
   			String keyTmp="";
   			if(coma)
   			{
   				msj = temp1.split(",");
   				
   				temp = msj[0];
   				if(msj.length==1)
   				{
   					errores.setError (8,"Se esperaba una variable!");
   					errores.despliegaErrror ();
   				}
   				else
   				{
	   				keyTmp = msj[1];
   					generaMensaje (keyTmp,temp);
				}
   			}
   			else
   			{
   				temp = temp1;
   				   			int conTemp = (contEs % 2);
   			if((contEs==0 || contEs>0) && conTemp==0)
   			{	
   				
   					conso.escribeConsola(temp);
   				
   			}
   			else
   			{
   				errores.setError (2,"Error de sintaxtis en mensaje "+temp);
   				errores.despliegaErrror();
   			}
			}

    	}
    }
    public void generaMensaje(String a,String b)
    {
   			   			conTemp = (contEs % 2);
   			if((contEs==0 || contEs>0) && conTemp==0)
   			{	
   				if(varGlob.containsKey(a))
   				{
   					try 
					{
						Object[] val=(Object[])varGlob.get(a);
						conso.escribeConsola(b+""+val[1].toString ());
					}
					catch(NullPointerException e)
					{
						errores.setError(8,"variable no definida");
						errores.despliegaErrror ();
					}
   				}
   				else
   				{
   					errores.setError(8,"variable "+a+" no definida");
   					errores.despliegaErrror();
   				}
   			}

   			else
   			{
   				errores.setError (2,"Error de sintaxtis en mensaje "+b);
   				errores.despliegaErrror();
   			}    	
    }
}