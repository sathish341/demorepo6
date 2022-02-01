package arrayss;

import java.util.Scanner;

public class Calculation 
{

	public static void main(String[] args) 
	{
		float a,b, res;
		char choice;
		Scanner scan = new Scanner(System.in);
		
		do 
		{
			System.out.print("1.Addition\n");
			System.out.print("2.Substraction\n");
			System.out.print("3.Multiplication\n");
			System.out.print("4.Division\n");
			System.out.print("5.Exit\n");
			System.out.print("Enter your choice:");
			
			choice = scan.next().charAt(0);
			switch(choice) 
			{
			case'1':System.out.println("Enter two numbers:");
			     a =scan.nextFloat();
			     b=scan.nextFloat();
			     res= a + b;
			     System.out.println("Result="+ res);
			     break;
			case'2':System.out.println("Enter two numbers:"); 
			     a=scan.nextFloat();
			     b=scan.nextFloat();
			     res=a-b;
			     System.out.println("Result=" + res);
			     break;
			case'3':System.out.println("Enter two numbers:"); 
			     a=scan.nextFloat();
			     b=scan.nextFloat();
			     res=a*b;
			     System.out.println("Result="+ res);
			     break;
			case'4':System.out.println("Enter two numbers");  
			     a=scan.nextFloat();
			     b=scan.nextFloat();
			     res=a/b;
			     System.out.println("Result="+ res);
			     break;
			case'5':System.exit(0);
			
			default:System.out.println("Wrong choice!!!!");
			     break;
			     
			}
			System.out.println("\n---------------\n");
			
		 }while(choice !=5);

	

	
		
	}

}
