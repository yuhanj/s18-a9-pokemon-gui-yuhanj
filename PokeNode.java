/**
* PokeNode.
* @author Yuhan Jiang
* @since 4/9/18
*/

public class PokeNode {
   
   /** First data hold in node.*/
   private Pokemon poke;
   /** Second data hold in node.*/
   private int numCaught = 1;
   /** The species number of pokemon. Used to set the order.*/
   private int key = -1;
   /** the left child.*/
   private PokeNode lChild;
   /** the right child.*/
   private PokeNode rChild;
   
   /**
   * Constructor.
   * @param poke the stored pokemon in the node
   * @param numCaught counter of pokemon
   * @param lChild pointer to the left child
   * @param rChild pointer to the right child
   */
   public PokeNode(Pokemon poke, int numCaught,
         PokeNode lChild, PokeNode rChild) {
   
      this.poke = poke;
      this.lChild = lChild;
      this.rChild = rChild;
      this.numCaught = numCaught;
      this.key = poke.getNumber();
   
   }
   
   /**
   * get the pokemon in the node.
   * @return the pokemon in the node
   */
   public Pokemon getPokemon() {
      return poke;
   }
   
   /**
   * get the species number of the pokemon in the node. 
   * @return the species number
   */
   public int getKey() {   
      return this.poke.getNumber();
   }
   
   /**
   * get the left child.
   * @return the left child
   */
   public PokeNode getLChild() {
      return lChild;
   }
   
   /**
   * get the right child.
   * @return the right child
   */   
   public PokeNode getRChild() {
      return rChild;
   }
   
   /**
   * get the number of caught pokemon.
   * @return the number of this pokemon
   */
   public int getNumCaught() {
      return numCaught;
   }
   
   /**
   * increase the number of caught pokemon.
   */
   public void increaseNumCaught() {
      this.numCaught++; 
   }
   
   /**
   * decrease the number of caught pokemon.
   * @throws PokemonException if the number will become 0 or less
   */
   public void decreaseNumCaught() throws PokemonException {
      this.numCaught--;
      if (this.numCaught < 1) {
         throw new PokemonException("Key cannot be less than 1.");
      }
   }
   
   /**
   * set the left child.
   * @param newLChild the new left child connect to the node
   */
   public void setLChild(PokeNode newLChild) {
      this.lChild = newLChild;
   }
   
   /**
   * set the right child.
   * @param newRChild the new right child connect to the node
   */   
   public void setRChild(PokeNode newRChild) {
      this.rChild = newRChild;
   }
   
   
   /**
   * set method that helps remove method in PokeTree.
   * @param p the replaced pokemon to the node
   */
   public void setPokemon(Pokemon p) {
      this.poke = p;
   }
   
   /**
   * set method that helps keep the numCaught from the original node.
   * @param i the numCaught from the node which is moving to a new spot
   */
   public void setNumCaught(int i) {
      this.numCaught = i;
   }
   
   
}