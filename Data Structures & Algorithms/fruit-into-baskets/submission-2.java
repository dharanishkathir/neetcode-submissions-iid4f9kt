class Solution {
    public int totalFruit(int[] f) {
        
        int s = 0, max = 0;
        int t1[] = new int[]{-1, -1};
        int t2[] = new int[]{-1, -1};
        for(int e = 0; e < f.length; e++)
        {
            if(t1[0] == -1 || t1[0] == f[e])
            {
                t1[0] = f[e];
                if(e == 0 || f[e-1] != f[e])
                t1[1] = e;
                max = max < e - s + 1? e - s + 1 : max;
            }
            else if(t2[0] == -1 || t2[0] == f[e])
            {
                t2[0] = f[e];
                if(e == 0 || f[e-1] != f[e])
                t2[1] = e;
                max = max < e - s + 1? e - s + 1 : max;
            }
            else if(t1[1] > t2[1])
            {
                t2[0] = f[e];
                t2[1] = e;
                s = t1[1];
            }
            else
            {
                t1[0] = f[e];
                t1[1] = e;
                s = t2[1];
            }
        }
        
        return max;
    }
}