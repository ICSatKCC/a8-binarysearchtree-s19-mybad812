import java.util.*;
/**
* Player object.
* for holding name, pokemon, and energy. 
* @author Jui-Chen Tang.
* @since 03/13/2019.
*/

public class Player {
  
  
   //instance String variables
   /**variables for Pokemon.*/
   private Pokemon poke;
   /**variables for Name.*/
   private String name = "";
   /**variables for Energy.*/
   private int energy = 0;
   
   /**Random number generator.*/
   //private Random rN = new Random();
   
   /**
   Exception set constructor.
   * @param sName  user-difined name.
   * @param pPoke  the pokemon users choose.
   * @param iEnergy the energy for using special attack.
   */
   public Player(String sName, Pokemon pPoke, int iEnergy) {
      this.setName(name);
      this.setEnergy(energy);
      this.setPoke(poke);
    
   }
   

   /** 
   * toString method.
   * @return s
   */
   public String toString() {
      String s = "";
      s = "\nName: " + this.name;
      s = s + "\nPokeman: " + this.poke;
      s = s + "\nEnergy: " + this.energy;
      return s;
   }
   
   /**
   * get method for Name.
   * @return name
   */
   public String getName() {
      return this.name;
   }
   /**
   * get method for Pokemon.
   * @return poke
   */
   public Pokemon getPoke() {
      return this.poke;
   }
   /**
   * get method for Energy.
   * @return energy
   */
   public int getEnergy() {
      return this.energy;
   }
   
   /**
   * set method for Name.
   * @param newName user-defined name.
   */
   public void setName(String newName) {
      int tempLength = 0;
      newName = newName.trim();
      tempLength = newName.length();
      if (tempLength > 0) {
         this.name = newName;
      }
   }
   /**
   * get method for Poke.
   * @param newPoke user-chose pokemon.
   */
   public void setPoke(Pokemon newPoke) {
      this.poke = newPoke;
   }
   /**
   * get method for Energy.
   * @param newEnergy Energy for using special attack.
   */
   public void setEnergy(int newEnergy) {
      this.energy = newEnergy;
   }
   /**
   * users create a name for themselves.
   * @param playerName a default varible.
   */
   public void createName(String playerName) { //Player name method
      System.out.println("**************Setting information*************");
      System.out.println("Hello, " + playerName 
          + "\nwhat is your name?");
      
      //String variables
      String sName = playerName;
      
      //Asks the user for a name
      Scanner qu = new Scanner(System.in);
      playerName = qu.nextLine().trim();
      
      if (playerName.isEmpty()) {
         playerName = sName;
         System.out.println("By default your name is " + playerName);
      }
      //returns the Name
      name = playerName;
   }


 
   
} //class ends