/**
 *
 *
 * @author 
 * @version 1.00 2013/5/13
 */


public class Echo 
{
	private Consola conso;
	private String[][] comAn;
	private int contEs;
	
    public Echo(String[][] com,Consola cons) 
    {
    	this.conso = cons;
    	this.comAn = com;
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
   			temp = temp1;
   			int conTemp = contEs%2;
   			if(contEs>0 && conTemp==0)
   			{	
   				conso.escribeConsola(temp);
   			}
   			else
   			{
   				conso.escribeConsola("Error en: "+temp);
   			}
    	}
    }
}