package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;
import java.util.Random;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	public RockPaperScissors()
	{
    playChoice = "";
    compChoice = "";
	}

	public RockPaperScissors(String player)
	{
    playChoice = player;
    compChoice = setComputer();
	}

	public void setPlayers(String player)
	{
    playChoice = player;
    compChoice = setComputer();
	}
  private String setComputer() 
  {
    int random = (int)(3*Math.random());
    if (random == 0)
      return "r";
    if (random == 1)
      return "p";
    if (random == 2)
      return "s";
    return "";
  }

	public String determineWinner()
	{
    String winner = "";
  
    if (compChoice.equals(playChoice)) 
      winner = "Draw Game";
    if (playChoice.equals("r") && compChoice.equals("p"))
      winner = "Computer wins <<Paper Covers Rock>>";
    if (playChoice.equals("r") && compChoice.equals("s"))
      winner = "Player wins <<Rock Breaks Scissors>>";
    if (playChoice.equals("s") && compChoice.equals("r"))
      winner = "Computer wins <<Rock Breaks Scissors>>";
    if (playChoice.equals("s") && compChoice.equals("p"))
      winner = "Player wins <<Scissors Cut Paper>>";
    if (playChoice.equals("p") && compChoice.equals("r"))
      winner = "Player wins <<Paper Covers Rock>>";
    if (playChoice.equals("p") && compChoice.equals("s"))
      winner = "Computer wins <<Scissors Cut Paper>>";
		return winner;
	}

	public String toString()
	{
		String output = "player had " + playChoice + "\n" + "computer had " + compChoice + "\n" + determineWinner();
		return output;
	}
} 