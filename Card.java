// This class represents one playing card.
public class Card
{
	// Card suits (provided for your convenience - use is optional)
	public static final int SPADES   = 0;
	public static final int HEARTS   = 3;
	public static final int CLUBS    = 2;
	public static final int DIAMONDS = 1;

	// Card faces (provided for your convenience - use is optional)
	public static final int ACE      = 1;
	public static final int TWO      = 2;
	public static final int THREE    = 3;
	public static final int FOUR     = 4;
	public static final int FIVE     = 5;
	public static final int SIX      = 6;
	public static final int SEVEN    = 7;
	public static final int EIGHT    = 8;
	public static final int NINE     = 9;
	public static final int TEN      = 10;
	public static final int JACK     = 11;
	public static final int QUEEN    = 12;
	public static final int KING     = 13;


	// define fields here
	int suit;
	int face;
	boolean faceUp;
	
	
	// This constructor builds a card with the given suit and face, turned face down.
	public Card(int cardSuit, int cardFace)
	{
		suit = cardSuit;
		face = cardFace;
		faceUp = false;
	}

	public void turnFaceUp(){
	    faceUp = true;
	}
	
	// This method retrieves the suit (spades, hearts, etc.) of this card.
	public int getSuit()
	{
		return suit; 
	}
	
	// This method retrieves the face (ace through king) of this card.
	public int getFace()
	{
		return face; 
	}
	
	// This method retrieves the numerical value of this card
	// (usually same as card face, except 1 for ace and 10 for jack/queen/king)
	public int getValue()
	{
		if (face <= 10)
			return face;
		else 
			return 10;
	}

	// This method allows you to print a card's values
	public String toString(){
	
		char f;
		char s;
		
		if (this.face == Card.ACE)
			f = 'A';
		else if(this.face == Card.JACK)
			f = 'J';
		else if(this.face == Card.QUEEN)
			f = 'Q';
		else if(this.face == Card.KING)
			f = 'K';
		else if(this.face == Card.TEN)
			f = 'T';
			
		switch(this.suit){
		
			case Card.SPADES:
				s = 'S';
				break;
			case Card.DIAMONDS:
				s = 'D';
				break;
			case Card.HEARTS:
				s = 'H';
				break;
			case Card.CLUBS:
				s = 'C';
				break;
			default:
				s = 'E';
		}
		
		return ""+f+"["+s+"]";
	
	}
	
}
