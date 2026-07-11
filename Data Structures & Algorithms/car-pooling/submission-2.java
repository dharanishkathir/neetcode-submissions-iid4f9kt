class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(a[1],b[1]) == 0 ? Integer.compare(a[2],b[2]) : Integer.compare(a[1],b[1]));
         PriorityQueue<int[]> runs = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(a[0],b[0]) == 0 ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));
        int rem = capacity;
        for(int i = 0; i < trips.length; i++)
        {
            pq.offer(trips[i]);
        }
        while(!pq.isEmpty())
        {
            int[] trip = pq.poll();
            while(!runs.isEmpty())
            {
                int[] run = runs.peek();
                if(run[0] <= trip[1])
                {
                    rem += run[1];
                    runs.poll();
                }
                else
                {
                    break;
                }
            }
            if(rem >= trip[0])
            {
                runs.offer(new int[]{trip[2], trip[0]});
                rem -= trip[0];
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}