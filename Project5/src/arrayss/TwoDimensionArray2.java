package arrayss;

import java.util.Scanner;

public class TwoDimensionArray2 
{

	public static void main(String[] args) 
	{
		int[][] a = new int[3][3];
		Scanner scan = new Scanner(System.in);
		/*
		 * System.out.println("Enter row and column size"); int r = new scan.nextInt();
		 * int c= new scan.nextInt(); int[][]a = new int[r][c] ;
		 */
		
		
		System.out.println("Enter array elements");
		for(int i=0;i<3;i++) 
		{
			for(int j=0; j<3;j++) 
			{
				a[i][j]=scan.nextInt();
				System.out.print("a["+i+"]["+j+"]=" +a[i][j]+" ");
			}
			System.out.println(" ");
		}
		

	}

}
