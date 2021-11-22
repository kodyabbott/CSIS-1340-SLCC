package sprocketswitharraykodyabbott;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Sprocketswitharraykodyabbott
{

    JFrame jf;
    JTextArea jta;
    JScrollPane jsp;

    public Sprocketswitharraykodyabbott()
    {

        jf = new JFrame("SPACELY SPROCKETS w/ARRAY");
        jta = new JTextArea();
        jsp = new JScrollPane(jta);

        jf.setSize(550, 500);
        jf.setLocation(500, 250);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.add(jsp);
        jf.setVisible(true);
    }

    public static void main(String[] args)
    {
        Sprocketswitharraykodyabbott report = new Sprocketswitharraykodyabbott();
        report.displayReport();
    }

    public void displayReport()
    {
        int spNumber, quantity;
        int part[];
        part = new int[51];

        InputFile orderInfo;
        orderInfo = new InputFile("November Orders.txt");

        jta.append("\t\t    SPACELY SPROCKETS\n");
        jta.append("\t                  Taking Sprockets Into The Future\n\n");
        jta.append("\t\t    Sales Summary Report\n\n");
        jta.append("\tSprocket Number____________________Total Quantity Sold\n\n");

        while (!orderInfo.eof())
        {
            spNumber = orderInfo.readInt();
            quantity = orderInfo.readInt();
            part[spNumber] += quantity;
        }

        for (int i = 1; i <= 50; i++)
        {
            if (part[i] != 0)
            {
                jta.append("\t          " + i + "\t\t\t" + part[i] + "\n\n");
            }
        }
    }
}
