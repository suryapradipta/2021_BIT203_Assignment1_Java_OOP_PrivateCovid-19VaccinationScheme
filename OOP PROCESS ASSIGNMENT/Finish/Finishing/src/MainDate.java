import java.util.Calendar;
import java.util.Scanner;

public class MainDate {
    public static void main(String[] args)  {


        Calendar today = Calendar.getInstance();
        Calendar expires = Calendar.getInstance();
        String str = "2021 10 2";
        int[] array = method(str);
        expires.set(array[0], array[1], array[2]);
        if (today.after(expires)) {
            System.err.println("This software is expired.");
            System.out.println(expires);
        }
        System.out.println(today.getTime());
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
