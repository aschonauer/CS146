import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("This program will check if 2 words are anagrams");
        System.out.print("Enter first word/phrase: ");
        String word1 = in.nextLine();
        System.out.print("Enter second word/phrase: ");
        String word2 = in.nextLine();
        word1 = word1.toLowerCase().replace(" ", "");
        word2 = word2.toLowerCase().replace(" ", "");

        String[] letters1 = word1.split("");
        String[] letters2 = word2.split("");

        Arrays.sort(letters1);
        Arrays.sort(letters2);

        if (Arrays.equals(letters1, letters2)) {
            System.out.print("true");
        }
        else {
            System.out.print("false");
        }
    }
}