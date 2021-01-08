package Tools;

import java.util.Scanner;
public class InputClass {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public String printLine(String A){
        System.out.println(A);
        return A;
    }

    public char readChar(String userMessage) {

        Scanner input = new Scanner(System.in);
        System.out.println(userMessage);
        char charText = input.next().charAt(0);
        charText = Character.toUpperCase(charText);
        
        return charText;
    }
    public String readLine(String A){

        Scanner input = new Scanner(System.in);

        System.out.print(A);
        String output = input.nextLine();
        return output;
    }
    public int readInt(String A){

        Scanner input = new Scanner(System.in);
        System.out.print(A);
        int output = input.nextInt();
        int x = 0;

        String message = "Invalid input";

        return output;
    }
    public double readDouble(String A){

        Scanner input = new Scanner(System.in);
        double output = -1;

        String message = "Invalid input";

        try {
            System.out.print(A);
            output = input.nextDouble();
            if((output -(int)output==0)){
                throw new Exception(); }
        } catch (Exception e) {
            System.out.println(ANSI_RED+message+ANSI_RESET);
            readInt(A);
        }
        return output;
    }
    public String readYN(String A){

        Scanner input = new Scanner(System.in);
        String output=null;

        String message = "Invalid input, choose between 'y' or 'n'";

        try {
            System.out.print(A);
            output = input.nextLine();
            if(!output.equals("y")){
                throw new Exception(); }
            else if(!output.equals("n")) {
                throw new Exception(); }
        } catch (Exception e) {
            System.out.println(ANSI_RED+message+ANSI_RESET);
            readYN(A);
        }
        return output;
    }

}
