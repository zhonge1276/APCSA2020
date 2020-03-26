package Celebrity;
/**
 * Celebrity base class for the Celebrity game.
 * @author cody.henrichsen
 * @version 1.4 17/09/2018
 */
public class Celebrity
{
	/**
	 * The clue to determine the celebrity
	 */
	private String answer;
	private String clue;
	/**
	 * The answer or name of the celebrity.
	 */
	
	/**
	 * Creates a Celebrity instance with the supplied answer and clue
	 * @param answer
	 * @param clue
	 */
	public Celebrity(String ans, String cl)
	{
		setAnswer(ans);
		setClue(cl);;
	}

	/**
	 * Supplies the clue for the celebrity
	 * @return
	 */
	public String getClue()
	{
		return clue;
	}

	/**
	 * Supplies the answer for the celebrity.
	 * @return
	 */
	public String getAnswer()
	{
		return answer;
	}

	/**
	 * Updates the clue to the provided String.
	 * @param clue The new clue.
	 */
	public void setClue(String cl)
	{
		clue = cl;
	}

	/**
	 * Updates the answer to the provided String.
	 * @param answer The new answer.
	 */
	public void setAnswer(String ans)
	{
		answer = ans;
	}
	
	/**
	 * Provides a String representation of the Celebrity.
	 */
	@Override
	public String toString()
	{
		return "The clue given was " + clue + ".\n The Answer is " + answer + ".";
	}
	
}