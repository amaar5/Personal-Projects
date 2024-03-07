package finalTestingTwo;

import java.util.Scanner;

class Debit {

    Scanner in = new Scanner(System.in);
    //Instance Variables
    private String name;
    private String cardNum;
    private String expDate;
	  private int pin;
    private int accID;
    private CheckAcc myCheckAcc;
    private String bank;


    //Constructors (debit)

    public Debit() {
	   	setName("------ ------");

   		setCardNum("0000000000000000");
   		setExpDate("00/00");
   		setPin(000);
   		setID(9999); //Set the ID for the normal debit constructor to 9999.

    }

    public Debit(String nameInput, String cardNumInput, String expDateInput, int pinInput, CheckAcc checkAcc, int i, String initBank) {
    	setName(nameInput);
    	setCardNum(cardNumInput);
    	setExpDate(expDateInput);
    	setPin(pinInput);
    	myCheckAcc = checkAcc;
    	setID(i);
    	setBank(initBank);
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~Accessor Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public String getName() {
		return name;
    }

    public double getBalance() {
    	return myCheckAcc.getTotalAmt();
    }

    public String getCardNum() {
    	return cardNum;
    }

    public String getExpDate() {
    	return expDate;
    }

    public int getPin() {
    	return pin;
    }

     public int getID() { //*************
     	return accID;
     }

     public CheckAcc getCheckAcc() {
       return myCheckAcc;
     }

     public String getBank() {
    	 return bank;
     }

    public String toString() {
    	return "Card Details:\n" + "\tType: Debit\n" + "\tHolder Name: " + name + "\n" + "\tBalance: $" + this.getBalance() + "\n" + "\tCard Number: " + cardNum + "\n" + "\tExperation Date: " + expDate + "\n" + "\tPin: " + pin + "\n" + "\tLinked Account: " + this.getName() + "\n" + "\tLocal Card ID Number: " + this.getID() + "\n" + "\tParent bank: " + this.getBank();
    }


//~~~~~~~~~Mod Methods~~~~~~~~~~~~

    public void setName(String name) {
    	this.name = name;
    }

//    public void setBalance(double balance) {
//    	this.balance = balance;
//    }

    public void setCardNum(String cardNum) {
    	this.cardNum = cardNum;
    }


	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setID(int ID) {
    this.accID = ID;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	//Other Methods

	public void transaction(double cost) {
		double balance = myCheckAcc.getTotalAmt();
		if(cost > balance) {
			System.out.println("Error: Insufficent Funds");
		} else {
			balance = balance - cost;
	    }

		myCheckAcc.modTotalAmt(balance);
		System.out.println("New balance on debitcard: " + this.getBalance());
    }

	public void spend(double price) {

    	System.out.println("\n\n\n");
    	this.transaction(price);

    	System.out.println("\n");
    	System.out.println("Would you like to withdraw cash?");
    	System.out.println("If yes, enter amount. If not, enter 0.\n");

    	double withdraw = in.nextInt();

    	this.transaction(withdraw);
    }

	public void deposit(double amount) {
		double balance = myCheckAcc.getTotalAmt();
		balance += amount;
		myCheckAcc.modTotalAmt(balance);
		System.out.println("New balance on debitcard: " + this.getBalance());
	}

	public boolean verify() {
	   return true;
	}
}
