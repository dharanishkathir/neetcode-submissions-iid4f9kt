class Solution {
    public int[] dailyTemperatures(int[] t) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = t.length -1;
        Deque<Integer> st = new ArrayDeque<Integer>();
        int[] res = new int[n+1];
        for(int i = n; i >= 0; i--)
        {
            int cur = t[i];
                while(!st.isEmpty() && cur >= t[st.peek()])
                {
                    st.pop();
                }
                if(!st.isEmpty())
                {
                    res[i] =  st.peek() - i;
                }
                st.push(i);
        }
        return res;
    }
}
