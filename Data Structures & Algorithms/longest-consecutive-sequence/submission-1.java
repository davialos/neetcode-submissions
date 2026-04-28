class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            s.add(n);
        }
        int longest = 0;
        for(Integer n : s){
             
            if(!s.contains(n-1)){
                int len = 1;
                while(s.contains(n+ len)){
                    len++;
                }
                longest = Math.max(len, longest);
            }
        }
        return longest;
    }
}
