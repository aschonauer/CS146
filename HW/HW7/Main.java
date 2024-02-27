import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        if(intervals.length == 0) { return 0; }

        int servers = 1;
        for(int i = 1; i < intervals.length; i++) {
            int low = intervals[i-1][0];
            int high = intervals[i-1][1];
            int num = intervals[i][0];
            if(low <= num && num < high) {
                servers++;
            }
        }
        return servers;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of intervals: ");
        int length = in.nextInt();
        int[][] intervals = new int[length][2];
        for(int i = 0; i < length; i++) {
            System.out.print("Input pair ex. 0,1: ");
            String str = in.next();
            String[] numbs = str.split(",");
            int[] pair = new int[]{Integer.parseInt(numbs[0]), Integer.parseInt(numbs[1])};
            intervals[i][0] = pair[0];
            intervals[i][1] = pair[1];
        }
        Main obj = new Main();
        int server = obj.minMeetingRooms(intervals);
        System.out.print(server);
    }
}