import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;
public class Analizador 
{
    Consola conso;
    String linea;
    String palabra ="";
    String[][] comAn = new String[1][2];
    Comando com;
    int key = 0;
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
		com = new Comando(comAn);
		if(com.isComando())
		{
			
			//conso.escribeConsola("Ejecutando comando...");
			com.consigueConsola(conso);
			com.ejecutaCom();
		}
		else 
		{
			conso.escribeConsola("Comando no valido...");
		}	}
}
//antonio.hernandez.blas@gmail.com