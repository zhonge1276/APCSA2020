package Unit9;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
		public static int go( List<Integer> ray )
		{
	    int oddIndex = -1;
	    int evenIndex = -1;
	    for (int i = 0; i < ray.size(); i++)
	    {
	      if (ray.get(i) % 2 == 1)
	      {
	        oddIndex = i;
	        break;
	      }
	    }

	    for (int j = ray.size() - 1; j > oddIndex; j--)
	    {
	    if (ray.get(j) % 2 == 0)
	      {
	        evenIndex = j;
	        break;
	      }
	    }

	    if (oddIndex >= 0 && evenIndex >= 0)
	      return evenIndex - oddIndex;

	    else
	      return -1;
	}
}