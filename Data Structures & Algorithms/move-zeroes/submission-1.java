class Solution {
    public void moveZeroes(int[] nums) {
        
        int i = 0 , j = 1;
        for(; j < nums.length && i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                while(j < nums.length && nums[j] == 0)
                {
                    j++;
                }
                if(j < nums.length && nums[j] != 0)
                {
                    int t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                }
            }
            j++;
        }
    }
}