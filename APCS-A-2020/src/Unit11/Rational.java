package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	private int num;
	private int den;

	//write two constructors
	public Rational() {
		num = 1;
		den = 1;
	}
	
	public Rational(int n, int d) {
		num = n;
		den = d;
	}

	//write a setRational method
	public void setRational(int n, int d) {
		num = n;
		den = d;
	}
	

	//write  a set method for numerator and denominator
	public void setNumDen(int n, int d) {
		num = n;
		den = d;
	}
	


	
	public void add(Rational  other)
	{
		//num1/den1 + num2/den2 
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
		
		int num1 = num;
		int num2 = other.getNum();
		int den1 = num;
		int den2 = other.getDen();
		
		num = (num1* den2 + num2 * den1);
		den = (den1 * den2);


		reduce();
	}

	private void reduce()
	{
		int common = gcd(num, den);
		num = num/common;
		den = den/common;


	}

	private int gcd(int numOne, int numTwo)
	{

		while (numOne !=0 && numTwo !=0) {
			int temp = numTwo;
			numTwo = numOne % numTwo;
			numOne = temp;
		}
		return numOne + numTwo;
	}

	public Object clone ()
	{
		return this;
	}


	//ACCESSORS

	//write get methods for numerator and denominator
	public int getNum()
	  {
	    return num;
	  }

	  public int getDen()
	  {
	    return den;
	  }
	
	public boolean equals( Object obj)
	{
		 Rational temp = (Rational) obj;
		    temp.reduce();

		    if (temp.getNum() == num && temp.getDen() == den)
		      return true;

		return false;
	}

	public int compareTo(Rational other)
	{
		 Rational r = this;
		    int temp1 = other.getNum() * den;
		    int temp2 = other.getDen() * num;

		    if (temp1 < temp2)
		      return 1;
		    
		    else if (temp1 > temp2)
		      return -1;

				return 0;
	}



	
	//write  toString() method
	public String toString(){
	    return num + "/" + den;
	  }
	
	
}