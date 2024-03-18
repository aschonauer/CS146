import java.util.Arrays;

public class Main {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (0 > sr || sr >= image.length || 0 > sc || sc >= image[0].length) {
            return image;
        }
        int og_color = image[sr][sc];
        image[sr][sc] = color;
        if (sr - 1 >= 0 && image[sr - 1][sc] == og_color) {
            image = floodFill(image, sr - 1, sc, color);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == og_color) {
            image = floodFill(image, sr, sc - 1, color);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == og_color) {
            image = floodFill(image, sr + 1, sc, color);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == og_color) {
            image = floodFill(image, sr, sc + 1, color);
        }
        return image;
    }
    public static void main(String[] args) {
        int[][] image = new int[][] {
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1},
                {1, 1, 1}
        };

        Main obj = new Main();
        int[][] filled_image = obj.floodFill(image, 4, 0, 3);
        for (int[] line : filled_image) {
            System.out.println(Arrays.toString(line));
        }
    }
}