class Solution {
    public int lengthOfLastWord(String s) {
        
        String sp[] = s.split(" ");
        int l = sp.length;
        while("".equals(sp[l - 1]))
        {
            l--;
        }
        if(!"".equals(sp[l - 1]))
            return sp[l-1].length();

        return 0;

    }
}