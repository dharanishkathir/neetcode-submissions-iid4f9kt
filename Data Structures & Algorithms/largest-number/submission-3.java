class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> sorted = new PriorityQueue<String>((b,a) -> (a+b).compareTo(b+a));
        for(int i = 0; i < nums.length; i++)
        {
            sorted.offer(String.valueOf(nums[i]));
        }
        StringBuilder sb = new StringBuilder();
        while(!sorted.isEmpty())
        {
            sb.append(sorted.poll());
        }
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}