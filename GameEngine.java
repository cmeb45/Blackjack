public class GameEngine{
    public static void main(String[] args){
		char Play = 'Y';
		// Character that represents whether or not the given group of people would like to play
		while(Play == 'Y'){
			System.out.println("How many players are in the game (not including the dealer)?");
			int NumberPlayers;
			NumberPlayers = IO.readInt();
			while(NumberPlayers < 0 || NumberPlayers > 12){
				if(NumberPlayers > 12){
					System.out.println("Error: You have entered a higher number of players than allotted.");
				}
				else if(NumberPlayers == 0){
					System.out.println("Goodbye.");
					return;
				}
				else if(NumberPlayers < 0){
					System.out.println("Error: You've entered a lower number of players than allotted.");
				}
				NumberPlayers = IO.readInt();
			}
			Player[] PlayerArray = new Player[NumberPlayers+1];
			// Creates a new Player array
			// Each element of the Player array represents a distinct player
			// For the sake of simplicity, designate PlayerArray[0] to be the dealer
			Card[] GameDeck = FullDeck.createCardArray();
			// Creates a new Card array, representing the cards that are to be used for the game
			FullDeck.shuffle(GameDeck);
			// Shuffles the cards in GameDeck
			int DeckCounter = 0;
			// Counter variable for the number of cards taken out from the deck so far
			PlayerArray[0] = new Player();
			PlayerArray[0].Name = "Dealer";
			// Constructs a new Player, specifically the dealer
			System.out.println("Hint 1: Take insurance if and only if you are card counting");
			System.out.println("Hint 2: Follow the Basic Blackjack Strategy, "
							 +"but don't be afraid to follow you intuition, no matter what");
			System.out.println("Hint 3: Double down only when you are on a winning streak");
			for(int i = 1; i <= NumberPlayers; i++){
				PlayerArray[i] = new Player();
				// Constructs a new Player, for each of the players of the game
				System.out.println("Enter the name of Player "+i);
				PlayerArray[i].Name = IO.readString();
				// The name of each player is provided as input
				// Dealer deals two cards "face up" to each player
				System.out.println(PlayerArray[i].Name+", you have "+PlayerArray[i].Bankroll
								+ " in your bankroll. How much would you like to wager?");
				System.out.println("The minimum bet is $100 and the maximum is $2500.");
				double y;
				y = IO.readDouble();
				while(y < 100.00 || y > 2500.00){
				// If the bet is out of the specified range
				System.out.println("Error: You must enter a bet within the specified range.");
				y = IO.readDouble();
				}
				PlayerArray[i].Wager = y;
				PlayerArray[i].Hand[0] = GameDeck[DeckCounter];
				if(PlayerArray[i].Hand[0].getValue() == 1){
				// If the first card is an Ace
					PlayerArray[i].Score = 11;
				// Aces are high, since the player has only one card
				}
				else if(PlayerArray[i].Hand[0].getValue() != 1){
					PlayerArray[i].Score = PlayerArray[i].Hand[0].getValue();  
				}
				PlayerArray[i].NumberOfCards++;
				PlayerArray[i].Hand[1] = GameDeck[DeckCounter+1];
				if(PlayerArray[i].Hand[1].getValue() == 1 && PlayerArray[i].Score >= 11){
				// If the player gets an ace and his/her score is at least 11
					PlayerArray[i].Score = PlayerArray[i].Score + 1;
				// Keep aces low, so that the player will not "bust" right away
				}
				else if(PlayerArray[i].Hand[1].getValue() == 1 && PlayerArray[i].Score < 11){
				// If the player gets an ace and his/her score is less than 11
					PlayerArray[i].Score = PlayerArray[i].Score + 11;
				// Make aces high, bringing the player closer to 21
				}
				else if(PlayerArray[i].Hand[1].getValue() != 1){
					  PlayerArray[i].Score = PlayerArray[i].Score + PlayerArray[i].Hand[1].getValue();
				}
				PlayerArray[i].NumberOfCards++;
				DeckCounter = DeckCounter + 2;
			}
			PlayerArray[0].Hand[0] = GameDeck[2*NumberPlayers];
			// The dealer deals one card "face down" to himself
			PlayerArray[0].Hand[1] = GameDeck[2*NumberPlayers + 1];
			// The dealer deals one card "face up" to himself
			PlayerArray[0].NumberOfCards++;
			System.out.println(Probabilities.DealerBustProbabilities(PlayerArray[0]));
			// Gives the probability that the dealer busts
			if(PlayerArray[0].Hand[1].getValue() == 1){
				// If the dealer's "face-up" card is an ace
				PlayerArray[0].Score = 11;
				for(int i = 1; i <= NumberPlayers; i++){
				System.out.println("The dealer has shown an Ace on his/her first card. "
								 +PlayerArray[i].Name+", would you like to make an insurance bet?"
								 +"Enter 0 for 'No' and 1 for 'Yes'");
				int z;
				z = IO.readInt();
				while(z != 0 && z != 1){
					// If the user enters a number that he/she wasn't supposed to enter
					System.out.println("Try again.");
					z = IO.readInt();
				}
				PlayerArray[i].getInsurance = z;
				if(PlayerArray[i].getInsurance == 1){
					PlayerArray[i].Insurance = 0.5*PlayerArray[i].Wager;
					// If the player decides to get insurance, 
					// make a side bet that is half of the original wager
				}
				}
			}
			else{
				PlayerArray[0].Score = PlayerArray[0].Hand[1].getValue();
			}
			DeckCounter = 2*NumberPlayers + 2;
			// Counter variable for the card passed out from the main deck so far
			for(int i = 1; i <= NumberPlayers; i++){
			  if(PlayerArray[i].Hand[0].getFace() == PlayerArray[i].Hand[1].getFace()){
				System.out.println(PlayerArray[i].Name+", you have a pair of "
								  +PlayerArray[i].Hand[0].getFace()
								  +"'s. Would you like to split? Enter 1 for Yes and 0 for No");
				System.out.println("According to Basic Blackjack Strategy, "
								  +BasicBlackjackStrategy.BeforeSplitStrategyHints(
								   PlayerArray[i], PlayerArray[0]));
				int q;
				q = IO.readInt();
				while(q != 0 && q != 1){
				// If the user enters a number that he/she wasn't supposed to enter
				   System.out.println("Try again.");
				   q = IO.readInt();
				}
				   PlayerArray[i].Split = q;
			  }
			}
			for(int i = 1; i <= NumberPlayers; i++){
			   if(PlayerArray[i].Split == 1){
			   // If a specific player decides to split
			   Split.BeginSplit(PlayerArray[i]);
			   Split.SplitGame(PlayerArray[i], PlayerArray, DeckCounter, GameDeck);
			   }
			   else if(PlayerArray[i].Split == 0){
			   while(PlayerArray[i].getBusted == 0 
						&& PlayerArray[i].Stand == 0 
						&& DeckCounter < 52 
						&& PlayerArray[i].Split == 0){
			   // While the player has not busted, split, or requested a stand, 
			   // and while number of cards passed out is at most number of cards in the main deck
					for(int j = 2; j < 11; j++){
						System.out.println(PlayerArray[i].Name+"'s current score is "
										 +PlayerArray[i].Score);
						PlayerArray[i].CardCounter = HiLoCardCount.CardCounter(PlayerArray);
						System.out.println(PlayerArray[i].Name+"'s card counter is "
										 +PlayerArray[i].CardCounter);
						// Updates the card counter with each hit
						System.out.println(BasicBlackjackStrategy.StrategyHints(
										 PlayerArray[i], PlayerArray[0]));
						// Gives hints from Basic Blackjack Strategy
						System.out.println("Would you like to hit or stand?"+ 
										  "Enter 0 for 'hit' or 1 for 'stand'");
						System.out.println("Also, if you would like to double down, enter 2");
						System.out.println(Probabilities.PlayerBustProbability(PlayerArray[i]));
						// Gives the probability of busting if the player decides to hit
						int x = IO.readInt();
						while(x != 0 && x != 1 && x != 2){
							// If the user enters a number that he/she wasn't supposed to enter
							System.out.println("Try again.");
							x = IO.readInt();
						}
						PlayerArray[i].Stand = x;
						if(PlayerArray[i].Stand == 0 || PlayerArray[i].Stand == 2){
							// If the player chooses to hit
							PlayerArray[i].Hand[j] = GameDeck[DeckCounter];
							// Dealer deals the player another card
							if(PlayerArray[i].Hand[j].getValue() == 1 
									&& PlayerArray[i].Score >= 11){
							// If the player gets an ace and his/her score is at least 11
								PlayerArray[i].Score = PlayerArray[i].Score + 1;
								// Keep aces low, so that the player will not "bust" right away
							}
							else if(PlayerArray[i].Hand[j].getValue() == 1 
									&& PlayerArray[i].Score < 11){
							// If the player gets an ace and his/her score is less than 11
								PlayerArray[i].Score = PlayerArray[i].Score + 11;
							// Make aces high, so the player has a score that is closer to 21
							}
							else if(PlayerArray[i].Hand[j].getValue() != 1){
								PlayerArray[i].Score = PlayerArray[i].Score 
													 + PlayerArray[i].Hand[j].getValue();
							}
							PlayerArray[i].NumberOfCards++;
							DeckCounter++;
					 }
					 else if(PlayerArray[i].Stand == 1){
					 // If the player chooses to stand
						break;
					 }
					 if(PlayerArray[i].Stand == 2){
					 // If the player wants to double down
					 PlayerArray[i].Wager = PlayerArray[i].Wager*2;
					 // Double the wager
						if(PlayerArray[i].Score > 21){
						// If the player has a score of over 21
						   PlayerArray[i].getBusted = 1;
						// This player has busted
						   break;
					   }
					   else{
						   break;
					   }
					 }
					 if(PlayerArray[i].Score > 21){
					 // If the player has a score of over 21
						PlayerArray[i].getBusted = 1;
						// This player has busted
						break;
					}
					}
			}
		   }
		}
		if(PlayerArray[0].Hand[0].getValue() == 1 && PlayerArray[0].Score >= 11){
			// The dealer turns his face-down card over
				// If that card is an ace and his score is at least 11
				PlayerArray[0].Score = PlayerArray[0].Score + 1;
				// Keep aces low, so that the dealer will not bust right away
				System.out.println("The dealer has not turned up a natural 21");
				for(int i = 1; i <= NumberPlayers; i++){
				    if(PlayerArray[i].getInsurance != 0){
					 System.out.println(PlayerArray[i].Name+" has lost the Insurance bet,"
									  +" and now has lost "+PlayerArray[i].Insurance);
					 PlayerArray[i].Bankroll -= PlayerArray[i].Insurance;
				   }
				}
		}
		else if(PlayerArray[0].Hand[0].getValue() == 1 && PlayerArray[0].Score < 11){
			// If that card is an ace & his score is at most 10
				PlayerArray[0].Score = PlayerArray[0].Score + 11;
				// Make aces high
				System.out.println("The dealer has not turned up a natural 21");
				for(int i = 1; i <= NumberPlayers; i++){
				    if(PlayerArray[i].getInsurance != 0){
					 System.out.println(PlayerArray[i].Name+" has lost the Insurance bet,"
									  +" and now has lost "+PlayerArray[i].Insurance);
					 PlayerArray[i].Bankroll -= PlayerArray[i].Insurance;
				   }
				}
		}
		else if(PlayerArray[0].Hand[0].getValue() != 1){
			PlayerArray[0].Score = PlayerArray[0].Score + PlayerArray[0].Hand[0].getValue();
			if(PlayerArray[0].Hand[1].getValue() == 1 
					&& PlayerArray[0].Hand[0].getValue() == 10 
					&& PlayerArray[0].Score == 21){
				// If the dealer gets a natural 21 (an Ace and any card with a value of 10)
				System.out.println("The dealer has turned up a natural 21");
				for(int i = 1; i <= NumberPlayers; i++){
					if(PlayerArray[i].getInsurance != 0){
						System.out.println(PlayerArray[i].Name+" has won the Insurance bet,"
									+" and now has an additional "+(2*PlayerArray[i].Insurance));
						 PlayerArray[i].Bankroll += (2*PlayerArray[i].Insurance);
					  }
				}
			}
			else if(PlayerArray[0].Hand[1].getValue() == 1 
					&& PlayerArray[0].Hand[0].getValue() != 10){
				System.out.println("The dealer has not turned up a natural 21");
				for(int i = 1; i <= NumberPlayers; i++){
					if(PlayerArray[i].getInsurance != 0){
						System.out.println(PlayerArray[i].Name+" has lost the Insurance bet,"
									+" and now has lost "+PlayerArray[i].Insurance);
						PlayerArray[i].Bankroll -= PlayerArray[i].Insurance;
					}
				}
			}
		}
		int Dealer_Card = 2;
		// Counter variable representing the number of cards in the dealer's hand
		while(PlayerArray[0].Score < 17 && DeckCounter < 52 && Dealer_Card < 12){
			// While the score of the dealer is less than 17, 
			// and while number of cards passed out is at most number of cards in the main deck
			PlayerArray[0].Hand[Dealer_Card] = GameDeck[DeckCounter];
			if(PlayerArray[0].Hand[Dealer_Card].getValue() == 1 && PlayerArray[0].Score >= 11){
				// If the dealer gets an ace and his/her score is at least 11
					PlayerArray[0].Score = PlayerArray[0].Score + 1;
					// Keep aces low, so that the player will not "bust" right away
			}
			else if(PlayerArray[0].Hand[Dealer_Card].getValue() == 1 && PlayerArray[0].Score < 11){
				// If the player gets an ace and his/her score is less than 11
					PlayerArray[0].Score = PlayerArray[0].Score + 11;
			// Make aces high, so the player has a score that is closer to 21
			}
			else if(PlayerArray[0].Hand[Dealer_Card].getValue() != 1){
				   PlayerArray[0].Score = PlayerArray[0].Score + 
										  PlayerArray[0].Hand[Dealer_Card].getValue();
			}
			DeckCounter++;
			Dealer_Card++;
		}
		if(PlayerArray[0].Score > 21){
			// If the dealer has a score greater than 21
			PlayerArray[0].getBusted = 1;
			// The dealer has busted
			System.out.println("The dealer has lost with a score of "+PlayerArray[0].Score);
			for(int i = 1; i <= NumberPlayers; i++){
			    if(PlayerArray[i].Split == 0){
					if(PlayerArray[i].getBusted == 0){
						System.out.println(PlayerArray[i].Name+" has won with a score of "+PlayerArray[i].Score);
						if(PlayerArray[i].Score != 21){
							// If the player does not have a blackjack
							System.out.println(PlayerArray[i].Name+" has won an additional "+PlayerArray[i].Wager);
							PlayerArray[i].Bankroll += PlayerArray[i].Wager;
							// The player wins 1:1
						}
						else{
							// If the player has a blackjack
							System.out.println(PlayerArray[i].Name+" has a blackjack, so he/she has won an additional "
												+(PlayerArray[i].Wager*1.5));
							PlayerArray[i].Bankroll += (PlayerArray[i].Wager*1.5);
						}
					}
					else if(PlayerArray[i].getBusted == 1){
					   System.out.println(PlayerArray[i].Name+" has lost with a score of "+PlayerArray[i].Score);
					}
			    }
			    else if(PlayerArray[i].Split == 1){
			    for(int k = 0; k <= 1; k++){
					if(PlayerArray[i].SplitBusted[k] == 0){
					    System.out.println(PlayerArray[i].Name+" has won on his/her Split Hand "+k
										+" with a score of "+PlayerArray[i].SplitScore[k]);
					    if(PlayerArray[i].Score != 21){
							// If the player does not have a blackjack
							System.out.println(PlayerArray[i].Name+" has won an additional "
							                  +PlayerArray[i].SplitWager[k]);
							PlayerArray[i].Bankroll += PlayerArray[i].SplitWager[k];
							// The player wins 1:1
					    }
					    else{
							// If the player has a blackjack
							System.out.println(PlayerArray[i].Name+" has a blackjack, so he/she has won an additional "
							                 +(PlayerArray[i].SplitWager[k]*1.5));
							PlayerArray[i].Bankroll += (PlayerArray[i].SplitWager[k]*1.5);
					    }
					}
					else if(PlayerArray[i].SplitBusted[k] == 1){
					    System.out.println(PlayerArray[i].Name+" has lost on his/her Split Hand "+k+" with a score of "
										  +PlayerArray[i].Score);
					}
				   }
			  }
			}
		}
		else{
			System.out.println("The dealer has a score of "+PlayerArray[0].Score);
			for(int i = 1; i <= NumberPlayers; i++){
			    if(PlayerArray[i].Split == 0){
					if(PlayerArray[i].Score > PlayerArray[0].Score && PlayerArray[i].getBusted == 0){
					// If the player has a greater score than the dealer
					   System.out.println(PlayerArray[i].Name+" has won with a score of "+PlayerArray[i].Score);
					   if(PlayerArray[i].Score != 21){
						   // If the player does not have a blackjack
						   System.out.println(PlayerArray[i].Name+" has won an additional "+PlayerArray[i].Wager);
						   PlayerArray[i].Bankroll += PlayerArray[i].Wager;
						   // The player wins 1:1
					   }
					   else{
						   // If the player has a blackjack
						   System.out.println(PlayerArray[i].Name+" has a blackjack, so he/she has won an additional "
											+(PlayerArray[i].Wager*1.5));
						   PlayerArray[i].Bankroll += (PlayerArray[i].Wager*1.5);
					   }
					}
					else if(PlayerArray[i].Score == PlayerArray[0].Score && PlayerArray[i].getBusted == 0){
					// If the player has an equal score to that of the dealer
					   System.out.println(PlayerArray[i].Name+" has pushed with a score of "+PlayerArray[i].Score);
					}
					else if(PlayerArray[i].Score < PlayerArray[0].Score && PlayerArray[i].getBusted == 0){
					// If the player has a lesser score than the dealer
					   System.out.println(PlayerArray[i].Name+" has lost with a score of "+PlayerArray[i].Score);
					}
					else if(PlayerArray[i].getBusted == 1){
					// If the player has busted, he/she automatically loses
					   System.out.println(PlayerArray[i].Name+" has lost with a score of "+PlayerArray[i].Score);
					}
			    }
			    else if(PlayerArray[i].Split == 1){
					for(int k = 0; k <= 1; k++){
						if(PlayerArray[i].SplitScore[k] > PlayerArray[0].Score && PlayerArray[i].SplitBusted[k] == 0){
						// If the player has a greater score than the dealer
						   System.out.println(PlayerArray[i].Name+" has won on his/her Split Hand "+k+
											" with a score of "+PlayerArray[i].SplitScore[k]);
						   if(PlayerArray[i].SplitScore[k] != 21){
						   // If the player does not have a blackjack
						   System.out.println(PlayerArray[i].Name+" has won an additional "
											+PlayerArray[i].SplitWager[k]);
						   PlayerArray[i].Bankroll += PlayerArray[i].Wager;
						   // The player wins 1:1
						   }
						   else{
						   // If the player has a blackjack
						   System.out.println(PlayerArray[i].Name+" has a blackjack, so he/she has won an additional "
											+(PlayerArray[i].SplitWager[k]*1.5));
						   PlayerArray[i].Bankroll += (PlayerArray[i].SplitWager[k]*1.5);
						   }
						}
						else if(PlayerArray[i].SplitScore[k] == PlayerArray[0].Score 
								&& PlayerArray[i].SplitBusted[k] == 0){
						// If the player has an equal score to that of the dealer
						   System.out.println(PlayerArray[i].Name+" has pushed on his/her Split Hand "+k
											+" with a score of "+PlayerArray[i].SplitScore[k]);
						}
						else if(PlayerArray[i].SplitScore[k] < PlayerArray[0].Score 
								&& PlayerArray[i].SplitBusted[k] == 0){
						// If the player has a lesser score than the dealer
						   System.out.println(PlayerArray[i].Name+" has lost on his/her Split Hand "+k
											+" with a score of "+PlayerArray[i].SplitScore[k]);
						}
						else if(PlayerArray[i].SplitBusted[k] == 1){
						// If the player has busted, he/she automatically loses
						   System.out.println(PlayerArray[i].Name+" has lost on his/her Split Hand "+k
											+" with a score of "+PlayerArray[i].SplitScore[k]);
						}
				   }
			  }
			}
		}
			System.out.println("That was fun! Would you like to play again? "+
							"Enter 'Y' for 'Yes' and anything else for 'No'");
			Play = IO.readChar();
			if(Play != 'Y'){
			System.out.println("Goodbye!");
				return;
			}
		}
		}
}