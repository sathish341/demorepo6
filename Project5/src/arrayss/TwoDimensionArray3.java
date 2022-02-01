package arrayss;

public class TwoDimensionArray3 
{

	public static void main(String[] args) 
	{
		int [][] b = new int[3][3];	
		b[0][0]=10;
		b[0][1]=20;
		b[0][2]=30;
		
		b[1][0]=40;
		b[1][1]=50;
		b[1][2]=60;
		
		b[2][0]=70;
		b[2][1]=80;
		b[2][2]=90;
		
		/*
		 * for(int i=0;i<3;i++) { for(int j=0;j<3;j++) { System.out.print(b[i][j]+" ");
		 * } System.out.println(" "); }
		 */
		
		//for each loop
		for(int k[]:b)
		{
			for(int l: k) 
			{
				System.out.print(l+" ");
			}
			System.out.println("");
		}
		
		
		
		
		
				
	}

}
