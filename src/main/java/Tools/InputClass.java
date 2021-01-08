package Tools;

import java.util.Scanner;
public class InputClass {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    static private String YN = null;
    static private int level = 0;
    public String print(String A){
        System.out.print(A);

        return A;
    }
    public String printLine(String A){
        System.out.println(A);
        return A;
    }
    public int printInt(int A){
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
    
    public String readLetter(String A){
    
            Scanner input = new Scanner(System.in);
    
            System.out.print(A);
            String output = input.next();
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
        String output = null;

        String message = "Invalid input, choose between 'y' or 'n'";

        try {
            System.out.print(A);
            output = input.nextLine();
            if(output.equals("y")){
                setYN(output);
            } else if(output.equals("n")) {
            setYN(output);
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            System.out.println(ANSI_RED+message+ANSI_RESET);
            readYN(A);
        }
        return getYN();
    }

    public void setYN(String output){
    this.YN = output;
    }

    public String getYN(){
    return YN;
    }
    public int read123(String A) {

        Scanner input5 = new Scanner(System.in);
        int output = 0;
        String message = "Invalid input, Choose a number between 1-3.";

        try {
            System.out.print(A);
            output = input5.nextInt();
            if (output == 1) {
                setReadLevel(output);
            } else if (output == 2) {
                setReadLevel(output);
            } else if (output == 3) {
                setReadLevel(output);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + message + ANSI_RESET);
            read123(A);
        }
        return getLevel();

    }

   public void setReadLevel(int level){
   this.level = level;

   }
   public int getLevel(){
   return level;
   }

}
