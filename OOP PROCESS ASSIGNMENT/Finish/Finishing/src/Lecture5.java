import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lecture5 {
    public static void main(String[] args) {

        boolean done = false;
        while (!done)		// loop until integer obtained!
            try{
                System.out.print("Enter an integer :");
                int val = getInteger();
                System.out.println("You entered " + val);
                done = true;	// no exceptions thrown, so done
            }
            catch(NumberFormatException e)
            {
                System.out.println("You didn't enter an integer");
            }
            catch(IOException io)
            {
                System.out.println(io.getMessage());
            }











    }
    public static int getInteger() throws IOException {
        // declare a large byte array
        byte [] buffer = new byte[512];
        // characters entered stored in array
        System.in.read(buffer);
        // make string from byte array
        String s = new String (buffer);
        // trim string
        s = s.trim();
        // converts string to an 'int'
        int num = Integer.parseInt(s);
        // send back integer value
        return num;

    }

}
