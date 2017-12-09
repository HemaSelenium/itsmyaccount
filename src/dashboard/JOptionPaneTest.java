package dashboard;

import javax.swing.JOptionPane;

public class JOptionPaneTest {
	public static void main(String[] args){
      // JOptionPane does not have to run under a Swing Application (extends JFrame).
      // It can run directly under main().
      String inStr = JOptionPane.showInputDialog(null, "Ask for user input (returns a String)",
            "Input Dialog", JOptionPane.PLAIN_MESSAGE);
      System.out.println("You have entered " + inStr);
      JOptionPane.showMessageDialog(null, "Display a message (returns void)!",
            "Message Dialog", JOptionPane.PLAIN_MESSAGE);
      int answer = JOptionPane.showConfirmDialog(null, "Ask for confirmation (returns an int)",
            "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
      
      switch (answer) {
         case JOptionPane.YES_OPTION:
            System.out.println("You clicked YES"); break;
         case JOptionPane.NO_OPTION:
            System.out.println("You clicked NO"); break;
         case JOptionPane.CANCEL_OPTION:
            System.out.println("You clicked Cancel"); break;
      }
   }
}