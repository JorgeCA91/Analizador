import java.io.IOException;
import java.util.Vector;
import java.util.Hashtable;
import javax.swing.JOptionPane;
public class Analizador 
{
    Consola conso;
    String linea;
    String palabra ="";
    String[][] comAn = new String[1][2];
    Errores errores;
    
    Comando com;
    int key = 0;
    private Hashtable varGlob;
    public static void main(String[] args) 
    {
        Analizador anali = new Analizador();
    }
    
    public Analizador()
    {
    	comAn[0][0] = "";
        comAn[0][1] = "";
        conso = new Consola();
        conso.setLee(true);
        errores = new Errores(conso);
        varGlob = new Hashtable();
        varGlob.put (".",0);
        while(conso.isLee())
        {
            conso.leeConsola();
            linea = conso.getCadena();
            separa();
            analiza();
        }
    }
    
    public void separa()
    {
        char c;
        int index=0;
        comAn[0][0] = "";
        comAn[0][1] = "";
        palabra = "";
        for (int i = 0; i<linea.length(); i++)
        {		
        	c = linea.charAt(i);
            if(c == ' ')
            {   
                break;
            }
            else
            {
                palabra = palabra + c;
                index++;
            }
        }
        comAn[0][0] = palabra;
        comAn[0][1] = linea.substring(index);
	}
	
	public void analiza()
	{
		com = new Comando(comAn,varGlob);
		if(com.isComando())
		{
			
			//conso.escribeConsola("Ejecutando comando...");
			com.consigueConsola(conso);
			com.ejecutaCom();
		}
		else if(varGlob.containsKey(comAn[0][0]))
		{
			try 
			{
				Object[] val=(Object[])varGlob.get(comAn[0][0].toString ());
				conso.escribeConsola(""+val[1].toString ());
			}
			catch(NullPointerException e)
			{
				errores.setError(8,"variable no definida");
				errores.despliegaErrror ();
			}
		}
		else
		{
			conso.escribeConsola("Error: "+comAn[0][0].toString ()+" no es comando, ni esta definido como variable...");
		}	
	}
}
//antonio.hernandez.blas@gmail.com