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
   private TextArea wildPokemon = new TextArea("", 10, 40, TextArea.SCROLLBARS_NONE);
   /** show appeared pokemon info. */
   private TextArea pokedex = new TextArea("");
   /** temp pokemon. */
   private Pokemon tp = null;
   /** text for appeared pokemon. */
   private String textarea = "";
   /** text for pokedex part. */
   private String pokedexArea = "";
   /** image of bag. */
   private ImageIcon bagIcon = new ImageIcon("backpack.png");
   /** image of pokedex. */
   private ImageIcon dexIcon = new ImageIcon("smartphone.png");
   private ImageIcon poke001 = new ImageIcon("001.png");
   private ImageIcon poke002 = new ImageIcon("002.png");
   private ImageIcon poke003 = new ImageIcon("003.png");
   private ImageIcon poke004 = new ImageIcon("004.png");
   private ImageIcon poke005 = new ImageIcon("005.png");
   private ImageIcon poke006 = new ImageIcon("006.png");
   private ImageIcon poke007 = new ImageIcon("007.png");
   private ImageIcon poke008 = new ImageIcon("008.png");
   private ImageIcon poke009 = new ImageIcon("009.png");
   private ImageIcon poke133 = new ImageIcon("133.png");
   private ImageIcon poke134 = new ImageIcon("134.png");
   private ImageIcon poke135 = new ImageIcon("135.png");
   private ImageIcon poke136 = new ImageIcon("136.png");

   
   private JLabel pokeImage = new JLabel(poke001);
   /** hunt botton. */
   private JButton b1 = new JButton(" Hunt ");
   /** catch botton. */
   private JButton b2 = new JButton(" Catch ");
   /** Pokedex botton. */
   private JButton b3 = new JButton(dexIcon);
   /** BackPack botton. */
   private JButton b4 = new JButton(bagIcon);   
   /** Random number generator. */
   private Random rGen = new Random();
   /** binary search tree. */
   private PokeTree poketree = new PokeTree();
   /** top panel.*/
   private JPanel top = new JPanel();
   /** topleft panel.*/
   private JPanel topleft = new JPanel();
   /** topright panel.*/
   private JPanel topright = new JPanel();
   /** top panel.*/
   private JPanel mid = new JPanel();
   /** bottom panel. */
   private JPanel bot = new JPanel();
   /** pokemon priority queue. */
   private PriorityQueue<Pokemon> pokepq = new PriorityQueue<>();
   /** temporary priority queue. */
   private PriorityQueue<Pokemon> temppq = new PriorityQueue<>();
   /** pokemon stack. */
   private Deque<Pokemon> pokestack = new ArrayDeque<>();
   /** temporary stack. */
   private Deque<Pokemon> tempstack = new ArrayDeque<>();
   

   

   /**
   * PokePanel.
   */
   public PokePanel() {
     
      setPreferredSize(new Dimension(800, 750));
      addTopPanel(); 
      addMidPanel();     
      addBottomPanel();
   
   }
   
   /** add top panel to main panel. */
   private void addTopPanel() {
      top.setPreferredSize(new Dimension(900, 230));
      topleft.setPreferredSize(new Dimension(550, 230));
      topright.setPreferredSize(new Dimension(230, 230));
            
      wildPokemon.setEditable(false);
      topleft.add(wildPokemon);
      b1.addActionListener(new PokeListener());
      b2.addActionListener(new PokeListener());
      b2.setEnabled(false);
      topleft.add(b1);
      topleft.add(b2);
      top.add(topleft);
      topright.add(pokeImage);
      top.add(topright);

      add(top);  
      
   }
   
   
   
   private void addMidPanel() {
   
      mid.setPreferredSize(new Dimension(600, 100));
      b3.addActionListener(new PokeListener());
      b4.addActionListener(new PokeListener());
      mid.add(b3);
      mid.add(b4);
      add(mid);
   }
   /** add bottom panel to main panel. */
   private void addBottomPanel() {
            
      bot.setPreferredSize(new Dimension(800, 300));      
      pokedex.setPreferredSize(new Dimension(600, 300));
      pokedex.setEditable(false);
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
      
      changeImage(tp);
   }
   
   public void changeImage(Pokemon p) {
      try {
         switch(p.getNumber()) {
            case 1:
               pokeImage.setIcon(poke001);
               break;
            case 2:
               pokeImage.setIcon(poke002);
               break;
            case 3:
               pokeImage.setIcon(poke003);
               break;
            case 4:
               pokeImage.setIcon(poke004);
               break; 
            case 5:
               pokeImage.setIcon(poke005);
               break;
            case 6:
               pokeImage.setIcon(poke006);
               break;
            case 7:
               pokeImage.setIcon(poke007);
               break;
            case 8:
               pokeImage.setIcon(poke008);
               break;   
            case 9:
               pokeImage.setIcon(poke009);
               break;
            case 133:
               pokeImage.setIcon(poke133);
               break;
            case 134:
               pokeImage.setIcon(poke134);
               break;
            case 135:
               pokeImage.setIcon(poke135);
               break;  
            case 136:
               pokeImage.setIcon(poke136);
               break;                                      
         }
      } catch(Exception e) {}
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
      pokestack.push(tp);
   
   
   }
   
   /** show pokedex.*/
   private void showPokedex() {
      
      
      pokedexArea = poketree.toString();
      pokedex.setText(pokedexArea);
      
   }
   /** show pokepq.*/
   private void showPokepq() {
      String s = "";
           
      while (pokepq.size() > 0) {
         Pokemon curr = pokepq.poll();
         s += curr.toString() + "\n\n";
         temppq.add(curr);       
      }
      
      while (temppq.size() > 0) {
         Pokemon curr = temppq.poll();  
         pokepq.add(curr);     
      }
      
      
      pokedex.setText(s);
   
   }
   
   /** show pokestack.*/
   private void showPokestack() {
      String s = "";
           
      while (pokestack.size() > 0) {
         Pokemon curr = pokestack.pop();
         s += curr.toString() + "\n\n";
         tempstack.push(curr);       
      }
      
      while (tempstack.size() > 0) {
         Pokemon curr = tempstack.pop(); 
         pokestack.push(curr);     
      }
      
      
      pokedex.setText(s);
   
   }
   
   /** sorting popup menu. */
   private void chooseSorting() {
      String[] choices = { "Recent", "Number"};
      String input = "";
      try {
         input = (String) JOptionPane.showInputDialog(null, " How to sort? ",
               "The Choice of Sorting", JOptionPane.QUESTION_MESSAGE,
               null, choices, choices[0]); 
         switch(input) {
            case "Recent": 
               showPokestack();
               break;
            case "Number":
               showPokepq();
               break;
            default:
               throw new PokemonException("Invalid");
            
         }
      } catch (Exception e) { }     
   
      
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
      
      /** 
      * GUIListenner. 
      * @param event userinput.
      */
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
            chooseSorting();
         }
      
      } 
   }

}