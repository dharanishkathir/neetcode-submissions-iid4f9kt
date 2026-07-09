class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]) == 0? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        for(int i = 0; i < nums.length; i++)
        {
            pq.offer(new int[]{nums[i], i});
        }
       
        for(int i = 0; i < k; i++)
        {
            int [] small = pq.poll();
            small[0] = multiplier * small[0];
            pq.offer(small);
        }

        while(!pq.isEmpty())
        {
           int[] entry = pq.poll();
           nums[entry[1]] = entry[0];
        }
        return nums;
    }
}