package FrqSet3;

public class Practice3_1 {
public class HiddenWord{
	private String word;
	
	public HiddenWord(String hWord) {
		word = hWord;
	}
}

public String getHint(String guess){
	String hint = "";
	for (int i = 0; i < guess.length(); i++) {
		if (guess.substring(i, i+1).contentEquals(word.substring(i,i+1))) {
			hint += guess.substring(i,i+1);
		} else if (word.indexOf(guess.substring(i,i+1))!= -1) {
			hint += "+";
		} else {
			hint += "*";
		}
	}
	return hint;
}
}
