//Create five different threads to find out primenumber, ever or not, perfect or not, palidrome or not */
import java.util.Scanner;
public class Ass_3
{
    public static void main(String args[])
    {
		System.out.print("Enter the number : ");
		Scanner pp = new Scanner(System.in);
		int x = pp.nextInt();
		PrimeNumber t1 = new PrimeNumber();
		t1.run(x);
		EvenOrOdd t2 = new EvenOrOdd();
		t2.run(x);
		PerfectNumber t3 = new PerfectNumber();
		t3.run(x);
		Palindrome t4 = new Palindrome();
		t4.run(x);
	}
}

//Thread 1
class PrimeNumber extends Thread
{
	public void run(int a)
    {
		int flag = 0;
		int i = 0;
		if(a==0||a==1)
		{
		   System.out.println(a+" is not prime number");
		}
		else
		{
		   for(i=2;i<a;i++)
		   {
			   if(a%i==0)
				{
				   System.out.println(a+" is not prime number");
				   flag = 1;
				   break;
				}
			}
			if(flag==0)
			{
					System.out.println(a+" is prime number");
			}
		}
	}
}

//Thread 2
class EvenOrOdd extends Thread
{
	public void run(int a)
	{
		if(a%2==0)
		{
			System.out.println(a+" is EVEN");
		}
		else
		{
			System.out.println(a+" is ODD");
		}
	}
}

//Thread 3
class PerfectNumber extends Thread
{
	public void run(int a)
    {
		int add = 0;
		for(int x = 1; x < a; x++)
		{
			if(a % x == 0)
			{
				add = add + x;
			}
		}
		if(add == a)
		{
			System.out.println(a + " is a Perfect number");
	    }
	    else
	    {
		    System.out.println(a + " is not a Perfect number");
        }
	}
}

//Thread 4
class Palindrome extends Thread
{
	public void run(int a)
    {
		int r,sum = 0;
		int temp = a;
		while(temp > 0)
		{
			r = temp%10;
		   	sum =(sum*10)+r;
		   	temp = temp/10;
		}
		if(a == sum)
		{
			System.out.println(a + " is palindrome number.");
		}
		else
		{
			System.out.println(a + " is not palindrome");
		}
	}
}