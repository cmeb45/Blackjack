public class Player{
    public int getBusted = 0;
    // Integer that represents whether or not the player busted (0 for "No", 1 for "Yes")
    public int Stand = 0;
    // Integer that represents whether or not the player "stands" (0 for "No", 1 for "Yes")
	// 2 for "Double Down"
    public int Score;
    // The score of a player
    public Card[] Hand = new Card[11];
    // The player's hand (set of cards the player currently holds)
    // The maximum number of cards any player can have is 12
	public String Name;
	// The name of the player
	public double Bankroll = 1000.00;
	// Represents how much money a player starts out with in his/her bankroll
	public double Wager = 0.00;
	// Represents how much money a player would like to wager
	public int getInsurance = 0;
	// Integer that represents whether or not the player wants to make an insurance bet (0 for "No", 1 for "Yes")
	public double Insurance = 0.00;
	// Represents a separate wager for Insurance
	public int CardCounter = 0;
	// Represents a card counter (using the Hi-Lo Card Counting system)
	public int NumberOfCards = 0;
	// Represents how many cards a player has in his/her hand

	public int Split = 0;
	// Integer that represents whether or not the player has split (0 for "No", 1 for "Yes")
	public Card[][] SplitHand = new Card[2][11];
	// Represents separate hands in case the player decides to split
	public int[] SplitScore = new int[2];
	// Represents scores for the separate hands in case the player decides to split
    public int[] SplitStand = new int[2];
	// Integers that represent whether or not the player stands or hits (0 for No, 1 for Yes, 2 for Double Down)
	public double[] SplitWager = new double[2];
	// Represents how much money a player would like to wager on each split hand
	public int[] SplitBusted = new int[2];
	// Represents whether or not a player busts on a split hand (0 for No, 1 for Yes)
	public int[] SplitNumberOfCards = new int[2];
	// Represents how many cards are in each split hand
}