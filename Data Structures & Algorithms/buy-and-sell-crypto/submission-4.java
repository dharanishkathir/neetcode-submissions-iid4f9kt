class Solution {
    public int maxProfit(int[] p) {
        
        int max = 0;
        int buy = p[0];
        for(int i = 1; i < p.length; i++)
        {
            if(buy < p[i])
            {
                max = max > p[i] - buy? max: p[i] - buy;
            }
            else
            {
                buy = p[i];
            }
        }
        return max;
    }
}
