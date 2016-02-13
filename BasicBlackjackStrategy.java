public class BasicBlackjackStrategy{
// Gives hints from Basic Blackjack Strategy
    public static String StrategyHints(Player Gamer, Player Dealer){
	    String ReturnString = "";
	    if(Gamer.Hand[0].getFace() != 1 && Gamer.Hand[1].getFace() != 1){
		// If the player has a hard hand (two starting cards with no aces)
		    if(Gamer.Score <= 8){
			  ReturnString = Gamer.Name+" should hit";
			}
			else if(Gamer.Score == 9){
			  if(Dealer.Score >= 3 && Dealer.Score <= 6){
			    ReturnString = Gamer.Name+" should double";
			  }
			  else{
			    ReturnString = Gamer.Name+" should hit";
			  }
			}
			else if(Gamer.Score == 10){
			  if(Dealer.Score >= 2 && Dealer.Score <= 9){
			    ReturnString = Gamer.Name+" should double";
			  }
			  else{
			    ReturnString = Gamer.Name+" should hit";
			  }
			}
			else if(Gamer.Score == 11){
			  if(Dealer.Score >= 2 && Dealer.Score <=10){
			    ReturnString = Gamer.Name+" should double";
			  }
			  else if(Dealer.Hand[1].getFace() == 1){
			    ReturnString = Gamer.Name+" should hit";
			  }
			}
			else if(Gamer.Score == 12){
			  if(Dealer.Score == 2 || Dealer.Score == 3){
			    ReturnString = Gamer.Name+" should hit";
			  }
			  else if(Dealer.Score >= 4 && Dealer.Score <= 6){
			    ReturnString = Gamer.Name+" should stand";
			  }
			  else{
			    ReturnString = Gamer.Name+" should hit";
			  }
			}
			else if(Gamer.Score >= 13 && Gamer.Score <= 16){
			  if(Dealer.Score >= 2 && Dealer.Score <= 6){
			    ReturnString = Gamer.Name+" should stand";
			  }
			  else{
			    ReturnString = Gamer.Name+" should hit";
			  }
			}
			else if(Gamer.Score >= 17 && Gamer.Score <= 21){
			    ReturnString = Gamer.Name+" should stand";
			}
		}
		else if((Gamer.Hand[0].getFace() == 1 && Gamer.Hand[1].getFace() != 1) || (Gamer.Hand[0].getFace() != 1 && Gamer.Hand[1].getFace() == 1)){
		// If the player has a soft hand (one of the starting hands contains an ace)
		    if(((Gamer.Hand[0].getFace() == 1 && Gamer.Hand[1].getFace() == 2) || (Gamer.Hand[0].getFace() == 2 && Gamer.Hand[1].getFace() == 1)) || ((Gamer.Hand[0].getFace() == 1 && Gamer.Hand[1].getFace() == 3) || (Gamer.Hand[0].getFace() == 3 && Gamer.Hand[1].getFace() == 1))){
			   // If you have an Ace 2 or Ace 3
			   if(Dealer.Score == 5 || Dealer.Score == 6){
			      ReturnString = Gamer.Name+" should double";
			   }
			   else{
			      ReturnString = Gamer.Name+" should hit";
			   }
			}
			else if(((Gamer.Hand[0].getFace() == 1 && Gamer.Hand[1].getFace() == 4) || (Gamer.Hand[0].getFace() == 4 && Gamer.Hand[1].getFace() == 1)) || ((Gamer.Hand[0].getFace() == 1 && Gamer.Hand[1].getFace() == 5) || (Gamer.Hand[0].getFace() == 5 && Gamer.Hand[1].getFace() == 1))){
			  // If you have an Ace 4 or Ace 5
			   if(Dealer.Score >= 4 && Dealer.Score <= 6){
			      ReturnString = Gamer.Name+" should double";
			   }
			   else{
			      ReturnString = Gamer.Name+" should hit";
			   }  
			}
			else if((Gamer.Hand[0].getFace() == 1 && Gamer.Hand[1].getFace() == 6) || (Gamer.Hand[0].getFace() == 6 && Gamer.Hand[1].getFace() == 1)){
			// If you have an Ace 6
			  if(Dealer.Score >= 3 && Dealer.Score <= 6){
			      ReturnString = Gamer.Name+" should double";
			   }
			   else{
			      ReturnString = Gamer.Name+" should hit";
			   }
			}
			else if((Gamer.Hand[0].getFace() == 1 && Gamer.Hand[1].getFace() == 7) || (Gamer.Hand[0].getFace() == 7 && Gamer.Hand[1].getFace() == 1)){
			// If you have an Ace 7
			  if(Dealer.Score == 2 || Dealer.Score == 7 || Dealer.Score == 8){
			     ReturnString = Gamer.Name+" should stand";
			  }
			  else if(Dealer.Score >= 3 && Dealer.Score <= 6){
			     ReturnString = Gamer.Name+" should double";
			  }
			}
			else if(((Gamer.Hand[0].getFace() == 1 && Gamer.Hand[1].getFace() == 8) || (Gamer.Hand[0].getFace() == 8 && Gamer.Hand[1].getFace() == 1)) || ((Gamer.Hand[0].getFace() == 1 && Gamer.Hand[1].getFace() == 9) || (Gamer.Hand[0].getFace() == 9 && Gamer.Hand[1].getFace() == 1))){
			  // If you have an Ace 8 or Ace 9
			   ReturnString = Gamer.Name+" should stand";  
			}
		}
		return ReturnString;
	}
	public static String BeforeSplitStrategyHints(Player Gamer, Player Dealer){
	// Gives hints from Basic Blackjack Strategy when the player is deciding to split his/her cards
	  String ReturnString = "";
	  if(Gamer.Hand[0].getValue() == 1 && Gamer.Hand[1].getValue() == 1){
	  // Pair of Aces
	    if(Dealer.Score >= 2 && Dealer.Score <= 7){
		  ReturnString = Gamer.Name+" should split";
		}
		else{
		  ReturnString = Gamer.Name+" should not split";
		}
	  }
	  else if((Gamer.Hand[0].getValue() == 2 && Gamer.Hand[1].getValue() == 2) || (Gamer.Hand[0].getValue() == 3 && Gamer.Hand[1].getValue() == 3)){
	    if(Dealer.Score >= 2 && Dealer.Score <= 7){
		  ReturnString = Gamer.Name+" should split";
		}
		else{
		  ReturnString = Gamer.Name+" should not split";
		}
	  }
	  else if(Gamer.Hand[0].getValue() == 4 && Gamer.Hand[1].getValue() == 4){
	    if(Dealer.Score >= 5 && Dealer.Score <= 6){
		  ReturnString = Gamer.Name+" should split";
		}
		else{
		  ReturnString = Gamer.Name+" should not split";
		}
	  }
	  else if(Gamer.Hand[0].getValue() == 5 && Gamer.Hand[1].getValue() == 5){
		  ReturnString = Gamer.Name+" should not split";
	  }
	  else if(Gamer.Hand[0].getValue() == 6 && Gamer.Hand[1].getValue() == 6){
	    if(Dealer.Score >= 2 && Dealer.Score <= 6){
		  ReturnString = Gamer.Name+" should split";
		}
		else{
		  ReturnString = Gamer.Name+" should not split";
		}
	  }
	  else if(Gamer.Hand[0].getValue() == 7 && Gamer.Hand[1].getValue() == 7){
	    if(Dealer.Score >= 2 && Dealer.Score <= 7){
		  ReturnString = Gamer.Name+" should split";
		}
		else{
		  ReturnString = Gamer.Name+" should not split";
		}
	  }
	  else if(Gamer.Hand[0].getValue() == 8 && Gamer.Hand[1].getValue() == 8){
		  ReturnString = Gamer.Name+" should split";
	  }
	  else if(Gamer.Hand[0].getValue() == 9 && Gamer.Hand[1].getValue() == 9){
	    if((Dealer.Score >= 2 && Dealer.Score <= 6) || (Dealer.Score >= 8 && Dealer.Score <= 9)){
		  ReturnString = Gamer.Name+" should split";
		}
		else{
		  ReturnString = Gamer.Name+" should not split";
		}
	  }
	  else if(Gamer.Hand[0].getValue() == 10 && Gamer.Hand[1].getValue() == 10){
		  ReturnString = Gamer.Name+" should not split";
	  }
	  return ReturnString;
	}
    public static String AfterSplitStrategyHints(Player Gamer, Player Dealer, int i){
	    String ReturnString = "";
	    if(Gamer.SplitHand[i][0].getFace() != 1 && Gamer.SplitHand[i][1].getFace() != 1){
		// If the player has a hard hand (two starting cards with no aces)
		    if(Gamer.SplitScore[i] <= 8){
			  ReturnString = Gamer.Name+" should hit";
			}
			else if(Gamer.SplitScore[i] == 9){
			  if(Dealer.Score >= 3 && Dealer.Score <= 6){
			    ReturnString = Gamer.Name+" should double";
			  }
			  else{
			    ReturnString = Gamer.Name+" should hit";
			  }
			}
			else if(Gamer.SplitScore[i] == 10){
			  if(Dealer.Score >= 2 && Dealer.Score <= 9){
			    ReturnString = Gamer.Name+" should double";
			  }
			  else{
			    ReturnString = Gamer.Name+" should hit";
			  }
			}
			else if(Gamer.SplitScore[i] == 11){
			  if(Dealer.Score >= 2 && Dealer.Score <=10){
			    ReturnString = Gamer.Name+" should double";
			  }
			  else if(Dealer.Hand[1].getFace() == 1){
			    ReturnString = Gamer.Name+" should hit";
			  }
			}
			else if(Gamer.SplitScore[i] == 12){
			  if(Dealer.Score == 2 || Dealer.Score == 3){
			    ReturnString = Gamer.Name+" should hit";
			  }
			  else if(Dealer.Score >= 4 && Dealer.Score <= 6){
			    ReturnString = Gamer.Name+" should stand";
			  }
			  else{
			    ReturnString = Gamer.Name+" should hit";
			  }
			}
			else if(Gamer.SplitScore[i] >= 13 && Gamer.SplitScore[i] <= 16){
			  if(Dealer.Score >= 2 && Dealer.Score <= 6){
			    ReturnString = Gamer.Name+" should stand";
			  }
			  else{
			    ReturnString = Gamer.Name+" should hit";
			  }
			}
			else if(Gamer.SplitScore[i] >= 17 && Gamer.SplitScore[i] <= 21){
			    ReturnString = Gamer.Name+" should stand";
			}
		}
		else if((Gamer.SplitHand[i][0].getFace() == 1 && Gamer.SplitHand[i][1].getFace() != 1) || (Gamer.SplitHand[i][0].getFace() != 1 && Gamer.SplitHand[i][1].getFace() == 1)){
		// If the player has a soft hand (one of the starting hands contains an ace)
		    if(((Gamer.SplitHand[i][0].getFace() == 1 && Gamer.SplitHand[i][1].getFace() == 2) || (Gamer.SplitHand[i][0].getFace() == 2 && Gamer.SplitHand[i][1].getFace() == 1)) || ((Gamer.SplitHand[i][0].getFace() == 1 && Gamer.SplitHand[i][1].getFace() == 3) || (Gamer.SplitHand[i][0].getFace() == 3 && Gamer.SplitHand[i][1].getFace() == 1))){
			   // If you have an Ace 2 or Ace 3
			   if(Dealer.Score == 5 || Dealer.Score == 6){
			      ReturnString = Gamer.Name+" should double";
			   }
			   else{
			      ReturnString = Gamer.Name+" should hit";
			   }
			}
			else if(((Gamer.SplitHand[i][0].getFace() == 1 && Gamer.SplitHand[i][1].getFace() == 4) || (Gamer.SplitHand[i][0].getFace() == 4 && Gamer.SplitHand[i][1].getFace() == 1)) || ((Gamer.SplitHand[i][0].getFace() == 1 && Gamer.SplitHand[i][1].getFace() == 5) || (Gamer.SplitHand[i][0].getFace() == 5 && Gamer.SplitHand[i][1].getFace() == 1))){
			  // If you have an Ace 4 or Ace 5
			   if(Dealer.Score >= 4 && Dealer.Score <= 6){
			      ReturnString = Gamer.Name+" should double";
			   }
			   else{
			      ReturnString = Gamer.Name+" should hit";
			   }  
			}
			else if((Gamer.SplitHand[i][0].getFace() == 1 && Gamer.SplitHand[i][1].getFace() == 6) || (Gamer.SplitHand[i][0].getFace() == 6 && Gamer.SplitHand[i][1].getFace() == 1)){
			// If you have an Ace 6
			  if(Dealer.Score >= 3 && Dealer.Score <= 6){
			      ReturnString = Gamer.Name+" should double";
			   }
			   else{
			      ReturnString = Gamer.Name+" should hit";
			   }
			}
			else if((Gamer.SplitHand[i][0].getFace() == 1 && Gamer.SplitHand[i][1].getFace() == 7) || (Gamer.SplitHand[i][0].getFace() == 7 && Gamer.SplitHand[i][1].getFace() == 1)){
			// If you have an Ace 7
			  if(Dealer.Score == 2 || Dealer.Score == 7 || Dealer.Score == 8){
			     ReturnString = Gamer.Name+" should stand";
			  }
			  else if(Dealer.Score >= 3 && Dealer.Score <= 6){
			     ReturnString = Gamer.Name+" should double";
			  }
			}
			else if(((Gamer.SplitHand[i][0].getFace() == 1 && Gamer.SplitHand[i][1].getFace() == 8) || (Gamer.SplitHand[i][0].getFace() == 8 && Gamer.SplitHand[i][1].getFace() == 1)) || ((Gamer.SplitHand[i][0].getFace() == 1 && Gamer.SplitHand[i][1].getFace() == 9) || (Gamer.SplitHand[i][0].getFace() == 9 && Gamer.SplitHand[i][1].getFace() == 1))){
			  // If you have an Ace 8 or Ace 9
			   ReturnString = Gamer.Name+" should stand";  
			}
		}
		return ReturnString;
	}	
}