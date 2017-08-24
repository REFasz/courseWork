//////////////////////////////////////////////////////////////////////////////////////////////////
//
// Name: Riley Faszewski
//
// Date: 8/29/2013
//
// Purpose: To simulate a card game called war. One side, the red cards (hearts and diamonds), verse the 
//          black cards (clubs and spades).
//
// Inputs:
//
// Outputs: Games Tied, Games Won by Red, and Games Won by Black
//
/////////////////////////////////////////////////////////////////////////////////////////////////

import javax.swing.JOptionPane;

public class PlayWar {
   public static void main(String args[]){
    Deck cards;
    Hand redHand, blackHand;
    PlayingCard tempCard, redCard, blackCard;
    int index,
        count,
        games,
        blackWins = 0,
        redWins = 0,
        ties = 0,
        counter[];
    
    
	 
       cards = new Deck();
	 
       redHand = new Hand(Deck.MAX_CARDS_PER_DECK / 2);
       blackHand = new Hand(Deck.MAX_CARDS_PER_DECK / 2);
       counter = new int[16];
       
       for(games = 0; games < 100000; games ++){
         cards.shuffle(); //shuffles cards
         
         
    //deals cards
      for (index = 0; index < Deck.MAX_CARDS_PER_DECK; index ++){
       tempCard = cards.getNextCard();
       if(tempCard.getSuitValue() == PlayingCard.SPADES || tempCard.getSuitValue() == PlayingCard.CLUBS)
         blackHand.addCard(tempCard);
       else
          redHand.addCard(tempCard);
      } //ends for loop
      
      
      for(count = 0; redHand.handCount() > 0 && blackHand.handCount() > 0; count ++){ //starts play
         blackCard = blackHand.turnCard();
         redCard = redHand.turnCard();
         
         //tosses from hand cards that need to be tossed
         if(blackCard.getFaceValue() == redCard.getFaceValue()){
            //System.out.println("Tie: Tossing Cards: " + blackCard.toString() + " and " + redCard.toString());
            blackHand.tossFromHand(blackCard);
            redHand.tossFromHand(redCard);
         } // end if
         
         else{
            if(blackCard.getFaceValue() > redCard.getFaceValue()){
              // System.out.println("The "+ blackCard.toString() + " is higher than the " + redCard.toString());
               redHand.tossFromHand(redCard);
            }
            
            if(redCard.getFaceValue() > blackCard.getFaceValue()){
                //System.out.println("The "+ redCard.toString() + " is higher than the " + blackCard.toString());
                blackHand.tossFromHand(blackCard);
            } //ends if
         } //ends else
      } //ends for loop
      
      
      if(blackHand.handCount() == 0 && redHand.handCount() == 0){
         // System.out.println("TIE");
         ties ++;
         counter[0]++;
      } //ends if
      else{
         if(blackHand.handCount() == 0){
            //System.out.println("RED WINS");
            redWins ++;
            counter[redHand.handCount()] ++;
         }  //ends if
         else{
            //System.out.println("BLACK WINS");
            blackWins ++;
            counter[blackHand.handCount()] ++;
         } //ends else
      } //ends else
      
      blackHand.resetHand();
      redHand.resetHand();
      
   } //ends for
   
   System.out.println("There were " + ties + " tie games, red won " + redWins + " games, and black won " + blackWins + " games.");
      /*for(int i = 0; i < 16; i++){
      System.out.println("Counter[" + i + "] = " + counter[i]);
      }//ends for */
   
   
      

    
    
    System.exit(0);
    
    
    } //ends main
    
    
    
	
} //end the class