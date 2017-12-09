package common;

import javax.swing.JOptionPane;



public class Calling{

	public static void main(String[] args){

		
	      int answer = JOptionPane.showConfirmDialog(null, " You Want To Continue To Run The Script","Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
	      
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


