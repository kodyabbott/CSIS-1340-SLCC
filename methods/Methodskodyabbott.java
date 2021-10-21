package methodskodyabbott;

public class Methodskodyabbott {
    public static void main(String[] args)

    {

        Keyboard k;
        k = new Keyboard();
        int a, b, c;

        System.out.print("Enter the 1st side - (Enter -1 to stop): ");
        a = k.readInt();
        while (a != -1) {
            System.out.print("Enter the 2nd side: ");
            b = k.readInt();
            System.out.print("Enter the 3rd side: ");
            c = k.readInt();
            System.out.println("The triangle is " + triangleType(a, b, c));
            System.out.print("Enter the 1st side of a triangle - (Enter -1 to stop): ");
            a = k.readInt();
        }
    }

    public static String triangleType(int n1, int n2, int n3) {
        int a, b, c;
        if (n1 < n2) {
            if (n1 < n3) {
                a = n1;
                if (n2 < n3) {
                    b = n2;
                    c = n3;
                } else {
                    b = n3;
                    c = n2;
                }
            } else {
                a = n3;
                b = n1;
                c = n2;
            }
        } else {
            if (n2 < n3) {
                a = n2;
                if (n1 < n3) {
                    b = n1;
                    c = n3;
                } else {
                    b = n3;
                    c = n1;
                }
            } else {
                a = n3;
                b = n2;
                c = n1;
            }
        }
        if (a + b <= c) {
            return "INVALID TRIANGLE";
        }
        if (a == c) {
            return "EQUILATERAL";
        }
        if (a == b || b == c) {
            return "ISOSCELES";
        }
        return "SCALENE";
    }
}