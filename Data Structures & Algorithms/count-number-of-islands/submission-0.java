class Solution {
    boolean visited[][];
    int [][]dirs = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0,1}};

    public int numIslands(char[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;
        Deque<int[]> q = new LinkedList<int[]>();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == '1' && !visited[i][j])
                {
                    count++;
                    q.offer(new int[]{i , j});
                    visited[i][j] = true;
                    while(!q.isEmpty())
                    {
                        int[]cur = q.poll();
                        int r = cur[0], c = cur[1];
                        for(int p = 0; p < dirs.length; p++)
                        {
                            int row = r + dirs[p][0], col = c + dirs[p][1];
                            if(!(row < 0 || col < 0 || row == grid.length || col == grid[0].length || visited[row][col] || grid[row][col] == '0') )
                            {
                                q.offer(new int[]{row, col});
                                visited[row][col] = true;
                            }
                        }
                    }
                }
            } 
        }
        return count;
    }
}
