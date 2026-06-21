class Solution {
    public int mySqrt(int x) {
        
        if(x <= 1)
            return x;
        int l = 1, h = x, res= 0;

        while(l <= h)
        {
            int mid = l + (h - l)/2;
            if((long)mid * mid > x)
            {
                h = mid - 1;
            }
            else if((long)mid * mid < x)
            {
                l = mid + 1;
                res = mid;
            }
            else
            {
                return mid;
            }
        }
        return res;

    }
}