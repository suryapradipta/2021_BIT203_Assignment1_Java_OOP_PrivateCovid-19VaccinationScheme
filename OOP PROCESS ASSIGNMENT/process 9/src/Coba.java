import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Coba {


    // main method
    public static void main(String[] args)
    {


        // string declaration
        String str = "12 20 2019";


        // declaring the variable & calling the method with
        // passing string as an argument
        int[] array = method(str);

        // printing the string
        System.out.println("\nString : " + str);

        // printing the Integer array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
    }
    static int[] method(String str)
    {

        String[] splitArray = str.split(" ");
        int[] array = new int[splitArray.length];

        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }
}
