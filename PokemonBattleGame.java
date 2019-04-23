import java.util.*;
import java.util.Random;
/**
*  InteractivePokemonGame dirve class.
*  The player.java class also relates this dirve class.
*  You may need to check it.
*  @author Jui-Chen Tang.
*  @since  03/13/2019.
*/
public class PokemonBattleGame {
   /** main method.
   *  @param args not used.
   */
   public static void main(String[ ] args) {      
   /** call Player class and make an varible. */
      Player player1;
      Player player2;
   /** call Pokemon class, and initialized the varibles*/
      Pokemon poke1 = new Bulbasaur();
      Pokemon poke2 = new Bulbasaur();
   /** initialize the name for player name */   
      String p1Name = "player1";
      String p2Name = "player2";
   /** make a varible to hold the energy data.*/
      int p1Energy = 0;
      int p2Energy = 0;
      
      /** player 1 set up information*/
      /** initialized Player1 */
      player1 = new Player(p1Name, poke1, p1Energy);
      /** call createName method to make the user-name for p1*/
      player1.createName(p1Name);
      /** call makePokemon method to create a pokemon*/
      poke1 = PokemonBattleGame.makePokemon();
      /** using set method to set up the pokemon into the player1 object*/ 
      player1.setPoke(poke1);
      /** using set method to set the Energy default to 0*/
      player1.setEnergy(p1Energy);
      
      /** player 2 set up information*/
      /** initialized player2*/
      player2 = new Player(p2Name, poke2, p2Energy);
      /** call createName method to make the user-name for p2*/
      player2.createName(p2Name);
      /** call makePokemon method to create a pokemon*/
      poke2 = PokemonBattleGame.makePokemon();
      /** using set method to set up the pokemon into the player2 object*/ 
      player2.setPoke(poke2);  
      /** using set method to set the Energy default to 0*/
      player2.setEnergy(p2Energy);
         
      /** an int varible to determine turn changed.*/
      int turn = 0;
      Random ranNum = new Random();
      /** for ramdonly pick up a player who gose first.*/
      turn = (ranNum.nextInt(2)) + 1;
      boolean gameover = true;
      while (gameover) {
         if (poke1.getHP() <= 0 || poke2.getHP() <= 0) { //game over
            if (poke1.getHP() < poke2.getHP()) {
               System.out.println("************ Congratulations! ************\n"
                   + player2.getName() + " won the game!");
            } else {
               System.out.println("************ Congratulations! ************\n"
                   + player1.getName() + " won the game!");
            }
            gameover = false;
            break;
         }
         System.out.println("\n*************** Battle information"
             + "**************\n");
         System.out.println("player1's Pokemon: " + poke1.getName()
             + "    ||     " + "player2's Pokemon: " + poke2.getName());
         System.out.println(player1.getName() + "'s Hp: " + poke1.getHP() 
             + "    ||     " + player2.getName() + "'s Hp: " + poke2.getHP());
         System.out.println(player1.getName() + "'s Energy: " 
             + player1.getEnergy() + "     ||     " + player2.getName() 
             + "'s Energy: " + player2.getEnergy());
         System.out.println("\n******************************"
             + "*********************\n");
         if (turn == 1) { //play1 turn  
            int hpBeforeAttack2 = poke2.getHP(); 
            battleMenu(player1, player2);
            int hpAfterAttack2 = poke2.getHP();
            int fhp2 = hpBeforeAttack2 - hpAfterAttack2;
            System.out.println("damage you did on "
                + player2.getName() + ": " + fhp2);
            turn = 2;
         } else if (turn == 2) { //play2 turn
            int hpBeforeAttack1 = poke1.getHP();
            battleMenu(player2, player1);
            int hpAfterAttack1 = poke1.getHP();
            int fhp1 = hpBeforeAttack1 - hpAfterAttack1;
            System.out.println("damage you did on " + player1.getName()
                + ": " + fhp1);
            turn = 1;
         }
      }
   
      
   
   } //close the main class 
   /** a method for battle.
   * Asking what action users want to do.
   * @param user the player who prepare to act.
   * @param victim the player who be attacked.
   */
   public static void battleMenu(Player user, Player victim) {
      Pokemon u = user.getPoke();
      
      Pokemon v = victim.getPoke();
      
      int uE = user.getEnergy();
      Scanner reader = new Scanner(System.in);
      String temp1 = "";
      boolean bo = true;
      while (bo) {
         System.out.println("\n" + user.getName() + ", it's your turn.");
         System.out.println("Please enter a index number of action");
         System.out.println("1.perform fastAttack.");
         System.out.println("2.perform specialAttack. Required 3 Energy.");
         System.out.println("3.pass. Get 1 Energy");
         System.out.println("4.your pokemon information");
         temp1 = reader.nextLine();
         temp1 = temp1.trim();
         
         switch (temp1) {
            case "1":
               u.performFastAttack(v);
               String f = u.performFastAttack(v);
               System.out.println("result: " + f);
               bo = false;
               break;
            case "2":
               if (uE >= 3) {
                  u.performSpecialAttack(v);
                  String s = u.performSpecialAttack(v);
                  System.out.println("result: " + s);
                  uE = uE - 3;
                  user.setEnergy(uE);
                  bo = false;
               } else {
                  System.out.println("Energy is not enough for specialAttack!");
                  bo = true;
               }
               break;
            case "3":
               uE++;
               user.setEnergy(uE);
               bo = false;
               break;
            case "4":
               System.out.println(user.getPoke());
               break;
            default:
               System.out.println("\nInvalid menu choice.\nPlease try again");
               break;
         }
      }
   }
   /** a method for make new pokemon.
   *  Asking information about the pokemon.
   *  @return a new pokemon
   */
   public static Pokemon makePokemon() {
      /** call the Pokemon class, and initialize pokemon*/
      Pokemon p = new Bulbasaur();
     
      String name = "";
    
      boolean endLoop2 = true; // ask number from user
      
      Scanner reader = new Scanner(System.in);
      String sTemp = "";
      String inString = "";
      
      /** menu of pokemon.
        * user can enter the number for choosing their pokemon.    
        */
      while (endLoop2) {
         System.out.println("Please enter the number to choose a Pokemon");
         System.out.println("1. Add a Bulbasaur");
         System.out.println("2. Add a Ivysaur");
         System.out.println("3. Add a Venusaur");
         System.out.println("4. Add a Charmander");
         System.out.println("5. Add a Charmeleon");
         System.out.println("6. Add a Charizard");
         System.out.println("7. Add a Squirtle");
         System.out.println("8. Add a Wartortle");
         System.out.println("9. Add a Blastoise");
         System.out.println("Pick a Pokeman ");
         inString = reader.nextLine();
         inString = inString.trim();
         switch(inString) { 
            case "1":
               p = new Bulbasaur();
               endLoop2 = false;
               break;
            case "2":
               p = new Ivysaur();
               endLoop2 = false;
               break;
            case "3":
               p = new Venusaur();
               endLoop2 = false;
               break;
            case "4":
               p = new Charmander();
               endLoop2 = false;
               break;
            case "5":
               p = new Charmeleon();
               endLoop2 = false;
               break;       
            case "6":
               p = new Charizard();
               endLoop2 = false;
               break;
            case "7":
               p = new Squirtle();
               endLoop2 = false;
               break;
            case "8":
               p = new Wartortle();
               endLoop2 = false;
               break;
            case "9":
               p = new Blastoise();
               endLoop2 = false;
               break;
            default:
               System.out.println("\nInvalid menu choice.\nPlease try again");
               break;
         }
      } 
      //aske user the Pokemon's name
      System.out.println("Does the Pokemon have a name? Y/N");
      sTemp = reader.nextLine();
      /**unless user enter "Y" or "y" something like that,
      the program will assume that users do not want do it*/
      if (sTemp.equals("y") || sTemp.equals("Y")) {
         System.out.println("What is the Pokemon's name?");
         name = reader.nextLine();
      } else {
         name = "";
      }
       
      if (name != "") {
         p.setName(name);
         return p;
      } else {
         return p;
      }
      
   } //close makePokemon

} //close InteractivePokemonGame class