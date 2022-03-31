import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;

public class ChangeBackground extends Change{



	@Override
	void change(JTextArea jta) {
		jta.setBackground(new Color((int)(Math.random() * 0x1000000)));
	}

}
