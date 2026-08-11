class Solution {

    boolean visited[][];
    int[][] dirs = new int[][]{{0,-1}, {0, 1}, {-1, 0}, {1, 0}};

    public int islandPerimeter(int[][] grid)
    {
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c)
    {
        visited[r][c] = true;
        int m = grid.length, n = grid[0].length;
        int cur = 0;
        for(int i = 0; i < dirs.length; i++)
        {
            int row = r + dirs[i][0], col = c + dirs[i][1];
            if(row < 0 || col < 0 || m == row || n == col || grid[row][col] == 0)
            {
                cur++;
            }
            else if(!visited[row][col])
            {
                
                cur = cur + dfs(grid, row, col);
            }
        }
        return cur;
    }
}