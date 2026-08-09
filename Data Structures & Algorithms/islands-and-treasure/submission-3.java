class Solution {

    int INF = 2147483647;
   

    public void islandsAndTreasure(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new LinkedList<int[]>();
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 0)
                    q.offer(new int[]{i, j});
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty())
        {
            int cur[] = q.poll();
            int row = cur[0], col = cur[1];
            for(int[] dir : dirs)
            {
                int i = row + dir[0], j = col + dir[1];
                if(i == m || i < 0 || j == n || j < 0 || grid[i][j] != Integer.MAX_VALUE)
                {
                    continue;
                }
                q.offer(new int[]{i, j});
                grid[i][j] = grid[row][col] + 1;
            }
        }

        


    }

   
}
