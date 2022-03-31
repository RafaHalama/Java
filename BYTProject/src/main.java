import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class main {
	public static int pos = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JTextArea jta = new JTextArea(19,18);
		
		Originator o = new Originator();
		Caretaker c = new Caretaker();
		
		Context context = new Context();
		JCheckBox jcb = new JCheckBox("Bold");
		
		JCheckBox jcb2 = new JCheckBox("Italic");
		
		JCheckBox jcb3 = new JCheckBox("Plain");
		jcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoldState bs = new BoldState();
				bs.doAction(context, jta);
				jcb2.setSelected(false);
				jcb3.setSelected(false);
				System.out.println(context.getState().toString());
			}
		});
		
		jcb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItalicState bs = new ItalicState();
				bs.doAction(context, jta);
				jcb.setSelected(false);
				jcb3.setSelected(false);
				System.out.println(context.getState().toString());
			}
		});
		jcb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlainState bs = new PlainState();
				bs.doAction(context, jta);
				jcb.setSelected(false);
				jcb2.setSelected(false);
				System.out.println(context.getState().toString());
			}
		});
	    jta.setFont(new Font("TimesRoman", Font.PLAIN, 12));

		o.setState(jta);
		c.add(pos, o.createMemento());
		pos++;
		jta.append("Start");
		panel.add(new JScrollPane(jta));
		
		panel.add(jcb);
		panel.add(jcb2);
		panel.add(jcb3);
		o.setState(jta);
		c.add(pos, o.createMemento());

		DocumentListener documentListener = new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {

				o.setState(jta);
				pos++;
				c.add(pos, o.createMemento());

			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {

				o.setState(jta);
				pos++;
				c.add(pos, o.createMemento());
			}
		};
		jta.getDocument().addDocumentListener(documentListener);

		JButton cofnij = new JButton("Cofnij");
		cofnij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{String x = c.get(pos - 1).getState();
				c.mementos.remove(pos);
				pos--;
				/*for (Memento xy : c.mementos) {
					System.out.println(xy.getState());
				}*/
				jta.getDocument().removeDocumentListener(documentListener);
				jta.setText(x);
				jta.getDocument().addDocumentListener(documentListener);
				}catch(Exception x){}

			}
		});
		Change change1 = new ChangeBackground();
		Change change2 = new ChangeFont();
		JButton kolor = new JButton("Zmien kolor tła");
		kolor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				change1.change(jta);
			
			}
		});
		JButton kolor2 = new JButton("Zmien kolor czcionki");
		kolor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				change2.change(jta);
				
				

			}
		});
		
		    
		
		panel.add(kolor);
		panel.add(kolor2);
		panel.add(cofnij);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
