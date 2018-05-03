import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/**
* Panel for PokeFrame GUI.
* @author Yuhan Jiang
* @since 4/30/2018
*/

public class PokePanel extends JPanel {
   
   /** the number of all available pokemon. */
   public static final int AVAILABLE_POKEMON = 13;
   /** show appeared pokemon info. */
   public TextArea wildPokemon = new TextArea("");
   /** show appeared pokemon info. */
   public TextArea pokedex = new TextArea("");
   /** temp pokemon. */
   public Pokemon tp = null;
   /** text for appeared pokemon. */
   public String textarea = "";
   /** text for pokedex part. */
   public String pokedexArea = "";
   /** hunt botton. */
   public JButton b1 = new JButton(" Hunt ");
   /** catch botton. */
   public JButton b2 = new JButton(" Catch ");
   /** Pokedex botton. */
   public JButton b3 = new JButton(" Pokedex ");
   /** BackPack botton. */
   public JButton b4 = new JButton(" Backpack ");   
   /** Random number generator. */
   public Random rGen = new Random();
   /** binary search tree */
   private PokeTree poketree = new PokeTree();
   private JPanel top = new JPanel();
   private JPanel bot = new JPanel();

   

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
      bot.add(b3);
      bot.add(b4);
      bot.add(pokedex);
      add(bot);  
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
      if (result > 0.5) {
         textarea += "Caught " + tp.getName() + "!\n";
      } else {
         textarea += tp.getName() + " escaped!\n";
      }
       
      b2.setEnabled(false);
   
      wildPokemon.setText(textarea);
      poketree.add(tp);
   
   
   }
   
   public void showPokedex() {
      
      
      pokedexArea = poketree.toString();
      pokedex.setText(pokedexArea);
      
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
      
      } 
   }

}