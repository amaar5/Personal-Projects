package finalTestingTwo;

import java.util.Scanner;

@SuppressWarnings("resource")
class CheckAcc {
  Scanner input = new Scanner(System.in);
    
  private double startAmt = 100.00;
  private double intRate = .06;
  private double totalAmt = 0;
  
  private String name;
  private String user;
  private String pass;
  private String[][] accounts =  {{"user1"},{"pass1"}};
  private int ID;
    
  public CheckAcc() {
           totalAmt = startAmt;
       }
        //sets account details
  public CheckAcc(String user, String pass) {
           this.user = user;
           this.pass = pass; 
       }
  public CheckAcc(String n, double a, double b, int d) {
    name = n;
    startAmt = a;
    intRate = b;
    totalAmt = startAmt;
    ID = d;
  }
  
  public boolean loginCheck() {
    if((user.equals(accounts[0][0])) && (pass.equals(accounts[1][0]))) {
      return true;   
    } else {
      return false;
    }
  }
       //checks amount of money in bank
   
//~~~~~~~~~Accessor methods~~~~~~~~~~
  public double getStartamt() {
    return startAmt;
  }
   
  public double getIntRate() {
    return intRate;
  }
  
  public double getTotalAmt() {
    return totalAmt;
  }

  public String getName() {
    return name;
  }

  public int getID() {
    return ID;
  }
  
  public String toString() {
	  return "Account Details: \n" + "\n\tName of Holder: " + name + "\n\tBalance: $" + totalAmt + "\n\tInterest Rate: " + intRate + "%\n\tAccount ID: " + ID + "\n";
  }

//~~~~~~~~~Mod Methods~~~~~~~~~~~~~

  public void modIntRate(double x) {
    intRate = x;
  }

  public void modTotalAmt(double x) {
    totalAmt = x;
  }

  public void setID(int IDInput) {
    ID = IDInput;
  }
       
//~~~~~~~~Interesting Methods~~~~~~~~~
  
  public void takeOut(double cost) {
		double balance = this.getTotalAmt();
		if(cost > balance) {
			System.out.println("Error: Insufficent Funds");
		} else {
			balance = balance - cost;
			balance = (double)Math.round(balance*100)/100;
	    }
		
		modTotalAmt(balance);
		System.out.println("New balance on account" + this.getID() +  ": " + this.getTotalAmt());
  }
  
  public void putIn(double cost) {
		double balance = this.getTotalAmt();
		if(cost > balance) {
			System.out.println("Error: Insufficent Funds");
		} else {
			balance = balance + cost;
			balance = (double)Math.round(balance*100)/100;
	    }
		
		modTotalAmt(balance);
		System.out.println("New balance on " + this.getID() +  ": " + this.getTotalAmt());
  }

  public double depositMoney() {

           System.out.println("Enter how much money you want to deposit");
           double depositAmt = input.nextDouble();
           totalAmt = totalAmt + depositAmt;
           totalAmt = (double)Math.round(totalAmt*100)/100;
           System.out.println("New balance: " + totalAmt);
           return totalAmt;
       }
   
   public double withdrawMoney() {

           System.out.println("Enter how much money you want to withdraw");
           double withdrawAmt = input.nextDouble();
           totalAmt = totalAmt - withdrawAmt;
           totalAmt = (double)Math.round(totalAmt*100)/100;
           System.out.println("New balance: " + totalAmt);
           return totalAmt;
       }
       //calculate interest after x years
       //A = P(1 + r/n)^nt
   
   public double interestCalc () {
           Scanner year = new Scanner(System.in);
           int years = year.nextInt();
           totalAmt = (totalAmt * Math.pow((1 + intRate / 12), (12 * years)));
           return totalAmt;
       }
    
   public boolean verify() {
	   return true;
   		}
    
   }
