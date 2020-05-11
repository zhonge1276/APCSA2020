package FRQSet2;

public class Practice2_1 {
private String recombine(String word1, String word2) {
	return word1.substring(0, word1.length() / 2) + word2.substring(word2.length() / 2);
}

private String[] mixedWords(String[] words) {
	String[] result = new String[words.length];
	for (int k = 0; k < result.length; k = k +2) {
		result[k] = recombine(words[k], words[k+1]);
		result [k+1] = recombine (words[k + 1], words[k]);
	}
	return result;
}
}
