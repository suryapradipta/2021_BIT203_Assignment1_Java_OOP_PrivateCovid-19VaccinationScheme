import java.util.Calendar;
import java.util.Scanner;

public class MainDate {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        Calendar today = Calendar.getInstance();
        Calendar expires = Calendar.getInstance();


        int[] vars = new int[3];
        System.out.println("yyyy mm dd: ");
        for(int i = 0; i < vars.length; i++) {
            vars[i] = input.nextInt();
        }
        expires.set(vars[0], vars[1], vars[2]);
        if (today.after(expires)) {
            System.err.println("This software is expired.");
            System.out.println(expires);

        }
        System.out.println(today.getCalendarType());
        System.out.println(vars[0] + vars[1] + vars[2]);
    }
}
