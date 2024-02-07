import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an array of integers separated by a space: ");
        String str = in.nextLine();

        String[] strNums = str.split(" ");
        int[] nums = new int[strNums.length];
        for(int i = 0; i < strNums.length; i++) {
            nums[i] = Integer.parseInt(strNums[i]);
        }

        for(int i = 1; i < nums.length; i++) {
            int item = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > item) {
                nums[j+1] = nums[j];
                nums[j] = item;
                j -= 1;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}