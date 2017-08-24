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

public class Deck {

  public static final int MAX_SUITS = PlayingCard.MAX_SUIT + 1,
                           MAX_VALUES = PlayingCard.MAX_CARD + 1,
                           MAX_CARDS_PER_DECK = MAX_SUITS * MAX_VALUES;
                           
  private PlayingCard cardDeck[];
  private int nextCard; //subscript of next card to deal out
 
  public Deck(){
   int nextSuit, nextFace, position;
   cardDeck = new PlayingCard[MAX_CARDS_PER_DECK];
   nextCard = 0; //Top of the deck
   position = 0;
   
   for(nextSuit = PlayingCard.MIN_SUIT; nextSuit <= PlayingCard.MAX_SUIT; nextSuit ++){
      for(nextFace = PlayingCard.MIN_CARD; nextFace <= PlayingCard.MAX_CARD; nextFace ++){
         cardDeck[position] = new PlayingCard(nextFace, nextSuit);
         position ++;
      }
   }
   
  }
  
  public PlayingCard getNextCard() {
   PlayingCard temp;
   if(nextCard == MAX_CARDS_PER_DECK){
      return null;
   }
   temp = cardDeck[nextCard];
   nextCard ++;
   return temp;
  }
  
  public void shuffle(){
  int index,
  		randomSpot;
  double tempValue;
  PlayingCard temp;
  
  
  
   for(index = 0; index < MAX_CARDS_PER_DECK - 1; index ++){
    tempValue = Math.random();
    randomSpot = (int)(tempValue * (MAX_CARDS_PER_DECK -index) + index);
    if(randomSpot < 0 || randomSpot >= MAX_CARDS_PER_DECK)
	 System.out.println("Error " + randomSpot + "is invalid");
	 
      temp = cardDeck[index];
      cardDeck[index] = cardDeck[randomSpot];
      cardDeck[randomSpot] = temp;
   }
  nextCard = 0;
  }  
  
  
  
  
   		  

	
} //end the class