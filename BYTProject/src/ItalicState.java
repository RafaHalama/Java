import java.awt.Font;

import javax.swing.JTextArea;

public class ItalicState implements State {

   public void doAction(Context context, JTextArea jta) {
      jta.setFont(new Font("TimesRoman", Font.ITALIC, 12));
      context.setState(this);	
   }

   public String toString(){
      return "Wybrano czcionkę przekrzywiona";
   }
}