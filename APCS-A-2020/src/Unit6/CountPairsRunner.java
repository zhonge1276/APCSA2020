package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*; 

public class CountPairsRunner
{
	public static void main( String[] args )
	{
		CountPairs s = new CountPairs();
		System.out.println( CountPairs.pairCounter("test_cases") );
	    System.out.println(s.pairCounter("ddogccatppig")) ;
	    System.out.println(s.pairCounter("dogcatpig")) ;
	    System.out.println(s.pairCounter("xxyyzz")) ;
	    System.out.println(s.pairCounter("a")) ;
	    System.out.println(s.pairCounter("abc")) ;
	    System.out.println(s.pairCounter("aabb")) ;	
	}
}