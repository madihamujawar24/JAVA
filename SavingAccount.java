import java.util.*;
class SavingAccount
{
    private static double annualInterestRate;
    private double savingbalance;
	
	public SavingAccount(double savingbalance)
	{
	   this.savingbalance=savingbalance;
	}
	
	public void calculatemonthlyInterest()
	{
	     double monthlyInterest=(savingbalance*annualInterestRate/12);
		 savingbalance+=monthlyInterest;
    }
	
	public static void modifyInterestRate(double newRate)
	{
	    annualInterestRate=newRate;
	}
	
	public double getSavingBalance()
	{
	  return savingbalance;
	}
	
	public static void main(String [] args)
	{
	
	SavingAccount saver1= new SavingAccount(2000);
	SavingAccount saver2= new SavingAccount(3000);
	
	SavingAccount.modifyInterestRate(0.05);
	saver1.calculatemonthlyInterest();
	saver2.calculatemonthlyInterest();
	
	System.out.println("saver 1 bal :"+saver1.getSavingBalance());
	System.out.println("saver 2 bal :"+saver2.getSavingBalance());
	}
}
	
	
	
  