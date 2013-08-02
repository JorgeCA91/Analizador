/**
 *
 *
 * @author 
 * @version 1.00 2013/5/23
 */


public class Errores 
{
	private Consola conso;
	private int index;
	private String error;
    public Errores(Consola cons) 
    {
    	this.conso = cons;
    }
    public void setError(int index,String err)
    {
	   	this.index = index;
    	this.error = err;
    }
    public String getError()
    {
    	return error;
    }
    
    public void despliegaErrror()
    {
    	switch (index) 
    	{
			case 0:
				conso.escribeConsola("cd : "+getError());
				break;
			case 1:
				conso.escribeConsola("ls : "+getError());
				break;
			case 2: 
				conso.escribeConsola("echo : "+getError());
				break;
			case 3: 
				conso.escribeConsola("pwd : "+getError());
				break;
			case 4: 
				conso.escribeConsola("exit : "+getError());
				break;
			case 5: 
				conso.escribeConsola("clear : "+getError());
				break;
			case 6: 
				conso.escribeConsola("cat : "+getError());
				break;
			case 7:
				conso.escribeConsola("asigna :"+getError ());
				break;
			case 8:
				conso.escribeConsola ("Variable Gobal :"+getError ());
				break;
			case 9:
				conso.escribeConsola ("suma :"+getError ());
				break;
			default :
		}
    	
    }
}