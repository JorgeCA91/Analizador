/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jorge
 */
public class Pwd 
{
    private Object pwd;
    private Consola conso;
    public Pwd(Consola cons)
    {
    	this.conso = cons;
    	String url=System.getProperty("user.dir");
        setPwd(url);
        funcionPwd();
    }

    public Object getPwd() {
        return pwd;
    }

    public void setPwd(Object pwd) {
        this.pwd = pwd;
    }
    
    public void funcionPwd()
    {
        conso.escribeConsola(getPwd().toString());
    }
}