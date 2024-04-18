public class Main {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                if (i == j) {
                    dist[i][j] = 0;
                }
            }
        }
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int[] neighbors = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    neighbors[i] += 1;
                }
            }
        }
        int minimum = Integer.MAX_VALUE;
        int min_node = 0;
        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[i] <= minimum) {
                minimum = neighbors[i];
                min_node = i;
            }
        }
        return min_node;
    }


    public static void main(String[] args) {
        int nodes = 9;
        int[][] edges = new int[][]{new int[]{0, 6, 7036}, new int[]{2, 3, 6792}, new int[]{6, 8, 5813}, new int[]{0, 2, 5816}, new int[]{5, 7, 8383}, new int[]{1, 8, 2429}, new int[]{0, 4, 2932}, new int[]{3, 7, 3703}, new int[]{5, 8, 3760}, new int[]{4, 5, 973}, new int[]{3, 6, 5989}, new int[]{0, 1, 1098}, new int[]{3, 4, 7315}, new int[]{5, 6, 5274}, new int[]{2, 8, 3566}, new int[]{3, 8, 3590}, new int[]{4, 7, 4223}, new int[]{1, 3, 2540}, new int[]{4, 8, 8536}, new int[]{1, 2, 6250}, new int[]{1, 7, 1757}, new int[]{2, 6, 7826}, new int[]{0, 6, 7036}, new int[]{3, 5, 31}, new int[]{1, 5, 7736}, new int[]{2, 4, 5115}, new int[]{0, 3, 4301}, new int[]{0, 7, 4771}, new int[]{4, 6, 3417}, new int[]{0, 8, 2176}};
        Main obj = new Main();
        int max_dist = 6235;
        System.out.println(obj.findTheCity(nodes, edges, max_dist));
    }
}