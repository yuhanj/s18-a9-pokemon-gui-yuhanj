import javax.swing.JFrame;

/**
* Pokemon GUI frame.
* @author Yuhan Jiang
* @since 4/30/2018
*/

public class PokeFrame {

   /** main method.
   * @param args not used
   */
   public static void main(String[ ] args) {
      //setup basic JFrame
        
      JFrame frm = new JFrame("Pokemon Gone");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      frm.getContentPane().add(new PokePanel());
      
      frm.pack();
      frm.setVisible(true);
      
   }
   
   
}