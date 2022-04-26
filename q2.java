import java.awt.*;
import java.applet.*;
import javax.swing.*;

/*<applet code = "Program2" width=500 height=500>
</applet>
*/

public class Program2 extends JApplet
{
	JLabel l1,l2,l3;
	JComboBox c1;
	String fontAvail[];
	JRadioButton rb1,rb2;
	ButtonGroup g1;
	JList list;
	DefaultListModel dlm;
	JTextField t1;
	JButton b1,b2;
	JScrollPane jsp;
	
	public void init()
	{
		setLayout(null);
		l1 = new JLabel("Font");
		l1.setBounds(50,50,50,30);
		
		l2 = new JLabel("Font Style");
		l2.setBounds(200,50,100,30);
		
		l3 = new JLabel("Size");
		l3.setBounds(350,50,50,30);
		
		c1 = new JComboBox();
		c1.setBounds(50,100,100,30);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fontAvail = ge.getAvailableFontFamilyNames();
		for(int i = 0;i<fontAvail.length;i++)
		{
			c1.addItem(fontAvail[i]);
		}
		
		g1 = new ButtonGroup();
		rb1 = new JRadioButton("Bold");
		g1.add(rb1);
		rb1.setBounds(200,90,70,30);
		rb2 = new JRadioButton("Italic");
		g1.add(rb2);
		rb2.setBounds(200,120,70,30);
		
		dlm = new DefaultListModel();
		for(int i = 0;i<73;i++)
		{
			dlm.addElement(String.valueOf(i));
		}
		
		JList list = new JList(dlm);
		list.setBounds(350,90,50,50);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		jsp = new JScrollPane(list);
		jsp.setPreferredSize(new Dimension(120,90));
		
		list.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent le)
			{
				int idx = list.getSelectedIndex();
			}
		});
	
		getContentPane().add(jsp);
		
		t1 = new JTextField("Hello Everyone");
		t1.setEditable(false);
		t1.setBounds(50,150,100,30);
		
		b1 = new JButton("Apply");
		b1.setBounds(200,150,90,30);
		
		b2 = new JButton("Exit");
		b2.setBounds(350,150,90,30);
		
		add(l1);
		add(l2);
		add(l3);
		add(c1);
		add(rb1);
		add(rb2);
		add(t1);
		add(b1);
		add(b2);
		add(list);
		add(jsp);
		setVisible(true);
	}
}
