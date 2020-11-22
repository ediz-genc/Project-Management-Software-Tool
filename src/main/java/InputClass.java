import java.util.Scanner;
public class InputClass {

    public String printLine(String A){
        System.out.println(A);

        return A;
    }
    public String readLine(String A){
        Scanner input = new Scanner(System.in);
        String output = null;

        System.out.print(A);
        output = input.nextLine();

        return output;
    }

    }
