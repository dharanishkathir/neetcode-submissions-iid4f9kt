class Solution {
    public int lengthOfLongestSubstring(String st)
    {
        int s = 0; int max = 0;
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        char[] c = st.toCharArray();
        for(int e = 0; e < c.length; e++)
        {
            if(!freq.containsKey(c[e]) || freq.get(c[e]) < s)
            {
                max = e - s + 1 > max? e - s + 1 : max;
                freq.put(c[e], e);
            }
            else
            {
                s = freq.get(c[e]) + 1;
                freq.put(c[e], e);
            }
        }
        return max;
    }
}
