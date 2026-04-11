class Solution {
    public int minSubArrayLen(int t, int[] nums)
    {
        int s = 0, sum = 0, minLen = Integer.MAX_VALUE;

        for(int e = 0; e < nums.length; e++)
        {
            sum = sum + nums[e];
            if(sum >= t)
            {
                while(sum >= t)
                {
                    minLen = minLen > e - s + 1? e - s + 1 : minLen;
                    sum = sum - nums[s++];
                }
            }
        }    
      return minLen == Integer.MAX_VALUE? 0 : minLen;
    }
}