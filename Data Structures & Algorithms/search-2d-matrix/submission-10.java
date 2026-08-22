class Solution {
    public boolean searchMatrix(int[][] ar, int t) {
        
        int l = 0, r = ar.length-1, col = ar[0].length-1;
        int m = 0;
        while(l <= r)
        {
            m = l + (r - l)/2;
            if(ar[m][col] < t)
            {
                l = m + 1;
            }
            else if(ar[m][0] > t)
            {
                r = m - 1;
            }
            else
            {
                break;
            }
        }

        
        return bs(ar[m], t, true) == -1? false : true;
    }

    private int bs(int []arr, int t, boolean flag)
    {
        int l = 0, r = arr.length - 1;
        while(l <= r)
        {
            int mid = l + ((r - l)/2);
            if(arr[mid] == t)
                return mid;
            else if(arr[mid] > t)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return flag? -1 : l;
    }
}
