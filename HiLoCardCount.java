public class HiLoCardCount{
    // Implementation of the Hi-Lo Card Counting System
    public static int CardCounter(Player[] AllGamers){
	int Count = 0;
        for(int i = 1; i < AllGamers.length; i++){
		   if(AllGamers[i].Split == 0){
            for(int j = 0; j < AllGamers[i].NumberOfCards; j++){
                if(AllGamers[i].Hand[j].getValue() >= 2 && AllGamers[i].Hand[j].getValue() <=6){
		    // If a 2, 3, 4, 5, or 6 is passed out
                    Count++;
		        }
		        else if(AllGamers[i].Hand[j].getValue() >= 7 && AllGamers[i].Hand[j].getValue() <= 9){
		    // If a 7, 8, or 9 is passed out
                    Count = Count + 0;
		        }
                else if(AllGamers[i].Hand[j].getValue() == 10 || AllGamers[i].Hand[j].getValue() == 1){
                    // If a 10, J, Q, K, or A is passed out
                    Count = Count - 1;
		        }
	       }
		  }
		    else if(AllGamers[i].Split == 1){
			  for(int k = 0; k <= 1; k++){
			  for(int j = 0; j < AllGamers[i].SplitNumberOfCards[k]; j++){
                if(AllGamers[i].SplitHand[k][j].getValue() >= 2 && AllGamers[i].SplitHand[k][j].getValue() <=6){
		    // If a 2, 3, 4, 5, or 6 is passed out
                    Count++;
		        }
		        else if(AllGamers[i].SplitHand[k][j].getValue() >= 7 && AllGamers[i].SplitHand[k][j].getValue() <= 9){
		    // If a 7, 8, or 9 is passed out
                    Count = Count + 0;
		        }
                else if(AllGamers[i].SplitHand[k][j].getValue() == 10 || AllGamers[i].SplitHand[k][j].getValue() == 1){
                    // If a 10, J, Q, K, or A is passed out
                    Count = Count - 1;
		        }
	       }
			  }
		    }
	    }
	if(AllGamers[0].Hand[1].getValue() >= 2 && AllGamers[0].Hand[1].getValue() <=6){
		    // If a 2, 3, 4, 5, or 6 is passed out
                    Count++;
		}
		else if(AllGamers[0].Hand[1].getValue() >= 7 && AllGamers[0].Hand[1].getValue() <= 9){
		    // If a 7, 8, or 9 is passed out
                    Count = Count + 0;
		}
                else if(AllGamers[0].Hand[1].getValue() == 10 || AllGamers[0].Hand[1].getValue() == 1){
                    // If a 10, J, Q, K, or A is passed out
                    Count = Count - 1;
		}
		// Special case for the dealer's "Face-Up" card
        return Count;
  }
}