
import java.util.Scanner;
public class InputClass {

    public String printLine(String A){
        System.out.println(A);

        return A;
    }
    public String readLine(String A){
        Scanner input = new Scanner(System.in);
        String output = null;

        System.out.println(A);
        output = input.nextLine();

        return output;
    }
    //Let's you as a user type at the same line:
    public String readLine1(String A){
        Scanner input = new Scanner(System.in);
        String output = null;

        System.out.print(A);
        output = input.nextLine();

        return output;
    }
}
