
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Calculator
    extends JFrame
    implements Runnable
{
    private ActionListener nListener;
    private ActionListener oListener;
    private ActionListener tListener;

    private String oper;
    private float total;

    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b0;
    private JButton ba;
    private JButton bb;
    private JButton bc;
    private JButton bd;
    private JButton be;
    private JButton bm;
    private JButton bp;
    private JButton bs;

    private JTextField t1;

    private String outText;

    private JPanel mainPanel;
    private JPanel buttons;
    private JPanel text;

    public Calculator()
    {
	super("Calculator");
	setFont(new Font("Arial", 1, 20));
	GridBagConstraints c = new GridBagConstraints(); 
	GridBagLayout gridBag = new GridBagLayout();
	
	Insets inset = new Insets(3, 3, 3, 3);
	outText = new String("");
	total = 0;
	oper = " ";

	buttons = new JPanel();
	text = new JPanel();
	mainPanel = new JPanel();

	EmptyBorder em = new EmptyBorder(new Insets(5, 5, 5, 5));
	mainPanel.setBorder(em);

	setMinimumSize(new Dimension(250, 300));
	buttons.setLayout(new GridLayout(5, 4));
	text.setLayout(new GridLayout(1, 1));
	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

	addWindowListener(new WindowAdapter()
	    {
		public void windowClosing(WindowEvent e)
		{
		}
	    });

	nListener = new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    outText += ((JButton)e.getSource()).getText();
		    t1.setText(outText);
		}
	    };

	oListener = new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    calculate(Float.parseFloat(t1.getText()));
		    oper = ((JButton)e.getSource()).getText();
		    outText = "";
		    t1.setText(Float.toString(total));
		}
	    };

	b0 = new JButton("0");
	b1 = new JButton("1");
	b2 = new JButton("2");
	b3 = new JButton("3");
	b4 = new JButton("4");
	b5 = new JButton("5");
	b6 = new JButton("6");
	b7 = new JButton("7");
	b8 = new JButton("8");
	b9 = new JButton("9");

	ba = new JButton("+");
	bb = new JButton("<-");     
	bc = new JButton("c"); 
	bd = new JButton("/");
	be = new JButton("=");
	bm = new JButton("*");
	bp = new JButton(".");      
	bs = new JButton("-");

	t1 = new JTextField("", 15);

	
	text.add(t1);

	buttons.add(bc);
	buttons.add(bb);
	buttons.add(new Label(""));
	//

	buttons.add(bd);

	buttons.add(b1);
	buttons.add(b2);
	buttons.add(b3);

	buttons.add(bm);

	buttons.add(b4);
	buttons.add(b5);
	buttons.add(b6);

	buttons.add(bs);

	buttons.add(b7);
	buttons.add(b8);
	buttons.add(b9);

	buttons.add(ba);

	buttons.add(new Label(""));
	buttons.add(b0);
	buttons.add(bp);
	buttons.add(be);

	mainPanel.add(text);
	mainPanel.add(buttons);

	add(mainPanel);

	//add(mainFrame);

    }
    public void calculate(float num)
    {
	switch(oper)
	    {
	    case "+":
		total += num;
		break;
	    case "-":
		total -= num;
		break;
	    case "*":
		total *= num;
		break;
	    case "/":
		total /= num;
		break;
	    case " ":
		total = num;
	    case "=":
	    default:
	    }


    }
    public void run()
    {
	b1.addActionListener(nListener);
	b2.addActionListener(nListener);
	b3.addActionListener(nListener);
	b4.addActionListener(nListener);
	b5.addActionListener(nListener);
	b6.addActionListener(nListener);
	b7.addActionListener(nListener);
	b8.addActionListener(nListener);
	b9.addActionListener(nListener);
	b0.addActionListener(nListener);
	bp.addActionListener(nListener);

	ba.addActionListener(oListener);
	bb.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    try
			{
			    outText = outText.substring(0, outText.length() - 1);
			    t1.setText(outText);
			}
		    catch(Exception x)
			{
			}
		}
	    });

	bc.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		outText = "";
		total = 0;
		t1.setText("");
		}
	    });

	bd.addActionListener(oListener);
	be.addActionListener(oListener);
	bm.addActionListener(oListener);
	bs.addActionListener(oListener);

	this.setVisible(true);

    }


}
