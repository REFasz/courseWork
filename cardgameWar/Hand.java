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

public class Hand {

   private PlayingCard theHand[];
   private int cardCount, largestHand;
   
   public Hand(int size){
      largestHand = size;
      theHand = new PlayingCard[size];
      cardCount = 0;
   }
   
   public void addCard(PlayingCard nextCard){
      if(cardCount >= largestHand)
         return;
      theHand[cardCount] = nextCard;
      cardCount ++;
   }
   
   
		  
		  
	public int handCount(){
      return cardCount;
   }
   
   public void tossFromHand(PlayingCard tempCard){
   
   cardCount --;

   }
   
   public PlayingCard turnCard(){
   
    int index;
    PlayingCard temp;
   
      if(cardCount <= 0)
          return null;
   
      temp = theHand[0];
   
    for(index = 0; index < cardCount - 1; index ++){
      theHand[index] = theHand[index + 1];
    }
   
    theHand[cardCount - 1] = temp;
    return temp;
   
   
   
   }
   
   public void resetHand(){
   cardCount = 0;
   }
   
   
   
   
   
   
 
   
   
	
} //end the class