import java.io.*;

interface CreditCard

{
	void viewCreditAmount();
	void increaseLimit();
	void useCard()throws IOException ;
	void payCard()throws IOException;
}

class SliverCardCustomer implements CreditCard
{
	String name;
	String card_no ;
	double creditAmount;
	double creaditLimit;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	SliverCardCustomer()
	{
		name="Noname" ;
		card_no=null;
		creditAmount=0;
		creaditLimit=50000;
	}

	public void viewCreditAmount()
	{
		System.out.println("Your amount is : "+creditAmount) ;
	}

	public void getdata()throws IOException
	{
		System.out.println("Enter the name : ");
		String name = (br.readLine());
		System.out.println("Enter the card number :");

		while(true)
		{
			card_no = br.readLine();
			if(card_no.length() == 16)
				break;
			else
				System.out.println("Invalid Card Number");
		}
	}

	public void payCard()throws IOException
	{
		int payment;
		System.out.println("Your total credited amount is"+creditAmount);
		System.out.println("Payment to be doen.\n1. Full payment.\n2. Partial payment.");
		payment = Integer.parseInt(br.readLine());
		switch(payment)
		{
			case 1:
				{
					double pay = creditAmount;
					creditAmount = creditAmount-pay;
					System.out.println("You have "+creditAmount+" left to pay");
					System.out.println("Thank you for payment you have no dues left.");
					
				}
			break;

			case 2:
				{
					System.out.println("Enter amount to be paid");
					while(true)
					{
						double pay=Double.parseDouble(br.readLine());
						if(pay <= creditAmount && pay > 0 )
						{
							creditAmount=creditAmount-pay;
							System.out.println("Balance is paid");
							System.out.println("Next time you hava to pay"+creditAmount);
							break;
						}	
						else
							System.out.println("Please enter valid amount");
					}
				}
			break;
		}
	}

	public void useCard()throws IOException
	{
		double amount;
		System.out.println("Enter Credit amount : ");
		while(true)
		{
			amount=Double.parseDouble(br.readLine());
			if(amount>0 && amount<=creaditLimit)
			{
				if(creditAmount == creaditLimit)
				{
					System.out.println("Your limit is over");
					break;
				}
				else
				{
					creditAmount += amount;
					break;
				}
			}
			else
				System.out.println("Invalid credit amount reenter the amount");
		}
		viewCreditAmount();
		System.out.println("Thank you for using the service");
	}

	public void increaseLimit()
	{}
}

class GoldCardCustomer extends SliverCardCustomer

{
	GoldCardCustomer()
	{
		name="Noname" ;
		card_no=null;
		creditAmount=0;
		creaditLimit=100000;
	}

	public void increaseLimit()
	{
		int cnt=0;
		cnt = cnt+1;
		if(cnt <= 3)
		{
			creaditLimit = creaditLimit + 5000;
			System.out.println("Your card limit is increased by 5000");
			System.out.println("Enjoy your Gold card with limit of "+creaditLimit);
			System.out.println("\n");
		}
		else
		{
			System.out.println("\tBas na Bhai!\nTu Platinum wala card lele.\n");
		}
	}
}

class CCMain
{
	public static void main(String args[])throws IOException
	{
		int ch ;
        int card;

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter the choise of cards.");
        System.out.println("1. Silver Card\n2. Gold Card");
        card = Integer.parseInt(br.readLine());
        switch(card)
        {
            case 1:
                {
					System.out.println("\tWelcome to Silver card");
                    System.out.println("Enter the info for silver card holder : ");
	            	SliverCardCustomer sc=new SliverCardCustomer();
	            	sc.getdata();

                    do
                    {
                        System.out.println("Give Proper input to proceed");
                        System.out.println("1. Want to pay.\n2. Pay Silver Card credits.\n3. View Silver Credit Amount.");
                        ch=Integer.parseInt(br.readLine());
                        switch(ch)
                        {
                            case 1: sc.useCard();
                            break;
                            case 2: sc.payCard();
                            break;
                            case 3: sc.viewCreditAmount();
                            break;
                        }
                    }while(ch!=0);
                }
            break;

            case 2:
                {
					System.out.println("\tWelcome to Gold card");
                    System.out.println("Enter the info for Gold card holder : ");
		            GoldCardCustomer gc=new GoldCardCustomer();
                    gc.getdata();

                    do
                    {
                        System.out.println("Give input to proceed");
                        System.out.println("1. Want to pay.\n2. Pay Gold Card credits.\n3. View Gold Credit Amount.\n4. Increase Card Limit.");
                        ch=Integer.parseInt(br.readLine());
                        switch(ch)
                        {
                            case 1: gc.useCard();
                            break;
                            case 2: gc.payCard();
                            break;
                            case 3: gc.viewCreditAmount();
                            break;
                            case 4: gc.increaseLimit();
                        }
                    }while(ch!=0);
                }
            break;
        }
	}
}