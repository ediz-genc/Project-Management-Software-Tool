package Tools;

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

    public int readInt(String A){

        Scanner input = new Scanner(System.in);
        int output = -1;

        String message = "Invalid input";

        try {
            System.out.println(A);
            output = input.nextInt();
            if(!(output >=0)){
                 throw new Exception(); }
        } catch (Exception e) {
            System.out.println(message);
            readInt(A);

        }
        return output;


    }

    }
