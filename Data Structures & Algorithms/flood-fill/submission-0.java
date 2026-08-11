class Solution {

    boolean visited[][];
    int color;
    int from;
    int dir[][] = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        visited = new boolean[image.length][image[0].length];
        this.color = color;
        this.from = image[sr][sc];
        dfs(image, sr, sc);
        return image;  
    }

    private void dfs(int[][] image, int r, int c)
    {
        visited[r][c] = true;
        image[r][c] = color;
        int m = image.length, n = image[0].length;
        image[r][c] = color;
        for(int i = 0; i < 4; i++)
        {
            int row = r + dir[i][0], col = c + dir[i][1];
            if(!(row < 0 || col < 0 || row == m || col == n || visited[row][col]) && image[row][col] == from)
            {
                image[row][col] = color;
                dfs(image, row, col);
            }
        }
    }
}