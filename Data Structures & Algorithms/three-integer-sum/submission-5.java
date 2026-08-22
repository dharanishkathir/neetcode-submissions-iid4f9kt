class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < nums.length - 2; i++)
        {
            int j = i+1, k = nums.length-1;
            if(i > 0 && nums[i] == nums[i-1]) 
                continue;
            while(j < k)
            {
                int sum = nums[i] + nums[j]+ nums[k];
                if(sum == 0)
                {
                    res.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
                    j++; k--;
                    while(j < k && nums[j-1] == nums[j])
                    {
                        j++;
                    }
                }
                else if(sum > 0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        return res;

    }

   
}