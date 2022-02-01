package arrayss;

public class TwoDimensionArray1 
{

	public static void main(String[] args)
	{
		int[][]q= {
				     {1,2,3,4},
				     {5,6,7},
				     {8,9,10,11,12}
		          };
					
		for(int i=0;i<3;i++) 
	    { 
			for(int j=0;j<q[i].length;j++) 
			{
				System.out.print(q[i][j]+" "); 
		    } 
			System.out.println(" "); 
						  
	    }
					 
		for(int k[]:q) 
		{
			for(int l:k) 
			{
				System.out.print(l+"\t ");
			}
			System.out.println("");
		}
		
	}

}
