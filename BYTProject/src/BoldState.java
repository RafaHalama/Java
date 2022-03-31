import java.awt.Font;

import javax.swing.JTextArea;

public class BoldState implements State {

   public void doAction(Context context, JTextArea jta) {
      jta.setFont(new Font("TimesRoman", Font.BOLD, 12));
      context.setState(this);	
   }

   public String toString(){
      return "Wybrano czcionkę pogrubioną";
   }
}