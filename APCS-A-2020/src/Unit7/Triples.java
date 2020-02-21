package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
    number = num;
	}

	public void setNum(int num)
	{
    number = num;
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = Math.max(a,Math.max(b,c));
    for (int i = max/2; i > 1; i--) {
      if (a%i==0 && b%i==0 && c%i==0) {
        return i;
      }
    }
    return 1;
	}

  private String getTriples() {
    String triples = "";
    for (int a = 1; a < number; a++) {
      for (int b = 1; b < number; b++) {
        for (int c = 1; c < number; c++) {
          if (Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2)) {
            if ((a%2==0 && b%2==1) || (a%2==1 && b%2==0)) {
              if (c%2 == 1) {
                if (greatestCommonFactor(a, b, c) == 1) {
                  triples += a + " " + b + " " + c + "\n";
                }
              }
            }
          }
        }
      }
    }
    return triples;
  }

	public String toString()
	{
		return getTriples();
	}
}