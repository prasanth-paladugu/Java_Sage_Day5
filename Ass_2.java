//Create you own bank application exception

import java.util.Scanner;
public class Ass_2
{
	public static void main(String arg[])
	{
		Scanner pp = new Scanner(System.in);
		System.out.print("How Many Customer You Want to Create : ");
		int n = pp.nextInt();
		Customer C[] = new Customer[n];

		for(int i=0;i<C.length;i++)
		{
			C[i] = new Customer();
			C[i].addCustomer();
		}

		int ch;
		do
		{
			System.out.println("Main Menu :");
			System.out.println("1.Add new Customer");
			System.out.println("2.Delete Customer");
			System.out.println("3.Edit Customer");
			System.out.println("4.Exit");
			System.out.println("Enter Your Choice :");
			ch = pp.nextInt();
			switch(ch)
			{
				case 1:
					for(int i=0;i<C.length;i++)
					{
						C[i] = new Customer();
						C[i].addCustomer();
					}
					break;

				case 2:
					System.out.print("Enter Account Number You Want to Delete : ");
					int acn = pp.nextInt();
					boolean found = false;
					for(int i=0;i<C.length;i++)
					{
						found = C[i].find(acn);
						if(found)
						{
							C[i].deleteCustomer();
							System.out.println("Account Deleted");
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed..Account Does Not Exist..");
					}
					break;

				case 3:
					System.out.print("Enter Account Number You Want to Edit : ");
					acn = pp.nextInt();
					found=false;
					for(int i=0;i<C.length;i++)
					{
						found=C[i].search(acn);
						if(found)
						{
							C[i].deposit();
							C[i].withdrawal();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed..Account Not Exist..");
					}
					break;

				case 4:
					System.out.print("--THANK YOU FOR BANKING--");
					break;
			}
		}
		while(ch!=4);
	}
}

class Customer
{
	int acc_no;
	String name;
	long balance;
	Scanner cust = new Scanner(System.in);

	void addCustomer()
	{
		System.out.print("Enter Account No: ");
		acc_no = cust.nextInt();
		System.out.print("Enter Name: ");
		name = cust.next();
		System.out.print("Enter Balance: ");
		balance = cust.nextLong();
	}

	boolean find(int acn)
	{
		if(acc_no == acn)
		{
			return(true);
		}
		return(false);
	}

	void deleteCustomer()
	{
		acc_no = 0;
		name = "";
		balance = 0L;
	}

	void showAccountDetails()
	{
		System.out.println(acc_no + "," + name + "," + balance);
	}

	void deposit()
	{
		System.out.println("Enter Amount U Want to Deposit : ");
		long amt = cust.nextLong();
		balance = balance + amt;
	}

	void withdrawal()
	{
		System.out.println("Enter Amount You Want To Withdraw : ");
		long amt = cust.nextLong();
		try
		{
			if(balance < amt)
			{
				throw new MinimumAccountBalance("Insufficient funds !");
			}
			else
			{
				System.out.println("TAKE THE MONEY");
				balance = balance - amt;
			}
		}
		catch (MinimumAccountBalance mab)
		{
			mab.printStackTrace();
		}
	}

	class MinimumAccountBalance extends Exception
	{
		String message;
		public MinimumAccountBalance(String message)
		{
			this.message = message;
		}
	}

	boolean search(int acn)
	{
		if(acc_no == acn)
		{
			showAccountDetails();
			return(true);
		}
		return(false);
	}
}