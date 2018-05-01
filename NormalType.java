/**
* interface for Normal type Pokemon.
* @author Yuhan Jiang
* @since 2/18/2018
*/
public interface NormalType {
   /** constants **/
   /** Type name String. */
   String NORMAL_TYPE = new String("Normal");
   /** Type color String. */
   String NORMAL_COLOR = new String("Fawn");
   /** Array of type fast attack names. */
   String[] NORMAL_FAST_ATTACKS = {"Tackle", "Quick Attack"};
   /** Array of type special attack names. */
   String[] NORMAL_SPECIAL_ATTACKS = {"Body Slam", "Swift", "Dig"};
   /** Array of fast attack powers, coincides with name array. */
   int[] NORMAL_FAST_ATK_POWER = {12, 12}; 
   /** Array of special attack powers, coincides with name array. */     
   int[] NORMAL_SPECIAL_ATK_POWER = {32, 26, 21};

}