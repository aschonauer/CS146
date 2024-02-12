import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int prev1 = 0;
        int prev2 = 0;
        int num = 0;

        System.out.print("Enter an integer to find its fibonacci number: ");
        int n = in.nextInt();

        if(n > 1) {
            num = 1;
        }

        for(int i = 2; i < n; i++) {
            prev1 = prev2;
            prev2 = num;
            num = prev1 + prev2;
        }

        System.out.print("Fibonacci number: " + num);
    }
}