class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int g : gifts)
        {
            heap.offer(-g);
        }
        for(int i = 0 ; i < k; i++)
        {
            int max = -heap.poll();
            heap.offer(- (int) Math.sqrt(max));
        }
        int res = 0;
        while(!heap.isEmpty())
        {
            res = res + heap.poll();
        }
        return -res;
    }
}