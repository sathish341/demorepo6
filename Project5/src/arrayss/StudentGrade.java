      package arrayss;

import java.util.Scanner;

public class StudentGrade 
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no of subjects");
		int subs = scan.nextInt();
		int []marks = new int[subs];
		System.out.println("Enter marks ");
		
		float sum=0, avg;
		
		
		for(int i=0;i<marks.length;i++) 
		{
			marks[i] = scan.nextInt();
			sum = sum + marks[i];
			
		}
		System.out.println("Sum is:"+ sum);
		
		avg = sum/subs;
		System.out.println("Average is:"+ avg);
		
		if(avg>80) 
		{
			System.out.println("Grade A");
		}
		else if(avg<=80 && avg>60)
		{
			System.out.println("Grade B");
		}
		else if(avg<=60 && avg>40)
		{
			System.out.println("Grade c");
		}
		else 
		{
			System.out.println("Grade D");
		}
			
			
	}

}
