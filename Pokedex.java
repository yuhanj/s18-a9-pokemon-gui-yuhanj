import java.util.Scanner;

/**
* Pokedex the driver class.
* @author Yuhan Jiang
* @since 4/11/18
*/

public class Pokedex {


   /**
   * main method.
   * @param args not used
   */
   public static void main(String [] args) {
      
      boolean end = false;
      Scanner reader = new Scanner(System.in);
      String userOrder = "";
      PokeTree poketree = new PokeTree();
      Pokemon temp = null;
      
      while (!end) {
      
         System.out.println("\n\nWhat do you want to do?\n"
               + "\n1. Catch a Pokemon"
               + "\n2. Trade a Pokemon"
               + "\n3. Print Pokemon"
               + "\n0. Exit\n");
               
         userOrder = reader.nextLine().trim();
         
         switch(userOrder) {
         
            case "1" :
               
               temp = choosePokemon();
               if (temp == null) {
                  System.out.println("Adding cancelled.");
                  break;
               }
               poketree.add(temp);
               break;
               
            
            case "2" :
               
               if (poketree.isEmpty()) {
                  System.out.println("You don't have any pokemon!");
               } else {
                  temp = choosePokemonToTrade();
                  if (temp == null) {
                     System.out.println("Trading cancelled.");
                     break;
                  }
                  try {
                     poketree.remove(temp);
                     System.out.println("\nA " + temp.getSpecies()
                           + " has been traded!\n");
                  } catch (Exception e) {
                     System.out.println("You do not have " 
                           + temp.getSpecies() + "!\n");
                  }
               }
               break;            
               
            
            case "3" :
               if (poketree.isEmpty()) {
                  System.out.println("You don't have any pokemon!");
               } else {
                  System.out.println("\nYou have : \n");
                  poketree.printPokeTree();
               }
               break;
               
            
            case "0" :
               
               System.out.println("\nGoodbye!\n");
               end = true;
               break;          
               
            
            default :  
            
               System.out.println("You did not enter a valid number."
                     + " Please try again.");
         
         }
         
      }
   
   }
   
   /** 
   * Let user choose a pokemon. 
   * @return user-made pokemon.
   */  
   public static Pokemon choosePokemon() {
      
      Scanner reader = new Scanner(System.in);
      String temp = "";
      String inputIndex = "";
      String inputName = "";
      int split = -100;
      boolean end = true;
      Pokemon p;
      
   
      do {
      
         System.out.println("\nWhich pokemon do you want? "
               + "\nYou can set a name after enter the case number and a space."
               + "\nFor example, \"4 Sammy\" will"
               + " be a Charmander called \"Sammy\".\n"
               + "\nYou can press 0 to check pokedex.\n");
      
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
               s += "\n133. Eevee";
               s += "\n134. Vaporeon";
               s += "\n135. Jolteon";
               s += "\n136. Flareon";
               s += "\n000. Back to main menu\n";
               
               
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
         
            case "133" :
            
               if (inputName.length() == 0) {
                  p = new Eevee();
               } else {
                  p = new Eevee(inputName);
               }
               
               return p;
         
            case "134" :
            
               if (inputName.length() == 0) {
                  p = new Vaporeon();
               } else {
                  p = new Vaporeon(inputName);
               }
               
               return p;
         
            case "135" :
            
               if (inputName.length() == 0) {
                  p = new Jolteon();
               } else {
                  p = new Jolteon(inputName);
               }
               
               return p;
         
            case "136" :
            
               if (inputName.length() == 0) {
                  p = new Flareon();
               } else {
                  p = new Flareon(inputName);
               }
               
               return p; 
            
            case "000" :
            
               return null;   
                                      
            default :
               
               System.out.println("The index is not in the list. Try again.");
               end = false;
         } 
      } while (!end);     
   
      Pokemon stupid = new Bulbasaur("Dumb Compiler");
      return stupid;
   }
   
   /** 
   * Let user choose a pokemon to trade. 
   * @return the selected pokemon.
   */  
   public static Pokemon choosePokemonToTrade() {
      
      Scanner reader = new Scanner(System.in);
      String inputIndex = "";
      boolean end = true;
      Pokemon p;
         
      do {
      
         System.out.println("\nWhich pokemon do you want to trade? "
               + "\n Please enter the pokemon species number."
               + "\nYou can press 0 to check the species number.\n");
      
         inputIndex = reader.nextLine().trim();
         
         
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
               s += "\n133. Eevee";
               s += "\n134. Vaporeon";
               s += "\n135. Jolteon";
               s += "\n136. Flareon";
               s += "\n000. Back to main menu\n";
               
               
               System.out.println(s);
               
               end = false;
               break;
               
            case "1" :
            
               p = new Bulbasaur();
            
               return p;
         
            case "2" :
            
               
               p = new Ivysaur();
            
               return p; 
                         
            case "3" :
            
               
               p = new Venusaur();
            
               
               return p; 
                     
            case "4" :
            
               p = new Charmander();
            
               return p;
         
            case "5" :
            
               
               p = new Charmeleon();
            
               return p;
         
            case "6" :
            
               
               p = new Charizard();
            
               return p;
         
            case "7" :
            
               
               p = new Squirtle();
             
               
               return p;
         
            case "8" :
            
               
               p = new Wartortle();
              
               
               return p;
         
            case "9" :
            
               p = new Blastoise();
            
               
               return p;
         
            case "133" :
            
               
               p = new Eevee();
               
               
               return p;
         
            case "134" :
            
               
               p = new Vaporeon();
               
               
               return p;
         
            case "135" :
            
              
               p = new Jolteon();
             
               return p;
         
            case "136" :
            
              
               p = new Flareon();
              
               return p; 
            
            case "000" :
            
               return null;
                                      
            default :
               
               System.out.println("The index is not in the list. Try again.");
               end = false;
         } 
      } while (!end);     
   
      Pokemon stupid = new Bulbasaur("Dumb Compiler");
      return stupid;
   }

   
}