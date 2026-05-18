class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Map<Character,Integer> cs = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            if(cs.containsKey(s.charAt(right))){
                //update left only if we are moving window in forward
                left = Math.max(cs.get(s.charAt(right)) + 1,left); 
            }
            cs.put(s.charAt(right),right);
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
