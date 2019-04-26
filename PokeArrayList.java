import java.util.*;

/**
* Pokemon Container class.
* @author Jui-Chen Tang
* @since 03/05/19
*/

public class PokeArrayList {
   
   /** Array list that only hold pokemons.   */
   private ArrayList<Pokemon> pList = new ArrayList<>();
   /** the maximum size of pokemon arraylist. */
   private static final int SIZE = 6;
   /** index of added pokemon. */
   private int arrayIndex = 0;
   
   /** 
   * Add a pokemon to the arraylist. 
   * @param p the generated pokemon
   */
   public void add(Pokemon p) {
     
      int i = arrayIndex % SIZE;
      if (pList.size() < SIZE) {
         pList.add(p);
      } else {
         pList.set(i, p); 
      }     
      arrayIndex++;
   }
   
   
   public void clear() {
      pList.clear();
   }
   public void print() {
      if (pList.isEmpty()) {
         System.out.println("The List is empty.Please add some Pokemon first.\n");
      } else {
         for (int i = 0; i < pList.size() && i < SIZE; i++) {
            System.out.println("Pokemon " + (i + 1) + " : ");
            System.out.println(pList.get(i));
         
         }
      }
   }
    
}