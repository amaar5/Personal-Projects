import java.util.Scanner;

public class MortgageLoan {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("--Welcome to the Mortgage Loan Sector--");
        System.out.print("1. Enter your credit score: ");
        int cs = scan.nextInt();
        if (cs < 500) {

            System.out.println("Sorry you have been denied a mortgage loan due to a poor credit score.");

        } else if (cs >= 851) {
            System.out.println("Not a possible credit score.");

        } else {
            System.out.print("2. Enter Loan Amount : $");
            double a = scan.nextDouble();
            double lint = 0;

            if (cs <= 600) {
                lint = 3.5;

            } else if (cs <= 700) {
                lint = 3.0;
            } else if (cs <= 850) {
                lint = 2.2;
            }

            double b = (lint / 100) / 12;

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
        return m;
    }
}