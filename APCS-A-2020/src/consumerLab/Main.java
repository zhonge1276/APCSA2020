package consumerLab;

import java.io.File;
import java.util.Scanner;


class Main {
  public static void main(String[] args) {
	//test reading from files
	//read in the positive adjectives in postiveAdjectives.txt

		
		System.out.println("good: "+Review.sentimentVal("good"));
		System.out.println("goods: "+Review.sentimentVal("goods"));
		System.out.println("cool: "+Review.sentimentVal("cool"));
		System.out.println("crazy: "+Review.sentimentVal("crazy"));
		
		String fileName = "src/ConsumerLab/simpleReview.txt";
		System.out.println(Review.totalSentiment(fileName)+"\n");
		System.out.println(Review.starRating(fileName)+" stars\n");
		
		fileName = "src/ConsumerLab/26WestReview.txt";
		System.out.println(Review.totalSentiment(fileName)+"\n");
		System.out.println(Review.starRating(fileName)+" stars\n");
		
		fileName = "src/ConsumerLab/onlineReview.txt";
		System.out.println(Review.totalSentiment(fileName)+"\n");
		System.out.println(Review.starRating(fileName)+" stars\n");
		
		fileName = "src/ConsumerLab/simpleReview.txt";
		System.out.println("\n"+Review.fakeReview(fileName, 1));
		
		fileName = "src/ConsumerLab/26WestReview.txt";
		System.out.println("\n"+Review.fakeReview(fileName, 0));
		
		fileName = "src/ConsumerLab/onlineReview.txt";
		System.out.println("\n"+Review.fakeReview(fileName, -1));
		
		
		
		
	try {
	Scanner input = new Scanner(new File("src/ConsumerLab/simpleReview.txt"));
	while(input.hasNextLine()){
	String temp = input.nextLine().trim();

	}
	input.close();
	}
	catch(Exception e){
	System.out.println("Error reading or parsing simpleReview.txt\n" + e);
	}
  }
}