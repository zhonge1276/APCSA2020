package Celebrity;

import java.util.ArrayList;

public class DanceCelebrity extends Celebrity{
	
	private ArrayList<String> clueList;
	
	public DanceCelebrity(String answer, String clues)
	{
		super(answer, clues);
		processClues();
	}
	
	private void processClues()
	{
		String [] clues = super.getClue().split(",");
		clueList = new ArrayList<String>();
		for (String currentClue : clues)
		{
			clueList.add(currentClue);
		}
	}
	
	@Override
	public String getClue()
	{
		if (clueList.size() == 0)
		{
			processClues();
		}
		String currentClue = clueList.remove(0);
		
		return currentClue;
	}
	
	
	@Override
	public String toString()
	{
		String dsc = "This is the dance celebrity: " + getAnswer() + "\nThe clues are:\n";
		
		for (String word : super.getClue().split(","))
		{
			dsc += word + "\n";
		}
		
		return dsc;
	}

}
