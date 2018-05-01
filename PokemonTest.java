import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
* Tests for compareTo, equals, and PokemonException
*
* @author Lisa Miller
* @since 10/25/2016
*/

public class PokemonTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

  /**
  * test compareTo method
  */
   @Test public void compareBulbasaurToVenusaurTest() {
      Pokemon p = new Bulbasaur();
      Pokemon p4 = new Venusaur();
      int diff = p.compareTo(p4);
      Assert.assertTrue("Bulbasaur compares less than Venusaur", diff < 0);
   }
   
   @Test public void compareBulbasaurToBlastoiseTest() {
      Pokemon p = new Bulbasaur();
      Pokemon p4 = new Blastoise();
      int diff = p.compareTo(p4);
      Assert.assertTrue("Bulbasaur compares less than Blastoise", diff < 0);
   }
   
   @Test public void compareBulbasaurToNamedBulbasaurTest() {
      Pokemon p = new Bulbasaur();
      Pokemon p2 = new Bulbasaur("Bob");
      int diff = p.compareTo(p2);
      Assert.assertTrue("Bulbasaur compares greater than Bulbasaur \"Bob\"", diff > 0);
   }
   
      @Test public void compareSquirtleToBlastoiseTest() {
      Pokemon p = new Squirtle();
      Pokemon p4 = new Blastoise();
      int diff = p.compareTo(p4);
      Assert.assertTrue("Squirtle compares less than Blastoise", diff < 0);
   }
   
   @Test public void compareSquirtleToBulbasaurTest() {
      Pokemon p = new Squirtle();
      Pokemon p4 = new Bulbasaur();
      int diff = p.compareTo(p4);
      Assert.assertTrue("Squirtle compares greater than Bulbasaur", diff > 0);
   }
   
   @Test public void compareCharmanderToVenusaurTest() {
      Pokemon p = new Charmander();
      Pokemon p4 = new Venusaur();
      int diff = p.compareTo(p4);
      Assert.assertTrue("Charmander compares greater than Venusaur", diff > 0);
   }
   /**
   * test .equals method
   */    
   @Test public void nonEqualityBulbasaurVenusaurTest() {
      Pokemon p = new Bulbasaur();
      Pokemon p4 = new Venusaur();
      Assert.assertFalse("Bulbasaur not equal Venusaur", p.equals(p4));

   }
     
   @Test public void nonEqualityBulbasaurNamedBulbasaurTest(){
      Pokemon p = new Bulbasaur();
      Pokemon p2 = new Bulbasaur("Bob");
      Assert.assertFalse("Bulbasaur not equal Bulbasaur \"Bob\"", p.equals(p2));
   }
   
   @Test public void nonEqualityBulbasaur1Bulbasaur2Test(){
      Pokemon p = new Bulbasaur();
      Pokemon p2 = new Bulbasaur();
      if((p.getHP() != p2.getHP()) || (p.getCP() != p2.getCP()) || (!p.getFastAttack().equals(p2.getFastAttack())) || (!p.getSpecialAttack().equals(p2.getSpecialAttack()))) {
        Assert.assertFalse("Bulbasaur not equal another Bulbasaur", p.equals(p2));
      }else{ //they are the same
        Assert.assertTrue("Bulbasaur equal another Bulbasaur with same CP and HP", p.equals(p2));
      }

   }
   
   @Test public void nonEqualityBulbasaurBlastoiseTest() {
      Pokemon p = new Bulbasaur();
      Pokemon p4 = new Blastoise();
      Assert.assertFalse("Bulbasaur not equal Blastoise", p.equals(p4));

   }
   
   @Test public void equalityBulbasaurCopyTest() {
      Pokemon p = new Bulbasaur();
      Pokemon p2 = p;
      Assert.assertTrue("Bulbasaur equal to copy of itself", p.equals(p2));

   }
   
  @Test public void nonEqualityCharizardNamedCharizardTest(){
      Pokemon p = new Charizard();
      Pokemon p2 = new Charizard("Charlie");
      Assert.assertFalse("Charizard not equal Charizard \"Charlie\"", p.equals(p2));
  }
  
  /**
  * Test PokemonException
  */
  @Test(expected=PokemonException.class)
  public void testPokemonExceptionSetName() {
    Pokemon p = new Squirtle();
    p.setName("");
  }
  
  @Test(expected=PokemonException.class)
  public void testPokemonExceptionConstructor() {
    Pokemon p = new Squirtle("");
  }
}
