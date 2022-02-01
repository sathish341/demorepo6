package arrayss;

import java.util.Scanner;

public class ScanaarayssDemo 
{
	public int m1() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Array Size:");
		int asize = sc.nextInt();
		int [] a = new int[asize];
		
		int sum=0;
		
		System.out.println("Enter array elements:");
		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.nextInt();
			System.out.println("a["+i+"]="+a[i]);
			sum=sum+a[i];
		}
		
		System.out.println("sum of array is :"+sum);
		return sum;
	}
	public static void main(String[] args) 
	{
		ScanaarayssDemo obj = new ScanaarayssDemo();
		int count = obj.m1();
		System.out.println("count of array outside:"+ count);
	}

}
