package Tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class InputClass {

    public String print(String A){
        System.out.print(A);

        return A;
    }

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
        String output = null;

        System.out.print(A);
        output = input.nextLine();

        return output;
    }
    public int readInt(String A){

        Scanner input = new Scanner(System.in);
        int output = -1;

        String message = "Invalid input";

        try {
            System.out.print(A);
            output = input.nextInt();
            if(!(output >=0)){
                 throw new Exception(); }
        } catch (Exception e) {
            System.out.println(message);
            readInt(A);
        }
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
            System.out.println(message);
            readInt(A);
        }
        return output;




    }


    public String readYN(String A){

        Scanner input = new Scanner(System.in);
        String output=null;

        String message = "Invalid input";

        try {
            System.out.print(A);
            output = input.nextLine();
            if(!(output.equals("y"))  || !(output.equals("n")) ){
                throw new Exception(); }
        } catch (Exception e) {
            System.out.println(message);
            readYN(A);
        }
        return output;
    }

}
