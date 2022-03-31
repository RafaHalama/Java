import javax.swing.JTextArea;

public class Originator {
   private String state;

   public void setState(JTextArea state){
      this.state = state.getText();
   }

   public String getState(){
      return state;
   }

   public Memento createMemento(){
      return new Memento(state);
   }

   public void setMemento(Memento memento){
      state = memento.getState();
   }
}