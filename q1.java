import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Program1 extends JFrame
{
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1;

	Program1()
	{
		JFrame frm = new JFrame("Number Conversion");
		frm.setSize(400,200);
		frm.setLayout(new GridLayout(5,2));
		
		JLabel l1 = new JLabel("Decimal Number");
		JTextField t1 = new JTextField(10);
		t1.setEditable(false);
		JLabel l2 = new JLabel("Binary Number");
		JLabel l3 = new JLabel ("");
		JLabel l4 = new JLabel("Result in Binary");
		JLabel l5 = new JLabel("Octal Number");
		JLabel l6 = new JLabel ("");
		JLabel l7 = new JLabel("Result in Octal");
		JLabel l8 = new JLabel("Hexadecimal Number");
		JLabel l9 = new JLabel ("");
		JLabel l10 = new JLabel("Result in Hexadecimal");
		JButton b1 = new JButton("Convert");
		JButton b2 = new JButton("Exit");
		
		
		frm.add(l1);
		frm.add(t1);
		frm.add(l2);
		//frm.add(l3);
		frm.add(l4);
		frm.add(l5);
		//frm.add(l6);
		frm.add(l7);
		frm.add(l8);
		//frm.add(l9);
		frm.add(l10);
		frm.add(b1);
		frm.add(b2);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
		
	}
	public static void main(String args[])
	{
		new Program1();
	}
}
