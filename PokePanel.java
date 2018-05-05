import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
* Panel for PokeFrame GUI.
* @author Yuhan Jiang
* @since 4/30/2018
*/

public class PokePanel extends JPanel {
   
   /** the number of all available pokemon. */
   private static final int AVAILABLE_POKEMON = 13;
   /** show appeared pokemon info. */
   private TextArea wildPokemon = new TextArea("");
   /** show appeared pokemon info. */
   private TextArea pokedex = new TextArea("");
   /** temp pokemon. */
   private Pokemon tp = null;
   /** text for appeared pokemon. */
   private String textarea = "";
   /** text for pokedex part. */
   private String pokedexArea = "";
   /** hunt botton. */
   private JButton b1 = new JButton(" Hunt ");
   /** catch botton. */
   private JButton b2 = new JButton(" Catch ");
   /** Pokedex botton. */
   private JButton b3 = new JButton(" Pokedex ");
   /** BackPack botton. */
   private JButton b4 = new JButton(" Backpack ");   
   /** Random number generator. */
   private Random rGen = new Random();
   /** binary search tree */
   private PokeTree poketree = new PokeTree();
   /** top panel.*/
   private JPanel top = new JPanel();
   /** bottom panel. */
   private JPanel bot = new JPanel();
   
   private PriorityQueue<Pokemon> pokepq = new PriorityQueue<>();
   
   private PriorityQueue<Pokemon> temppq = new PriorityQueue<>();
   
   private Deque<Pokemon> pokestack = new ArrayDeque<>();
   
   private Deque<Pokemon> tempstack = new ArrayDeque<>();
   
   public JPopupMenu popup;
   

   /**
   * PokePanel.
   */
   public PokePanel() {
     
      setPreferredSize(new Dimension(600, 800));
      addTopPanel();      
      addBottomPanel();
   
   }
   
   
   private void addTopPanel() {
      
      top.setPreferredSize(new Dimension(500, 400));
      top.add(new JLabel(" Catch A Pokemon: "));
      top.add(wildPokemon);
      b1.addActionListener(new PokeListener());
      b2.addActionListener(new PokeListener());
      b2.setEnabled(false);
      top.add(b1);
      top.add(b2);
      add(top);  
      
   }
   
   
   
   
   private void addBottomPanel() {
      
      bot.setPreferredSize(new Dimension(500, 400));
      b3.addActionListener(new PokeListener());
      b4.addActionListener(new PokeListener());
      bot.add(b3);
      bot.add(b4);
      bot.add(pokedex);
      add(bot);  
   }
   
   private void addPopUpMenu() {
      
      popup.add(item = new JMenuItem("PQ"));
      item.setHorizontalTextPosition(JMenuItem.RIGHT);
      item.addActionListener(menuListener);
   
   }   
   
   
   /**
   * show a wild pokemon in the textarea.
   * triggered by botton "Hunt"
   */
   public void hunt() {
      wildPokemon.setText("");
      textarea = "";
      tp = choosePokemonToAppear();    
      textarea += "A wild Pokemon appeared!\n\n";
      textarea += tp.toString() + "\n\n";
      wildPokemon.setText(textarea);
      b2.setEnabled(true);
   
   }
   
   /**
   * show a wild pokemon in the textarea.
   * triggered by botton "Hunt"
   */
   public void catchpoke() {
      
           
      
      double result = rGen.nextDouble();
   
      textarea += "Attempt to catch the Pokemon.\n";
      if (result > 0.5) { //chance of catching is 50%
         textarea += "Caught " + tp.getName() + "!\n";
      } else {
         textarea += tp.getName() + " escaped!\n";
      }
       
      b2.setEnabled(false);
   
      wildPokemon.setText(textarea);
      poketree.add(tp);
      pokepq.add(tp);
   
   
   }
   
   private void showPokedex() {
      
      
      pokedexArea = poketree.toString();
      pokedex.setText(pokedexArea);
      
   }
   
   private void showPokepq() {
      String s = "";
           
      while (pokepq.size() > 0) {
         Pokemon curr = pokepq.poll();
         s += curr.toString() + "\n\n";
         temppq.add(curr);       
      }
      
      while (temppq.size() > 0) {
         Pokemon curr = temppq.poll();
         s += curr.toString() + "\n\n";  
         pokepq.add(curr);     
      }
      
      
      pokedex.setText(s);
   
   }
   
   
   private void showPokestack() {
      String s = "";
           
      while (pokestack.size() > 0) {
         Pokemon curr = pokestack.pop();
         s += curr.toString() + "\n\n";
         tempstack.add(curr);       
      }
      
      while (temppq.size() > 0) {
         Pokemon curr = tempstack.pop();
         s += curr.toString() + "\n\n";  
         pokestack.add(curr);     
      }
      
      
      pokedex.setText(s);
   
   }
   /** 
   * Randomly generate a pokemon to appear. 
   * @return the generated pokemon.
   */  
   public Pokemon choosePokemonToAppear() {
      
   
      Pokemon p;
   
      int index = rGen.nextInt(AVAILABLE_POKEMON) + 1;    
         
                
      switch (index) {
               
         case 1 :            
            p = new Bulbasaur();            
            return p;
         
         case 2 :       
            p = new Ivysaur();            
            return p; 
                         
         case 3 :          
            p = new Venusaur();          
            return p; 
                     
         case 4 :            
            p = new Charmander();            
            return p;
         
         case 5 :           
            p = new Charmeleon();            
            return p;
         
         case 6 :           
            p = new Charizard();            
            return p;
         
         case 7 :           
            p = new Squirtle();             
            return p;
         
         case 8 :
            p = new Wartortle();             
            return p;
         
         case 9 :            
            p = new Blastoise();            
            return p;
         
         case 10 :           
            p = new Eevee();              
            return p;
         
         case 11 :           
            p = new Vaporeon();              
            return p;
         
         case 12 :
            p = new Jolteon();             
            return p;
         
         case 13 :           
            p = new Flareon();              
            return p; 
                                      
         default :               
            throw new PokemonException("Oops. Something goes wrong.");
      } 
   }
   
   /** GUIListenner. */
   public class PokeListener implements ActionListener {
      
      /** GUIListenner. */
      public void actionPerformed(ActionEvent event) {
         
         if (event.getSource() == b1) {
            hunt();
         }
         if (event.getSource() == b2) {
            catchpoke();         
         }
         if (event.getSource() == b3) {
            showPokedex();
         }
         if (event.getSource() == b4) {
            showPokepq();
         }
      
      } 
   }

}