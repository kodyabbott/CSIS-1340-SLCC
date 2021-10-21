/*
employeefile.txt contains records with an employee's name, the number of hours they worked, and their hourly pay rate.  

Write a program to read the records of information and output (to the Output window or a dialog box) the employee's name and their Gross Pay.

Compute their gross pay by using the following formulas:

If the employee worked 40 hours or less, their pay should be: hours * hourlyPayRate

But if the employee worked more than 40 hours, they get paid their regular amount for the first 40 hours plus "time and a half" for the hours worked over 40.  Time and a half means 1.5 times their hourly pay rate.  Use the following formula:  (40 * hourlyPayRate) + (hours-40) * 1.5 * hourlyPayRate
*/

package kody.abbott.input.from.a.file;

public class KodyAbbottInputFromAFile
{
    public static void main(String[] args) {

        String name;
        double hours, rate;

        InputFile grossPay;
        grossPay = new InputFile("employeefile.txt");

        while (!grossPay.eof()) {
            name = grossPay.readString();
            hours = grossPay.readDouble();
            rate = grossPay.readDouble();

            if (hours <= 40) {
                System.out.println(name + ": " + hours * rate);
            } else {
                System.out.println((name + ": " + ((40 * rate)+(hours-40)*1.5*rate)));
            }
        }
    }
}
