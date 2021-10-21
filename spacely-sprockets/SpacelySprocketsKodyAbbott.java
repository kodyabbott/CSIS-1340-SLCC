/*
Write a Java program to summarize the data from the input file sprocketorders.txt and output a report that should resemble Figure 13-16 on page 246 in the text.  
The report should appear in the NetBeans output window when theprogram runs.
You must use the switch statement. 
 */
package spacely.sprockets.kody.abbott;

public class SpacelySprocketsKodyAbbott {
    public static void main(String[] args) {

        int spNumber = 0, quantity = 0;
        int part1 = 0, part2 = 0, part3 = 0, part4 = 0, part5 = 0;

        InputFile orderInfo;
        orderInfo = new InputFile("sprocketorders.txt");

        System.out.println("                 SPACELY SPROCKETS");
        System.out.println("          Taking Sprockets Into The Future");
        System.out.println("     ");
        System.out.println("               Sales Summary Report");
        System.out.println("     ");
        System.out.println("Sprocket Number_____________" + "_______Total Quantity Sold");

        while (!orderInfo.eof()) {

            spNumber = orderInfo.readInt();

            quantity = orderInfo.readInt();

            switch (spNumber) {
            case 1:
                part1 += quantity;

                break;

            case 2:
                part2 += quantity;

                break;

            case 3:
                part3 += quantity;

                break;

            case 4:
                part4 += quantity;

                break;

            case 5:
                part5 += quantity;

                break;

            default:
                System.out.println("Bad sprocket number");
            }

        }
        System.out.println("       1       " + "           " + "                 " + part1);
        System.out.println("       2       " + "           " + "                 " + part2);
        System.out.println("       3       " + "           " + "                 " + part3);
        System.out.println("       4       " + "           " + "                 " + part4);
        System.out.println("       5       " + "           " + "                 " + part5);
    }

}
