class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length -1;
        Deque<Integer> st = new ArrayDeque<Integer>();
        int[] res = new int[n+1];
        for(int i = 0; i < n+1; i++)
        {
            if(!st.isEmpty() && t[st.peek()] < t[i])
            {
                while(!st.isEmpty() && t[st.peek()] < t[i])
                {
                    res[st.peek()] = i - st.peek();
                    st.pop();
                }
            }
            st.push(i);
        }
        return res;
    }
}
