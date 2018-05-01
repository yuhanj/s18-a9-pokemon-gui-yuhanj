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
   private static final int AVAILABLE_POKEMON = 13;
   /** show appeared pokemon info. */
   private TextArea wildPokemon = new TextArea("");
   /** temp pokemon. */
   private Pokemon tp = null;
   /** text for appeared pokemon. */
   private String textarea = "";
   /** hunt botton. */
   private JButton b1 = new JButton(" Hunt ");
   /** catch botton. */
   private JButton b2 = new JButton(" Catch ");
   /** Random number generator. */
   private Random rGen = new Random();
   /** a marker to determine if user has tried caught. */
   private boolean tried = false;

   /**
   * PokePanel.
   */
   public PokePanel() {
   
      setPreferredSize(new Dimension(500, 500));
      add(new JLabel("To Catch A Pokemon: "));
      add(wildPokemon);
      b1.addActionListener(new PokeListener());
      b2.addActionListener(new PokeListener());
      add(b1);
      add(b2);
   
      
   }
   
   /**
   * show a wild pokemon in the textarea.
   * triggered by botton "Hunt"
   */
   public void hunt() {
      tried = false;
      wildPokemon.setText("");
      textarea = "";
      tp = choosePokemonToAppear();    
      textarea += "A wild Pokemon appeared!\n\n";
      textarea += tp.toString() + "\n\n";
      wildPokemon.setText(textarea);
   
   }
   
   /**
   * show a wild pokemon in the textarea.
   * triggered by botton "Hunt"
   */
   public void catchpoke() {
      
           
      
      double result = rGen.nextDouble();
      if (!tried) {
         textarea += "Attempt to catch the Pokemon.\n";
         if (result > 0.5) {
            textarea += "Caught " + tp.getName() + "!\n";
         } else {
            textarea += tp.getName() + " escaped!\n";
         }
      } 
      tried = true;
      wildPokemon.setText(textarea);
   
   
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
   private class PokeListener implements ActionListener {
      
      /** GUIListenner. */
      public void actionPerformed(ActionEvent event) {
         
         if (event.getSource() == b1) {
            hunt();
         }
         if (event.getSource() == b2) {
            catchpoke();         
         }
      
      } 
   }

}