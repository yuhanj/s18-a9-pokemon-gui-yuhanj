import java.util.Random;
/**
* Jolteon Pokemon object class.
* Single-type Electric implements Electric type interface
* Parent class to Eevee
* @author Yuhan Jiang
* @version 1.0
* @since 2/18/2017
*/
public class Jolteon extends Eevee implements ElectricType {

   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 232;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 201;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 130;
      
   /**
   * Constructor with no name.
   * uses Pokemon superclass constructor
   * attacks must be set after contruction of Pokemon Object
   * because of dependence on type interface
   */
   public Jolteon() {
      super("Jolteon", "Jolteon", 135, ELECTRIC_COLOR, 0.8, 24.5, 
         ELECTRIC_TYPE, BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER); 
      //pick Attacks after construct
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /**
   * Constructor with no name.
   * uses Pokemon superclass constructor
   * attacks must be set after contruction of Pokemon Object
   * because of dependence on type interface
   * @param name The user-defined name.
   */
   public Jolteon(String name) {
      super("Jolteon", name, 135, ELECTRIC_COLOR, 0.8, 24.5, 
         ELECTRIC_TYPE, BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER); 
      //pick Attacks after construct
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
    
   /**
   * Randomly picks an attack from type interface attack arrays.
   */
   @Override
   protected void chooseFastAttack() {
      
      Random randGen = new Random();
      int index;
       
      index = randGen.nextInt(ELECTRIC_FAST_ATTACKS.length);
      fastAttack = ELECTRIC_FAST_ATTACKS[index];
      fastAttackPower = ELECTRIC_FAST_ATK_POWER[index];
   
   }
   
   /**
   * Randomly picks an attack from type interface attack arrays.
   */
   @Override
   protected void chooseSpecialAttack() {
   
      Random randGen = new Random();
      int index;
   
      
      index = randGen.nextInt(ELECTRIC_SPECIAL_ATTACKS.length);
      specialAttack = ELECTRIC_SPECIAL_ATTACKS[index];
      specialAttackPower = ELECTRIC_SPECIAL_ATK_POWER[index];
   
      
   }
   
   /**
   * Game-play fast attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * Calls beAttacked method on attacked victim.
   * @param victim the Pokemon being attacked
   * @return String explaining attack and effectiveness
   */
   @Override
   public String performFastAttack(Pokemon victim) {
      

      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;      
      s = name + " performed " + fastAttack + " on " + victim.getName();
      //check effectiveness of attack
      if (vType.equals("Water") || vType.equals("Flying")) {            
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;          
      } else if (vType.equals("Electric") || vType.equals("Dragon") 
             || vType.equals("Grass")) { 
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      } else if (vType.equals("Ground")) {
         s = s + "\n It had no effect.";
         modifier = 0;
      }
   
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;      
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
//       if (victim.getHP() == 0) {
//          s = s + "\n" + victim.getName() + " fainted!";
//       }
      return s;
   }
   
   //copy paste from bulbasaur
   /**
   * Game-play special attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * uses Damage formula from here: 
   * http://bulbapedia.bulbagarden.net/wiki/Damage
   * Calls beAttacked method on attacked victim.
   * @param victim the Pokemon being attacked.
   * @return String explaining attack and effectiveness.
   */
   @Override
   public String performSpecialAttack(Pokemon victim) {

      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getName();
      
      //check effectiveness of attack
      if (vType.equals("Water") || vType.equals("Flying")) {            
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;          
      } else if (vType.equals("Electric") || vType.equals("Dragon") 
             || vType.equals("Grass")) { 
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      } else if (vType.equals("Ground")) {
         s = s + "\n It had no effect.";
         modifier = 0;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
          * attackPower * (specialAttackPower + 2) * modifier;
     
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
//       if (victim.getHP() == 0) {
//          s = s + "\n" + victim.getName() + " fainted!";
//       }
      return s;
   }
   /**
   * Reduces Pokemon's HP by damage/defensePower.
   * Doesn't allow HP to go less than 0
   * Implementation of "fainting" not done here
   * @param damage Hit points to take off HP
   */
   protected void beAttacked(int damage) {
      //part of bulbapedia damage formula
      damage = damage / defensePower;
      
      if (hP > damage) {
         hP = hP - damage;
      } else {
         hP = 0; //"Pokemon fainted"
      }
      
   }  
     
}