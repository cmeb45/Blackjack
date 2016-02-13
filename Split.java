public class Split{
  public static void BeginSplit(Player Gamer){
    for(int i = 0; i <= 1; i++){
	  Gamer.SplitHand[i][0] = Gamer.Hand[0];
	  if(Gamer.SplitHand[i][0].getValue() == 1){
	    Gamer.SplitScore[i] = 11;
	  }
	  else{
	  Gamer.SplitScore[i] = Gamer.SplitHand[i][0].getValue();
	 }
	 Gamer.SplitWager[i] = Gamer.Wager;
	 Gamer.SplitNumberOfCards[i]++;
	}
  }
  public static void SplitGame(Player Gamer, Player[] AllPlayers, int DeckCounterVariable, Card[] DeckOfCards){
             for(int i = 0; i <= 1; i++){
    	       while(Gamer.SplitBusted[i] == 0 && Gamer.SplitStand[i] == 0 && DeckCounterVariable < 52){
		   // While the player has not busted or requested a stand, and while the number of cards passed out is less than or equal to the number of cards in the main deck
				for(int j = 1; j < 11; j++){
                System.out.println(Gamer.Name+"'s current score on Split Hand "+i+" is "+Gamer.SplitScore[i]);
				Gamer.CardCounter = HiLoCardCount.CardCounter(AllPlayers);
				System.out.println(Gamer.Name+"'s card counter is "+Gamer.CardCounter);
				// Updates the card counter with each hit
				if(Gamer.SplitNumberOfCards[i] >= 2){
				System.out.println(BasicBlackjackStrategy.AfterSplitStrategyHints(Gamer, AllPlayers[0], i));
		        // Gives hints from Basic Blackjack Strategy
				}
 				System.out.println("Would you like to hit or stand? Enter 0 for 'hit' or 1 for 'stand'");
				System.out.println("Also, if you would like to double down, enter 2");
				System.out.println(Probabilities.SplitPlayerBustProbability(Gamer, i));
				// Gives the probability of busting if the player decides to hit
                  int x = IO.readInt();
                  while(x != 0 && x != 1 && x != 2){
		          // If the user enters a number that he/she wasn't supposed to enter
                    System.out.println("Try again silly!!");
		            x = IO.readInt();
                  }
		            Gamer.SplitStand[i] = x;
                  if(Gamer.SplitStand[i] == 0 || Gamer.SplitStand[i] == 2){
		          // If the player chooses to hit
		            Gamer.SplitHand[i][j] = DeckOfCards[DeckCounterVariable];
                    // Dealer deals the player another card
                    if(Gamer.SplitHand[i][j].getValue() == 1 && Gamer.SplitScore[i] >= 11){
		            // If the player gets an ace and his/her score is at least 11
                        Gamer.SplitScore[i] = Gamer.SplitScore[i] + 1;
                        // Keep aces low, so that the player will not "bust" right away
                    }
                    else if(Gamer.SplitHand[i][j].getValue() == 1 && Gamer.SplitScore[i] < 11){
			        // If the player gets an ace and his/her score is less than 11
                        Gamer.SplitScore[i] = Gamer.SplitScore[i] + 11;
			        // Make aces high, so the player has a score that is closer to 21
		            }
                    else if(Gamer.SplitHand[i][j].getValue() != 1){
                        Gamer.SplitScore[i] = Gamer.SplitScore[i] + Gamer.SplitHand[i][j].getValue();
                    }
					Gamer.SplitNumberOfCards[i]++;
                    DeckCounterVariable++;
		         }
		         else if(Gamer.SplitStand[i] == 1){
				 // If the player chooses to stand
				    break;
				 }
				 if(Gamer.SplitStand[i] == 2){
				 // If the player wants to double down
				 Gamer.SplitWager[i] = Gamer.SplitWager[i]*2;
				 // Double the wager
				    if(Gamer.SplitScore[i] > 21){
                    // If the player has a score of over 21
		               Gamer.SplitBusted[i] = 1;
                    // This player has busted
			           break;
		           }
				   else{
				       break;
				   }
				 }
                 if(Gamer.SplitScore[i] > 21){
                 // If the player has a score of over 21
		            Gamer.SplitBusted[i] = 1;
                    // This player has busted
			        break;
		        }
                }
	    }
	  }
  }
}