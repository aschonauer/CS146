import java.util.Scanner;

class Main {
    static boolean isBadVersion(int version) {
        return version >= 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of versions: ");
        int n = in.nextInt();

        int low = 1;
        int high = n;
        int verNum = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean bad = isBadVersion(mid);
            if (bad) {
                verNum = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        System.out.print("Version " + verNum + " is the first bad version");
    }
}