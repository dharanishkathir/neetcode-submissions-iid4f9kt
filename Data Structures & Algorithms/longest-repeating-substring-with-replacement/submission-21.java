class Solution {
    public int characterReplacement(String st, int k)
    {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0, maxF = 0, res = 0;
        
        for(int r = 0; r < st.length(); r++)
        {
            map.put(st.charAt(r), map.getOrDefault(st.charAt(r), 0) + 1);
            maxF = Math.max(maxF, map.get(st.charAt(r)));

            while(r - l + 1 - maxF > k)
            {
                map.put(st.charAt(l), map.get(st.charAt(l)) - 1);
                l++;
            }

            res = Math.max(r - l + 1, res);

        }
        return res;
    }
}
