//////////////////////////////////////////////////////////////////////////////////////////////////
//
// Name: Riley Faszewski
//
// Date: 8/29/2013
//
// Purpose: 
//
// Inputs:
//
// Outputs:
//
/////////////////////////////////////////////////////////////////////////////////////////////////

import javax.swing.JOptionPane;

public class PlayingCard{
   private int faceValue, suitValue;
   public static final int CLUBS = 0,
                    DIAMONDS = 1,
                    HEARTS = 2,
                    SPADES = 3,
                    TWO = 0,
                    THREE = 1,
                    FOUR = 2,
                    FIVE = 3,
                    SIX = 4,
                    SEVEN = 5,
                    EIGHT = 6,
                    NINE = 7,
                    TEN = 8,
                    JACK = 9,
                    QUEEN = 10,
                    KING = 11,
                    ACE = 12,
						  MIN_SUIT = CLUBS,
						  MAX_SUIT = SPADES,
						  MIN_CARD = TWO,
						  MAX_CARD = ACE;;
   
   private static String [] suitString = { "clubs", "Diamonds", "Hearts", "Spades"};
   private static String faceString [] = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
   public PlayingCard(int theValue, int theSuit){
      faceValue = theValue;
      suitValue = theSuit;
   }
   
   public int getFaceValue(){
      return faceValue;
   }
   
   public int getSuitValue(){
      return suitValue;
   }
   
   public String toString() {
      return faceString[faceValue] + " of " + suitString[suitValue];
   }
  
                    
                  
	
} //end the class