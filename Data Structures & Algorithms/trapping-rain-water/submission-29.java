class Solution {
    public int trap(int[] h)
    {
        int n = h.length-1;
        int lmax = h[0], rmax = h[n];
        int i = 0, j = n;
        int res = 0;
        while(i < j)
        {
            if(lmax < rmax)
            {
                i++;
                lmax = lmax > h[i]? lmax : h[i];
                res = res + lmax - h[i];
            }
            else
            {
                j--;
                rmax = rmax > h[j]? rmax : h[j];
                res = res + rmax - h[j];
            }
        }
        return res;
    }
}