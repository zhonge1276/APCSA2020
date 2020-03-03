package Eleven;


public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	//instance variables
		//String suit
	private String suit;
		//int face
	private int face;
	private String rank;
	
	private int points;
	
	//private int face;
  	//constructors


	// modifiers
		//set methods
	public Card(String cardSuit, int faceVal) {
		suit=cardSuit;
		face = faceVal;
	}
	
	public Card(String cardRank, String cardSuit, int cardPointValue) {
		rank=cardRank;
		suit=cardSuit;
		points=cardPointValue;
	}

  	//accessors
		//get methods


  	//toString
	public String getSuit() {
		return suit;
	}
		
	public String getRank() {
		return rank;
	}
	
	public int getFace() {
		return face;
	}
	public int getPoint() {
		return points;
	}
	
	public void setSuit(String cardSuit) {
		this.suit=cardSuit;
	}
	
	public void setRank(String cardRank) {
		this.rank=cardRank;
	}
	
	public void setFace(int faceVal) {
		this.face=faceVal;
		
	}
	
	public void setPoint(int pointVal)
	{
		this.points=pointVal;
	}
	public String toString() {
		return FACES[face] + " of " + suit;
	}
	
 }