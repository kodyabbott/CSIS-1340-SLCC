package amortizationkodyabbott;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Amortizationkodyabbott
{

    String name, address, city, state;
    int zip, month, day, year, code;
    double amount = 0, rate = 0;

    JFrame jf;
    JTextArea jta;
    JScrollPane jsp;

    public Amortizationkodyabbott()
    {
        jf = new JFrame("Amortization");
        jta = new JTextArea();
        jsp = new JScrollPane(jta);

        jf.setSize(700, 700);
        jf.setLocation(500, 250);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.add(jsp);
        jf.setVisible(true);
    }

    public static void main(String[] args)
    {
        Amortizationkodyabbott amort = new Amortizationkodyabbott();

        amort.displayReport();
    }

    public void displayReport()
    {
        InputFile loaninfo;
        loaninfo = new InputFile("fcrc loan data.txt");

        while (!loaninfo.eof())
        {
            name = loaninfo.readString();
            address = loaninfo.readString();
            city = loaninfo.readString();
            state = loaninfo.readWord();
            zip = loaninfo.readInt();
            month = loaninfo.readInt();
            day = loaninfo.readInt();
            year = loaninfo.readInt();
            amount = loaninfo.readDouble();
            rate = loaninfo.readDouble();
            code = loaninfo.readInt();

            displayHeading(name, address, city, state, zip, month, day, year, amount, code, rate);
            displayTable(amount);

        }
    }

    public void displayHeading(String name, String address, String city, String state, int zip, int month, int day, int year, double amount, int code, double rate)
    {
        DecimalFormat deciFormat;
        deciFormat = new DecimalFormat("0.00");
        NumberFormat currencyFormat;
        currencyFormat = NumberFormat.getCurrencyInstance();

        jta.append("\nFirst Community Redevelopment Corporation\n");
        jta.append("101 1st Street\n");
        jta.append("Bloomington, TN 41663\n");
        jta.append("\n");
        jta.append("\t\t\t\t\t" + name + "\n");
        jta.append("\t\t\t\t\t" + address + "\n");
        jta.append("\t\t\t\t\t" + city + ", " + state + ",  " + zip + "\n");
        jta.append("\n");
        jta.append("LOAN AMOUNT:\t\t" + currencyFormat.format(amount) + "\n");
        jta.append("INTEREST RATE:\t\t" + deciFormat.format(rate * 100) + "%\n");
        jta.append("\n");
        jta.append("Payment #\tDue Date\t\tPayment\tInterest\tPrincipal\tBalance\n");
        jta.append("----------------------------------------------------------------------------------\n");
    }

    public void displayTable(double amount)
    {
        int payNum;

        double payment = 0, interest, principal, balance;

        DecimalFormat numFormat;
        numFormat = new DecimalFormat("0.00");
        NumberFormat currencyFormat;
        currencyFormat = NumberFormat.getCurrencyInstance();
        balance = amount;
        payNum = 0;
        double totalPay = 0;
        double totalIntPaid = 0;
        while (balance > 0)
        {

            ++payNum;
            String dueDate = calcDate(month, day, year, payNum - 1);
            interest = calcInt(balance, rate);
            if (balance <= payment)
            {
                payment = balance;
                principal = balance;
                balance = 0;
            } else
            {
                payment = calcPayment(code, amount);
                principal = calcPrinci(payment, interest);
                balance = calcBal(balance, principal);
            }
            totalPay += payment;
            totalIntPaid += interest;
            jta.append("   " + payNum + "\t" + dueDate + "\t\t$" + numFormat.format(payment) + "\t" + currencyFormat.format(interest) + "\t" + currencyFormat.format(principal) + "\t" + currencyFormat.format(balance) + "\n");

        }
        jta.append("\n");
        jta.append(" " + "\t\t" + " " + "\t" + "Totals: " + currencyFormat.format(totalPay) + "\t" + currencyFormat.format(totalIntPaid) + "\n");
        jta.append("\n\n");

    }

    public double calcInt(double balance, double rate)
    {
        double interest;
        interest = rate / 12 * balance;
        return interest;
    }

    public double calcPrinci(double payment, double interest)
    {
        double principal;

        principal = payment - interest;
        return principal;
    }

    public double calcBal(double balance, double princ)
    {
        balance -= princ;
        return balance;
    }

    public double calcPayment(int code, double amount)
    {
        double payment;
        payment = 0;

        switch (code)
        {
            case 0 -> payment = 50.00;
            case 1 -> payment = 55.00;
            case 2 -> payment = 75.00;
            case 3 -> payment = 100.00;
            case 4 -> payment = .05 * amount;
            case 5 -> payment = .06 * amount;
            case 6 -> payment = .05 * amount;
            case 7 -> payment = .04 * amount;
            case 8 -> payment = .03 * amount;
            case 9 -> payment = .02 * amount;
            default -> System.out.println("Bad payment code");
        }
        return payment;
    }

    public String calcDate(int month, int day, int year, int payNumber)
    {
        String monthStr = "";
        month = month + payNumber + 1;
        year = year + (month / 12);
        month = month % 12;
        if (month == 0)
        {
            --year;
        }
        switch (month)
        {
            case 1 -> monthStr = "Jan.";
            case 2 -> monthStr = "Feb.";
            case 3 -> monthStr = "Mar.";
            case 4 -> monthStr = "Apr.";
            case 5 -> monthStr = "May";
            case 6 -> monthStr = "Jun.";
            case 7 -> monthStr = "Jul.";
            case 8 -> monthStr = "Aug.";
            case 9 -> monthStr = "Sept.";
            case 10 -> monthStr = "Oct.";
            case 11 -> monthStr = "Nov.";
            case 0 -> monthStr = "Dec.";
            default -> System.out.println("Invalid month: " + month);

        }
        return monthStr + " " + "1" + ", " + year;
    }
}
