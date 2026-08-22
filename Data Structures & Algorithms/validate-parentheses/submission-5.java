class Solution {
    public boolean isValid(String s)
    {
        Deque<Character> st = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(st.isEmpty())
            {
                st.push(c);
            }
            else
            {
                if(c == '(' || c == '[' || c == '{')
                {
                    st.push(c);
                }
                else
                {
                    char t = st.peek();
                    if((t == '(' && c == ')')|| (t == '[' && c == ']')|| (t == '{' && c == '}'))
                    {
                        st.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
            }
           
        }
         return st.isEmpty()? true: false;
    }
}
