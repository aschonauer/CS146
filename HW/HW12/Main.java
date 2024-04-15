import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int cost = 0;
        ArrayList<Integer> current_visited = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        HashMap<Integer, int[][]> adj_list = new HashMap<>();

        // house: house connection, cost
        for (int[] pipe: pipes) {
            adj_list.put(pipe[0] - 1, new int[][]{new int[]{pipe[1] - 1, pipe[2]}});
            adj_list.put(pipe[1] - 1, new int[][]{new int[]{pipe[0] - 1, pipe[2]}});
        }

        int min_well = wells[0];
        int current = 0;
        for (int i = 0; i < wells.length; i++) {
            int well_cost = wells[i];
            if (well_cost < min_well) {
                min_well = well_cost;
                current = i;
            }
        }
        current_visited.add(current);
        visited.add(current);
        cost += min_well;

        // Prim's algorithm on every disjoint set, except wells can also be a weight to be considered
        while (visited.size() < n) {
            int min_cost = Integer.MAX_VALUE;
            for (int house: current_visited) {
                for (int[] line: adj_list.get(house)) {
                    int well_cost = wells[line[0]];
                    int line_cost = line[1];
                    int min_weight = Math.min(well_cost, line_cost);
                    if (!current_visited.contains(line[0])) {
                        min_cost = min_weight;
                        current = line[0];
                    }
                }
            }
            if (!current_visited.contains(current)) {
                current_visited.add(current);
                visited.add(current);
                cost += min_cost;
            }
            else {
                ArrayList<Integer> new_list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (!visited.contains(i)) {
                        new_list.add(i);
                    }
                }
                current_visited = new ArrayList<>();
                min_well = Integer.MAX_VALUE;
                for (int house: new_list) {
                    int well_cost = wells[house];
                    if (min_well > well_cost) {
                        min_well = well_cost;
                        current = house;
                    }
                }
                current_visited.add(current);
                visited.add(current);
                cost += min_well;
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.print("Minimum Cost: " + obj.minCostToSupplyWater(4, new int[]{1, 5, 8, 2}, new int[][]{new int[]{1, 2, 3}, new int[]{3, 4, 5}}));


    }
}