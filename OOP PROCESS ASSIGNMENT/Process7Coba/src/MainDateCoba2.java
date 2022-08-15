import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDateCoba2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s[]= scanner.nextLine().split(" ");
        int[] a = new int[3];
        for(int i = 0; i < a.length; i++){
            a[i]= Integer.parseInt(s[i]);
        }
        System.out.println(a[0] + a[1] + a[2]);
    }
}
