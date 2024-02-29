import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public int LongestPalindrome(String s) {
        ArrayList<String> pal = new ArrayList<String>();
        String[] letters = s.split("");
        Arrays.sort(letters);
        String empty = "EMPTY";
        for(int i = 0; i < letters.length; i++) {
            for(int j = i + 1; j < letters.length; j++) {
                if(letters[i].equals(letters[j]) && !letters[i].equals(empty) && !letters[j].equals(empty)) {
                    pal.add(0, letters[i]);
                    pal.add(pal.size(), letters[j]);
                    letters[i] = empty;
                    letters[j] = empty;
                }
            }
        }
        for(String letter: pal) {
            if(!letter.equals(empty)) {
                pal.add(pal.size() / 2, letter);
                break;
            }
        }
        return pal.size();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.next();
        Main obj = new Main();
        int size = obj.LongestPalindrome(str);
        System.out.print("Length of longest palindrome: " + size);
    }
}