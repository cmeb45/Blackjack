public class Probabilities{
	public static String PlayerBustProbability(Player Gamer){
		// Gives the probability of busting if a player has a certain score
		String ReturnString = "";
		if(Gamer.Score <= 11){
			ReturnString = Gamer.Name+" has a 0% chance of busting if he/she hits";
		}
		else if(Gamer.Score == 12){
			ReturnString = Gamer.Name+" has a 31% chance of busting if he/she hits";
		}
		else if(Gamer.Score == 13){
			ReturnString = Gamer.Name+" has a 39% chance of busting if he/she hits";
		}
		else if(Gamer.Score == 14){
			ReturnString = Gamer.Name+" has a 56% chance of busting if he/she hits";
		}
		else if(Gamer.Score == 15){
			ReturnString = Gamer.Name+" has a 58% chance of busting if he/she hits";
		}
		else if(Gamer.Score == 16){
			ReturnString = Gamer.Name+" has a 62% chance of busting if he/she hits";
		}
		else if(Gamer.Score == 17){
			ReturnString = Gamer.Name+" has a 69% chance of busting if he/she hits";
		}
		else if(Gamer.Score == 18){
			ReturnString = Gamer.Name+" has a 77% chance of busting if he/she hits";
		}
		else if(Gamer.Score == 19){
			ReturnString = Gamer.Name+" has a 85% chance of busting if he/she hits";
		}
		else if(Gamer.Score == 20){
			ReturnString = Gamer.Name+" has a 92% chance of busting if he/she hits";
		}
		else if(Gamer.Score == 21){
			ReturnString = Gamer.Name+" has a 100% chance of busting if he/she hits";
		}
		return ReturnString;
		}
	public static String SplitPlayerBustProbability(Player Gamer, int i){
		// Gives the probability of busting if a player has a certain score & the player has split his/her hand
		String ReturnString = "";
		if(Gamer.SplitScore[i] <= 11){
			ReturnString = Gamer.Name+" has a 0% chance of busting if he/she hits";
		}
		else if(Gamer.SplitScore[i] == 12){
			ReturnString = Gamer.Name+" has a 31% chance of busting if he/she hits";
		}
		else if(Gamer.SplitScore[i] == 13){
			ReturnString = Gamer.Name+" has a 39% chance of busting if he/she hits";
		}
		else if(Gamer.SplitScore[i] == 14){
			ReturnString = Gamer.Name+" has a 56% chance of busting if he/she hits";
		}
		else if(Gamer.SplitScore[i] == 15){
			ReturnString = Gamer.Name+" has a 58% chance of busting if he/she hits";
		}
		else if(Gamer.SplitScore[i] == 16){
			ReturnString = Gamer.Name+" has a 62% chance of busting if he/she hits";
		}
		else if(Gamer.SplitScore[i] == 17){
			ReturnString = Gamer.Name+" has a 69% chance of busting if he/she hits";
		}
		else if(Gamer.SplitScore[i] == 18){
			ReturnString = Gamer.Name+" has a 77% chance of busting if he/she hits";
		}
		else if(Gamer.SplitScore[i] == 19){
			ReturnString = Gamer.Name+" has a 85% chance of busting if he/she hits";
		}
		else if(Gamer.SplitScore[i] == 20){
			ReturnString = Gamer.Name+" has a 92% chance of busting if he/she hits";
		}
		else if(Gamer.SplitScore[i] == 21){
			ReturnString = Gamer.Name+" has a 100% chance of busting if he/she hits";
		}
		return ReturnString;
	}  
	public static String DealerBustProbabilities(Player Dealer){
		// Gives the probability of the dealer busting, depending on the value of his/her first card
		String ReturnString = "";
		if(Dealer.Hand[1].getFace() == 2){
			ReturnString = "The dealer has a 35.3% probability of busting";
		}
		else if(Dealer.Hand[1].getFace() == 3){
		    ReturnString = "The dealer has a 37.56% probability of busting";
		}
		else if(Dealer.Hand[1].getFace() == 4){
		    ReturnString = "The dealer has a 40.28% probability of busting";
		}
		else if(Dealer.Hand[1].getFace() == 5){
		    ReturnString = "The dealer has a 42.89% probability of busting";
		}
		else if(Dealer.Hand[1].getFace() == 6){
		    ReturnString = "The dealer has a 42.08% probability of busting";
		}
		else if(Dealer.Hand[1].getFace() == 7){
		    ReturnString = "The dealer has a 25.99% probability of busting";
		}
		else if(Dealer.Hand[1].getFace() == 8){
		    ReturnString = "The dealer has a 23.86% probability of busting";
		}
		else if(Dealer.Hand[1].getFace() == 9){
		    ReturnString = "The dealer has a 23.34% probability of busting";
		}
		else if(Dealer.Hand[1].getFace() == 11 || Dealer.Hand[1].getFace() == 12 || Dealer.Hand[1].getFace() == 13){
		    ReturnString = "The dealer has a 21.43% probability of busting";
		}
		else if(Dealer.Hand[1].getFace() == 1){
		    ReturnString = "The dealer has a 11.65% probability of busting";
		}
		return ReturnString;
	}
}