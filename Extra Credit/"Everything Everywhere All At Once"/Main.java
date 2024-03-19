import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Takes in hashmap for a graph and converts it to matrix of graph
    public int[][] listToMatrix(HashMap<Integer, ArrayList<Integer>> adj_list) {
        int[][] m = new int[adj_list.size()][adj_list.size()];
        int i = 0;
        for (int row_key: adj_list.keySet()) {
            int j = 0;
            for (int col_key: adj_list.keySet()) {
                // for every row if it has the column key it sets the value of the position to true (1)
                // otherwise it sets it to false (0)
                if (adj_list.get(row_key).contains(col_key)) {
                    m[i][j] = 1;
                }
                else {
                    m[i][j] = 0;
                }
                j++;
            }
            i++;
        }
        return m;
    }

    // Takes in a matrix of a graph and converts it to a hashmap of a graph
    public HashMap<Integer, ArrayList<Integer>> matrixToList(int[][] m) {
        HashMap<Integer, ArrayList<Integer>> adj_list = new HashMap<>();
        int row_num = 0;
        for (int[] row: m) {
            row_num++;
            // make a new arraylist for each key(row)
            adj_list.put(row_num, new ArrayList<Integer>());
            int col_num = 0;
            for (int num : row) {
                col_num++;
                // if the num is true in the matrix add the column index to the
                // array list under the current row key
                if (num == 1) {
                    adj_list.get(row_num).add(col_num);
                }
            }
        }
        return adj_list;
    }

    // Takes hashmap of graph and reverses the edge directions
    public HashMap<Integer, ArrayList<Integer>> reverseEdgesList(HashMap<Integer, ArrayList<Integer>> g_list) {
        HashMap<Integer, ArrayList<Integer>> new_g = new HashMap<>();
        // create new list for each og key
        for (int key: g_list.keySet()) {
            new_g.put(key, new ArrayList<>());
        }
        // add og keys to list of the new keys
        for (int key: g_list.keySet()) {
            for (int num: g_list.get(key)) {
                new_g.get(num).add(key);
            }
        }
        return new_g;
    }

    // Takes directed matrix graph g and reverses its directions
    public int[][] reverseEdgesMatrix(int[][] g) {
        int[][] matrix = new int[g[0].length][g.length];
        // reflect matrix over top left to bottom right diagonal
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                matrix[j][i] = g[i][j];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> adjacency_list = new HashMap<>();
        adjacency_list.put(1, new ArrayList<Integer>(List.of(3)));
        adjacency_list.put(2, new ArrayList<Integer>(List.of(4)));
        adjacency_list.put(3, new ArrayList<Integer>(List.of(5, 6, 7)));
        adjacency_list.put(4, new ArrayList<Integer>(List.of(5, 6, 7)));
        adjacency_list.put(5, new ArrayList<Integer>(List.of(8)));
        adjacency_list.put(6, new ArrayList<Integer>(List.of(8)));
        adjacency_list.put(7, new ArrayList<Integer>(List.of(8)));
        adjacency_list.put(8, new ArrayList<Integer>());

        Main obj = new Main();
        System.out.println("Adjacency List to Matrix: ");
        int[][] matrix = obj.listToMatrix(adjacency_list);
        for (int[] line: matrix) {
            System.out.println(Arrays.toString(line));
        }

        System.out.println("\nAdjacency Matrix to List: ");
        HashMap<Integer, ArrayList<Integer>> new_list = obj.matrixToList(matrix);
        for (int key: new_list.keySet()) {
            System.out.println(key + ": " + new_list.get(key));
        }

        System.out.println("\nThe directed graph Adjacency List reversed: ");
        HashMap<Integer, ArrayList<Integer>> reversed_l = obj.reverseEdgesList(adjacency_list);
        for (int key: reversed_l.keySet()) {
            System.out.println(key + ": " + reversed_l.get(key));
        }

        System.out.println("\nThe directed graph Adjacency Matrix reversed: ");
        int[][] reversed_m = obj.reverseEdgesMatrix(matrix);
        for (int[] line: reversed_m) {
            System.out.println(Arrays.toString(line));
        }
    }
}