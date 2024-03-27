import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public HashMap<Integer, Integer> countInDegrees(int[][] array_list) {
        HashMap<Integer, Integer> inDegrees = new HashMap<>();
        for (int[] pair: array_list) {
            inDegrees.put(pair[0], 0);
            inDegrees.put(pair[1], 0);
        }
        for (int[] pair: array_list) {
            int x = inDegrees.get(pair[0]) + 1;
            inDegrees.put(pair[0], x);
        }
        return inDegrees;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        HashMap<Integer, Integer> in_degrees = countInDegrees(prerequisites);
        for (int key: in_degrees.keySet()) {
            if (key < 0 || key >= numCourses) {
                return false;
            }
            if (in_degrees.get(key) == 0) {
                queue.add(key);
            }
        }
        while (!queue.isEmpty()) {
            int node_key = queue.remove();
            sorted.add(node_key);
            for (int[] pair: prerequisites) {
                if (pair[1] == node_key) {
                    int x = in_degrees.get(pair[0]) - 1;
                    in_degrees.put(pair[0], x);
                    if (in_degrees.get(pair[0]) == 0) {
                        queue.add(pair[0]);
                    }
                }
            }
        }
        return sorted.size() == in_degrees.size();
    }
    public static void main(String[] args) {
        int courses = 4;
        int[][] prereq = {{1, 2}, {2, 0}, {3, 0}, {3, 1}};
        Main obj = new Main();
        System.out.println(obj.canFinish(courses, prereq));
        System.out.println("Expected: true\n");
        courses = 5;
        int[][] prereq2 = {{1, 2}, {2, 0}, {3, 0}, {3, 1}, {0, 1}};
        System.out.println(obj.canFinish(courses, prereq2));
        System.out.println("Expected: false\n");
        courses = 4;
        int[][] prereq3 = {{1, 2}, {2, 0}, {0, 1}};
        System.out.println(obj.canFinish(courses, prereq3));
        System.out.println("Expected: false\n");
    }
}