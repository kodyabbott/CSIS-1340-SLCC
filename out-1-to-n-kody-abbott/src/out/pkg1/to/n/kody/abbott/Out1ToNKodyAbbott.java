// Ask the user for a positive whole number > 0, call it N.  
// Output all the numbers from 1 up to N on the screen.

package out.pkg1.to.n.kody.abbott;

public class Out1ToNKodyAbbott {

    public static void main(String[] args) {
    
        Keyboard k;
        k = new Keyboard();
        System.out.println("Enter a positive whole number > 0: ");
        int n = k.readInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
}