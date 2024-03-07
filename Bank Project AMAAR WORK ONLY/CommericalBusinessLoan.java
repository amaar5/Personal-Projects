import java.util.Scanner;

public class CommericalBusinessLoan {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("--Welcome to the Commerical Business Loan Section--");
        System.out.print("1. Enter the down payment as a percentage that you will be making: ");
        double downpay = scan.nextDouble();
        if (downpay < 30) {

            System.out.println("Sorry you have been denied a commerical business loan due to a insufficient amount.");

        } else if (downpay >= 100) {
            System.out.println("Not a possible input.");

        } else {
            System.out.print("2. Enter Loan Amount : $");
            double loanamount = scan.nextDouble();
            double lint = 0;

            if (downpay <= 40) {
                lint = 3.5;

            } else if (downpay <= 50) {
                lint = 3.0;
            } else if (downpay <= 70) {
                lint = 2.2;
            }
            double decimal = (downpay / 100);
            double cz = (loanamount * decimal);
            double a = (loanamount - cz);
            double b = ((lint / 100) + 1);

            System.out.print("3. Enter Time period in years : ");
            double c = scan.nextDouble();
            c = c * 12;
            double d = c;
            int value = (int) Math.round(d);

            double pay = Payment(a, b, c);
            System.out.println("Payment Per Month: $" + pay);
            System.out.println("This payment is for " + value + " months");

        }
    }

    static double Payment(double p, double r, double t) {
        double m = (p * r) / (1 - Math.pow(1 + r, -t));
        m = Math.round(m * 100) / 100;
        double j = (m / t);
        return j;
    }
}