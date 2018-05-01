/**
* PokeTreee.
* @author Yuhan Jiang
* @since 4/9/18
*/

public class PokeTree {
   
   /** the root of the tree.*/
   private PokeNode root = null;
   
   /** Empty constructor. */
   public PokeTree() {
   
   }
   
   /**
   * wrapper add method.
   * @param poke the added pokemon.
   */
   public void add(Pokemon poke) {
      root = add(root, poke);
      System.out.println("\nA "+ poke.getSpecies() +" has been added!\n");
   }
   
   
   /**
   * Recursively add new pokemon to the node.
   * @param node The root of the tree or subtree
   * @param poke the added pokemon
   * @return a new rode with new pokemon added
   */
   private PokeNode add(PokeNode node, Pokemon poke) {
      if (node == null) {
         return new PokeNode(poke, 1, null, null);
      } else if (poke.getNumber() == node.getKey()) {
         node.increaseNumCaught();
      } else if (poke.getNumber() < node.getKey()) {
         node.setLChild(this.add(node.getLChild(), poke));
      } else if (poke.getNumber() > node.getKey()) {
         node.setRChild(this.add(node.getRChild(), poke));
      }
      return node;
   }
   

   
   /**
   * Removes a pokemon from the tree. Non-recursive wrapper method.
   * @param poke the selected pokemon to remove.
   */
   public void remove(Pokemon poke) {
      root = this.remove(root, poke);
   }
   
   /**
   * Recursively removes an pokemon from the tree.   
   * if numCaught is greater than 2 , only the numCaught will be decreased by 1.
   * @param node The root of the tree/subtree
   * @param poke the selected pokemon to remove.
   * @return root of current subtree.
   * @throws PokemonException if the selected pokemon not found in tree.
   * From BinarySearchTree.java
   */
   private PokeNode remove(PokeNode node, Pokemon poke) {
      
      // if item not found, throw exception
      if (node == null) {
         throw new PokemonException("You don't have this Pokemon!");
      }
      // if search key is less than node's search key,
      // continue to left subtree
      else if (poke.getNumber() < node.getKey()) {
         node.setLChild(this.remove(node.getLChild(), poke));
         return node;
      }
      // if search key is greater than node's search key,
      // continue to right subtree
      else if (poke.getNumber() > node.getKey()) {
         node.setRChild(this.remove(node.getRChild(), poke));
         return node;
      }
      // found node containing object with same search key,
      // if the number of caught is greater than or equal to two
      // only the number of caught will be decreased
      // otherwise, the node will be deleted
      else {
         if (node.getNumCaught() >= 2) {
            node.decreaseNumCaught();
         } else {
            // call private method remove
            node = this.remove(node);         
         }
         return node;
      }
   }
   
   /**
   * Helper method that takes a node out of tree.
   * 
   * @param node The node to remove
   * @return The node that replaces removed node or null.
   * From BinarySearchTree.java
   */
   private PokeNode remove(PokeNode node) {
   // if node is a leaf,return null
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      }
      // if node has a single right child node,
      // then return a reference to the right child node
      else if (node.getLChild() == null) {
         return node.getRChild();
      }
      // if node has a single left child node,
      // then return a reference to the left child node
      else if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if the node has two child nodes
      else {
      // get next node with smaller key, which is Largest Item in Left Subtree
      // The next Smaller Item is stored at the rightmost node in the left
      // subtree.
         PokeNode largestNodeInLeftSubtree = this.
               getNodeWithLargestSearchKey(node.getLChild());
      // replace the node's item with this item
         node.setPokemon(largestNodeInLeftSubtree.getPokemon());
         node.setNumCaught(largestNodeInLeftSubtree.getNumCaught());
      // delete the rightmost node in the left subtree
         node.setLChild(this.removeNodeWithLargestSearchKey(node
             .getLChild()));
         return node;
      }
   }

  /**
   * Returns the item with the largest search key in the (sub)tree.
   * Helper method for removing interior nodes.
   * @param node The root of the tree/subtree
   * @return the node with largest key
   */
   private PokeNode getNodeWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
      if (node.getRChild() == null) {
         return node;
      }
      // if not, keep looking on the right
      else {
         return this.getNodeWithLargestSearchKey(node.getRChild());
      }
   }

  /**
   * Removes the node with the largest search key.
   * Helper method for removing interior nodes.
   * Remove the node formerly occupied by item with largest search key.
   * To be called after item is moved to new node location.
   * 
   * @param node The root of the tree/subtree
   * @return root of (sub)tree with node removed.
   * From BinarySearchTree.java
   */
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
   // so replace it with its left child
      if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if not, keep looking on the right
      else {
         node.setRChild(this.removeNodeWithLargestSearchKey(node
             .getRChild()));
         return node;
      }
   }
   
   
   
   
   
   
   
   
   /**
   * wrapper print method that calls private inorderPokeTree method.
   */
   public void printPokeTree() {
      inorderPokeTree(root);
   }
   
   /**
   * recursive method that prints the PokeTree in order. 
   * @param node the root of tree/subtree
   */
   private void inorderPokeTree(PokeNode node) {
      if (node != null) {       
         inorderPokeTree(node.getLChild());
         System.out.println(node.getPokemon().toString() 
               + "\nCaught: " + node.getNumCaught() + "\n\n"); 
         inorderPokeTree(node.getRChild());
      }
   }
   
   /** 
   * see if the tree is empty.
   * this method is for printing in the driver class.
   * @return true or false
   */
   public boolean isEmpty() {
      return (root == null);   
   }
   

}