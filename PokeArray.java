import java.util.*;
/**
* Pokemon Driver.
* @author Jui-Chen Tang
* @since 03/05/19
*/

public class PokeArray {
   
  
   /**
   * Main method.
   * @param args not used.
   */
   public static void main(String [] args) {
      
      PokeArrayList pokelist = new PokeArrayList();
   
      boolean endloop = false;
      String sTemp = "";
      Scanner reader = new Scanner(System.in);
      String userOrder = "";
      
      System.out.println("Welcome to Pokemon Maker !\n");
      while (!endloop) {
      
         System.out.println("\nPlease press the number of your choice :\n"
               + "1. Add a Pokemon\n"
               + "2. Print all Pokemon\n"
               + "3. Discard all Pokemon\n"
               + "0. Exit the program\n");
               
         userOrder = reader.nextLine();
      
         switch (userOrder) {
         
            case "1" : 
               System.out.println(); 
               Pokemon p = makePokemon();
               pokelist.add(p);
               System.out.println(p.getName() + " has been added!");            
            
               break;
            
            case "2" :  
               
               System.out.println();        
               pokelist.print();
               break;
            
            case "3" :
               
               System.out.println("You have discarded all the pokemons!");
               pokelist.clear();
               System.out.println();
               break;
            
            case "0" :
               
               System.out.println(); 
               System.out.println("Goodbye!");
               endloop = true;
               break;
            
            default :
               
               System.out.println("You did not enter a valid number."
                     + " Please try again.");  
         
         }
      }
      
   }
   
   /**
   * make a new pokemon.
   * @return generate a new pokemon .
   */
   public static Pokemon makePokemon() {
      
      Scanner reader = new Scanner(System.in);
      String temp = "";
      String inputIndex = "";
      String inputName = "";
      int split = -100;
      boolean end = true;
      Pokemon p;
      
   
      do {
      
         System.out.println("\nWhich pokemon do you want to add your list? "
               + "\nYou can set a name after enter the case number and a space. "
               + "\nYou can press 0 to check pokedex and available pokemons.");
      
         temp = reader.nextLine().trim();
         if (temp.indexOf(" ") != -1) {
            split = temp.indexOf(" ");
            inputIndex = temp.substring(0, split);
            inputName = temp.substring(split, temp.length()).trim();
         } else {
            inputIndex = temp;
         }
         
         
         switch (inputIndex) {
            
            case "0" :
               
               String s = "";
               s += "\n1.   Bulbasaur";
               s += "\n2.   Ivysaur";
               s += "\n3.   Venusaur";
               s += "\n4.   Charmander";
               s += "\n5.   Charmeleon";
               s += "\n6.   Charizard";
               s += "\n7.   Squirtle";
               s += "\n8.   Wartortle";
               s += "\n9.   Blastoise";
               
               
               
               System.out.println(s);
               
               end = false;
               break;
               
            case "1" :
            
               if (inputName.length() == 0) {
                  p = new Bulbasaur();
               } else {
                  p = new Bulbasaur(inputName);
               }
               return p;
         
            case "2" :
            
               if (inputName.length() == 0) {
                  p = new Ivysaur();
               } else {
                  p = new Ivysaur(inputName);
               }
               
               return p; 
                         
            case "3" :
            
               if (inputName.length() == 0) {
                  p = new Venusaur();
               } else {
                  p = new Venusaur(inputName);
               }
               
               return p; 
                     
            case "4" :
            
               if (inputName.length() == 0) {
                  p = new Charmander();
               } else {
                  p = new Charmander(inputName);
               }
               
               return p;
         
            case "5" :
            
               if (inputName.length() == 0) {
                  p = new Charmeleon();
               } else {
                  p = new Charmeleon(inputName);
               }
               
               return p;
         
            case "6" :
            
               if (inputName.length() == 0) {
                  p = new Charizard();
               } else {
                  p = new Charizard(inputName);
               }
               
               return p;
         
            case "7" :
            
               if (inputName.length() == 0) {
                  p = new Squirtle();
               } else {
                  p = new Squirtle(inputName);
               }
               
               return p;
         
            case "8" :
            
               if (inputName.length() == 0) {
                  p = new Wartortle();
               } else {
                  p = new Wartortle(inputName);
               }
               
               return p;
         
            case "9" :
            
               if (inputName.length() == 0) {
                  p = new Blastoise();
               } else {
                  p = new Blastoise(inputName);
               }
               
               return p;
         
                                    
            default :
               
               System.out.println("The index is not in the list. Try again.");
               end = false;
         } 
      } while (!end);     
   
      Pokemon done = new Bulbasaur("lol");
      return done;
   }

}