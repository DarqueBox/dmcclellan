import java.io.File;

public class Find
{
    private String[] mArg;

    Find(String[] tArg)
    {
	mArg = tArg;
    }

    void run()
    {
	File f = new File(".");
	String[] list = f.list();
	
	for(String tList:list)
	    {
		System.out.println(tList);
	    }
    }

    public static void main(String [] arg)
    {
	new Find(arg).run();
    }
}
