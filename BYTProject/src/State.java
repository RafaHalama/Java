import javax.swing.JTextArea;

public  interface State {
   public void doAction(Context context, JTextArea jta);
}