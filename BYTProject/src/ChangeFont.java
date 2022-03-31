import java.awt.Color;

import javax.swing.JTextArea;

public class ChangeFont extends Change{

	@Override
	void change(JTextArea jta) {
		// TODO Auto-generated method stub
		jta.setForeground(new Color((int)(Math.random() * 0x1000000)));
	}

}
