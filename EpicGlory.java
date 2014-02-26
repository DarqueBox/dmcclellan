
public class EpicGlory
    extends Thread
{
    String [] thing;
    private Epic epic;
    EpicGlory(String [] args)
    {
	thing = args;
	epic = new Epic();



    }
    public void run()
    {
	try
	    {
		
		while(Glory.getInstance().shouldThreadBeRunning())
		   ;
	    }
	catch(Exception e)
	    {
	    }
    }
    public static void main(String [] args)
    {
	
	(new EpicGlory(args)).run();

    }



}
