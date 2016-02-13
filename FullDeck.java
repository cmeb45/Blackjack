public class FullDeck{
    public static Card[] createCardArray(){
        // Returns an array of 52 cards representing Ace through King for all 4 suits
        // Cards should be in order i.e. A-K of Spades, then A-K of Diamonds, then A-K of Clubs, then A-K of Hearts
        Card[] cardArray = new Card[52];
        // The Card array in which the cards will be placed
        int k = 0;
        for(int i = 0; i <= 3; i++){
	    // Loops over the integers representing the card suits
            for(int j = 1; j <=13; j++){
                // Loops over the integers representing the card faces
                    cardArray[k] = new Card(i, j);
                    // Uses the Card constructor to build a card with the given suit and face
                    k++;
	    }
	}
        return cardArray;
    }
    public static void shuffle(Card[] cardArray){
        // Implements Durstenfeld's shuffling algorithm
        for(int i = cardArray.length - 1; i >= 0; i--){
            int j = (int) (52*Math.random());
            // Creates a random integer between 0 and 51
            Card temp = cardArray[i];
            cardArray[i]=cardArray[j];
            cardArray[j]=temp;
            // Swaps the card at position i with the card at position j, by means of a temp variable
        }
    }
}