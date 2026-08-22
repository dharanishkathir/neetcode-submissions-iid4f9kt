class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int temp[] = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++)
        {
            temp[i] = matrix[i][matrix[0].length-1];
        }
        int i = bs(temp, target, false);
        if(i == matrix.length)
        i--;
        return bs(matrix[i], target, true) == -1? false : true;
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
