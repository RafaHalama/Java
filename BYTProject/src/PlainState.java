import java.awt.Font;

import javax.swing.JTextArea;

public class PlainState implements State {

   public void doAction(Context context, JTextArea jta) {
      jta.setFont(new Font("TimesRoman", Font.PLAIN, 12));
      context.setState(this);	
   }

   public String toString(){
      return "Wybrano czcionkę prostą";
   }
}