import java.util.*;
/**
* Demonstrates using ArrayList generic class.
* @author Lisa Miller
* @since 2/21/2018
*/
public class ArrayListDemo {
  /** main method.
  * @param args not used.
  */
   public static void main(String[] args) {
   
      Random rand = new Random();
      Integer num = new Integer(0);
      
      //generic class can only hold Objects
      //must use wrapper class for primitive types
      ArrayList<Integer> iList = new ArrayList<>();
      
      //fill list with random ints
      for (int i = 0; i < 1000; i++) {
         num = rand.nextInt(100); 
         iList.add(num);
      }
      
      //print list
      for (int i = 0; i < iList.size(); i++) {
         System.out.println(i + ":\t" + iList.get(i));
      
      }

   }
}