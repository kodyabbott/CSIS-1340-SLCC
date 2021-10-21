/*
Write a program to get input from the user using dialog boxes. 

The program should repeatedly input 3 pieces of information:  An employee's full name, their hourly rate of pay, and the total number of hours that they worked during the previous week.  

The program should write this information to a OutputFile. 

When this program ends, you will have a text file that will have records with 3 fields of information in each record and would look something like this:

"Bob Jones"  40.0  10.25
"Sam Smith"  45.5  15.00
"Jodi White"  32.25  20.50

Notice that the name has quotes around it (use the writeString( ) method to automatically put quotes around the employee's name).

The hours and pay rate must not have quotes around.
*/

package out.to.a.file.kody.abbott;

public class OutToAFileKodyAbbott {

    public static void main(String[] args)
    {
        OutputFile empFile;
        empFile = new OutputFile("employeefile.txt");
        String name, rate, hours, answer;
        Keyboard k;
        k = new Keyboard();

        do {
            System.out.println("Enter employee name: ");
            name = k.readLine();
            System.out.println("Enter employee rate: ");
            rate = k.readWord();
            System.out.println("Enter employee hours: ");
            hours = k.readWord();
            empFile.writeString(name);
            empFile.writeWord(rate);
            empFile.writeWord(hours);
            empFile.writeEOL();

            System.out.println("Do you want to enter another employee? (y/n)");
            answer = k.readWord();
        } while (answer.equals("y"));
        empFile.close();
    }
}