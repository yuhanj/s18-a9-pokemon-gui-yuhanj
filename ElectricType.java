/**
* interface for Electric type Pokemon.
* @author Yuhan Jiang
* @since 2/18/2018
*/
public interface ElectricType {
   /** constants **/
   /** Type name String. */
   String ELECTRIC_TYPE = new String("Electric");
   /** Type color String. */
   String ELECTRIC_COLOR = new String("Yellow");
   /** Array of type fast attack names. */
   String[] ELECTRIC_FAST_ATTACKS = {"Volt Switch", "Thunder Shock"};
   /** Array of type special attack names. */
   String[] ELECTRIC_SPECIAL_ATTACKS = {"Thunder", "Thunderbolt", "Dischargee"};
   /** Array of fast attack powers, coincides with name array. */
   int[] ELECTRIC_FAST_ATK_POWER = {10, 10}; 
   /** Array of special attack powers, coincides with name array. */     
   int[] ELECTRIC_SPECIAL_ATK_POWER = {50, 38, 31};

}