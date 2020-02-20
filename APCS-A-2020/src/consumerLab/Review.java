package consumerLab;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  
  private static final String SPACE = " ";
  
  static{
    try {
      Scanner input = new Scanner(new File("src/ConsumerLab/cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("src/ConsumerLab/positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("src/ConsumerLab/negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }//end sentimentVal
  
  
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static int getPunctuationIndex( String word )
  { 
    int pind = -1;
    for(int i=word.length()-1; i >= 1; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        pind = i;
      } 
      }
    
    return pind;
  }
  
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective(int pn)
  {
    boolean positive = Math.random() < .5;
    if(pn==1){
      return randomPositiveAdj();
    } else if(pn==-1){
      return randomNegativeAdj();
    }
    else{
    	if(positive)
          return randomPositiveAdj(); 
    	else
          return randomNegativeAdj();
    }
  }

/** Activity 2: totalSentiment()
  * Write the code to total up the sentimentVals of each word in a review.
 */
  public static double totalSentiment(String filename)
  {
    // read in the file contents into a string using the textToString method with the filename
	  String rev = textToString(filename);
	  System.out.println(rev);
    // set up a sentimentTotal variable
	  double sentimentTotal = 0;
    // loop through the file contents 

       // find each word
	  int s = 0;
String[] words = rev.split(" ");
for(String w : words){
	if(!Character.isLetterOrDigit(w.charAt(0)))
		s = 1;
	int i = getPunctuationIndex(w);
	if(i==-1)
		sentimentTotal+=sentimentVal(w.substring(s));
	
	else
		sentimentTotal+=sentimentVal(w.substring(s, i));
}


       // add in its sentimentVal
       // set the file contents to start after this word
   


   return sentimentTotal; 
  }


  /** Activity 2 starRating method
     Write the starRating method here which returns the number of stars for the review based on its totalSentiment.
  */
  public static int starRating(String filename)
  {
    // call the totalSentiment method with the fileName
double sent = totalSentiment(filename);
    // determine number of stars between 0 and 4 based on totalSentiment value 
    int stars = 0;
    // write if statements here
    if(sent>-1)
    	stars = 1;
    if(sent>5)
    	stars = 2;
    if(sent>10)
    	stars = 3;
    if(sent>15)
    	stars = 4;
  
    // return number of stars
    return stars; 
  }
  
  
  public static String fakeReview(String fileName, int pn){
	String rev = textToString(fileName);
	int ind = rev.indexOf('*');
	if (ind==-1)
		return rev;
	String fake = "";
	int start = 0;
	while(ind!=start-1){
		fake+=rev.substring(start, ind)+randomAdjective(pn);
		start = (rev.substring(ind)).indexOf(' ')+ind;
		ind = (rev.substring(start)).indexOf('*')+start;
	}
	fake+=rev.substring(start);
	return fake;
  }
}