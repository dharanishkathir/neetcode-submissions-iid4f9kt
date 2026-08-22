class Solution {
    public int search(int[] nums, int t) {
        
       int l = 0, r = nums.length - 1;
       while(l <= r)
       {
            int mid = l + (r - l)/2;
            if(nums[mid] == t)
            {
                return mid;
            }
            else if(nums[mid] > t)
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
       }
       return -1;
    }
}
