import java.util.ArrayList;
import java.util.List;

public class Caretaker {
   public List<Memento> mementos = new ArrayList<Memento>();

   public void add( int index,Memento state){
      mementos.add(index,state);
   }

   public Memento get(int index){
      return mementos.get(index);
   }
}