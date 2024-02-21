import java.util.*;

public class Main {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> array = new ArrayList<List<Integer>>(nums.length);
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i+1; j < nums.length - 1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>(3);
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        if(!array.contains(triplet))
                            array.add(triplet);
                    }
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main obj = new Main();

        System.out.print("Enter length of Array: ");
        int length = in.nextInt();
        int[] numArray = new int[length];

        for(int i = 0; i < length; i++) {
            System.out.print("Enter an integer of the Array: ");
            int num = in.nextInt();
            numArray[i] = num;
        }

        List<List<Integer>> triplets;
        triplets =  obj.threeSum(numArray);
        System.out.print(triplets.toString());
    }
}