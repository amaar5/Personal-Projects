public class SavingsAccount {
    public static void main(String[] args) {

    }

    private double annualInterestRate;
    private double totalDeposits;
    private double totalWithdraws;
    private double balance;
    private double totalInterest;

    public SavingsAccount(double startBalance, double annualInterestRate) {
        balance = startBalance;
        this.annualInterestRate = annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void deposit(double amount) {
        balance += amount;
        totalDeposits += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
        totalWithdraws += amount;
    }

    public void accrueMonthlyInterest() {
        double monthlyInterest = balance * getMonthlyInterestRate();
        totalInterest += monthlyInterest;
        balance += monthlyInterest;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getTotalDeposits() {
        return totalDeposits;
    }

    public double getTotalWithdraws() {
        return totalWithdraws;
    }

    public double getTotalnterest() {
        return totalInterest;
    }
}