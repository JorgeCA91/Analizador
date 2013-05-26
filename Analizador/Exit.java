/**
 *
 *
 * @author 
 * @version 1.00 2013/5/13
 */


public class Exit 
{
	private Consola conso;
    public Exit(Consola cons) 
    {
    	this.conso = cons;
    	ejecutaExit();
    }
    
    public void ejecutaExit()
    {
    	conso.setLee(false);
    }
}