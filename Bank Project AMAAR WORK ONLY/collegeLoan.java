package finalTestingTwo;

import java.util.Scanner;

@SuppressWarnings("unused")
class collegeLoan {

    public int loan;
    public double interest;
    public double loanCost;
    public double newLoan;

    public collegeLoan(){
        loan = 0;
        interest = 0;
    }

    public collegeLoan(int loanAmount, double interestAmount){
        loan = loanAmount;
        interest = interestAmount;
        newLoan = loanAmount;
    }

    public double calculateInterest(){
        loanCost = interest/100 * loan;
        return loanCost;
    }

    public void payLoan(double payment){
        newLoan = loan + loanCost - payment;
    }

    public double getNewLoan() {
      return newLoan;
    }

    public int getLoanAmount(){
        return loan;
    }

    public double getInterestAmount(){
        return interest;
    }
}
