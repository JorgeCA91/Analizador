/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Vector;
import java.util.Hashtable;
import java.util.Collection;

/**
 *
 * @author Jorge
 */
public class Comando 
{
	
    private String comAn[][];
    private Consola conso;
	private Cd cd;
	private Ls ls;
	private Pwd pwd;
	private Echo echo;
	private Exit exit;
	private Clear clear;
	private Cat cat;
	private Asigna asigna;
	private Suma suma;
	private int index; 
	private Hashtable varGlob;
    Vector comandos = new Vector();
    
   	public Comando(String[][] com, Hashtable var)
   	{
		comandos.add("cd");
   		comandos.add("ls");
   		comandos.add("echo");
   		comandos.add("pwd");
   		comandos.add("exit");
   		comandos.add("clear");
   		comandos.add("cat");
   		comandos.add("asigna");
   		comandos.add ("suma");
   		this.comAn = com;
   		this.varGlob = var;
   		
   	}
    public void consigueConsola(Consola cons)
    {
    	this.conso = cons;
    }
    public boolean isComando()
    {
    	boolean si= false;
    	for (int i = 0; i<comandos.size(); i++) 
    	{
    		if(comAn[0][0].toString().equals(comandos.get(i)))
    		{
    			si = true;
    			index = i;
    		}
	    }
	    
	    return si;
    }
    
    public void ejecutaCom()
    {
    	switch (index) 
    	{
    		case 0://cd	
    			cd = new Cd(comAn,conso);
    			break;
			case 1://ls
				ls = new Ls(conso);
				break;
			case 2://echo
				echo = new Echo(comAn,conso,varGlob);
				break;
			case 3://pwd 
				pwd = new Pwd(conso);
				break;
			case 4://exit
				exit = new Exit(conso);
				break;
			case 5://clear
				clear = new Clear(conso);
				break;
			case 6://cat
				cat = new Cat(conso,comAn);
				break;
			case 7://Asigna
				asigna = new Asigna(varGlob,conso,comAn);
				break;
			case 8://Suma
				suma = new Suma(varGlob,conso,comAn);
			default :
		}
    }
}