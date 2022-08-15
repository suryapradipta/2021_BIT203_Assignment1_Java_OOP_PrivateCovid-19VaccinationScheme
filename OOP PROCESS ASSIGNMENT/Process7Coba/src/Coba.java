import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Coba {


    // main method
    public static void main(String[] args)
    {
        // Bufferedreader declaration
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        // string declaration
        String str = "2021 20 19";
        int i;

        // declaring the variable & calling the method with
        // passing string as an argument
        int[] array = method(str);

        // printing the string
        System.out.print("\nString : " + str);
        System.out.println();
        // printing the Integer array
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.print(array[0]);
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
