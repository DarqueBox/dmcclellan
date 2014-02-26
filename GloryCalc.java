
public class GloryCalc
    extends Thread
{
    private Calculator calc;
    GloryCalc()
    {
	calc = new Calculator();

    }
    public void run()
    {
	try
	    {
		calc.run();
		while(Glory.getInstance().shouldThreadBeRunning())
		    ;
	    }
	catch(Exception e)
	    {
	    }
	calc.setVisible(false);
    }



}
