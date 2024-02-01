import java.util.Scanner;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        //Create Scanner object
        Scanner in = new Scanner(System.in);

        //Take in length of array and initialize the array nums
        System.out.print("Enter length of the array: ");
        int length = in.nextInt();
        int[] nums = new int[length];

        //Take in each element of the array
        for (int i = 0; i < length; i++) {
            System.out.print("Enter an element of the array: ");
            nums[i] = in.nextInt();
        }

        //Take in the target sum
        System.out.print("Enter the target sum number: ");
        int target = in.nextInt();

        //Create Hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i], target - nums[i]);
        }

        //Check hashmap for valid key value pair in the array to make the target sum
        for (int i = 0; i < length; i++) {
            int num = map.get(nums[i]);
            if (map.containsKey(num)) {
                for (int j = i+1; j < length; j++) {
                    if (num == nums[j]) {
                        System.out.println("index 1: " + i + "\nindex 2: " + j);
                    }
                }
            }
        }
    }
}