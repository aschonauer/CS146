import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word to test if it is a palindrome: ");
        String word = in.nextLine();
        word = word.toLowerCase();
        word = word.replace(" ", "");
        int length = word.length();
        char[] letters = new char[length];
        char[] original = new char[length];

        for (int i = 0; i < length; i++) {
            letters[i] = word.charAt(i);
            original[i] = word.charAt(i);
        }

        int half = length/2;
        for (int i = 0; i < half; i++) {
            char letter = letters[i];
            int mirror = length - i - 1;
            letters[i] = letters[mirror];
            letters[mirror] = letter;
        }

        if (Arrays.equals(letters, original)) {
            System.out.print("true");
        }
        else {
            System.out.print("false");
        }
    }
}
