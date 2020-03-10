package Celebrity;
/**
 * Starts the Celebrity Game application
 * @author cody.henrichsen
 *
 */
public class CelebrityRunner
{
	/**
	 * The entry point of the Java application.
	 * @param args Unused parameter as it is a GUI based program.
	 */
	public static void main(String [] args)
	{
		Celebrity newCeleb = new Celebrity("Dwayne Johnson", "Rock");
		System.out.println(newCeleb);
		newCeleb.setAnswer("Kate Winslet");
		System.out.println(newCeleb);
		System.out.println("The clue is " + newCeleb.getClue() );
		CelebrityGame game = new CelebrityGame();
		game.play();

	}
}
