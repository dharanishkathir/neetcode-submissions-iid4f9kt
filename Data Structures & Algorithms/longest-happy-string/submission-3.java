class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((y,x) -> x[1] - y[1]);
        heap.offer(new int[]{'a' , a});
        heap.offer(new int[]{'b' , b});
        heap.offer(new int[]{'c' , c});
        StringBuilder res = new StringBuilder("");
        Queue<Integer> q = new LinkedList<Integer>();

        int[] prev = new int[2];
        while(!heap.isEmpty())
        {
            int[] cur = heap.poll();
            int len = res.length();
            if((len <= 1 || res.charAt(len-1) != cur[0] || res.charAt(len-2) != cur[0]) && cur[1] >= 1)
            {
                res.append((char)cur[0]);
                cur[1] = cur[1] - 1;
            }
            if(prev[0] != 0)
            {
                heap.offer(prev);
                prev = new int[2];
            }
            if((len <= 1 || (res.charAt(len-1) != cur[0] || res.charAt(len-2) != cur[0])) && cur[1] >= 1)
            {
                heap.offer(cur);
            }
            else if(cur[1] >= 1)
            {
                 prev = cur;
            }
        }
        return res.toString();
    }   
}