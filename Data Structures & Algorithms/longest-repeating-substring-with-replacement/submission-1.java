class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int mf = 0;
        int left = 0;
        Map<Character,Integer> f = new HashMap<>();
        for(int right = 0; right<s.length(); right++){
           f.put(s.charAt(right), f.getOrDefault(s.charAt(right), 0)+ 1);
           mf = Math.max(mf, f.get(s.charAt(right)));

           while((right-left+1) - mf > k){
            int cf = f.get(s.charAt(left));
            f.put(s.charAt(left), cf -1 );
            left++;
           }
           max = Math.max(max, right-left+1);
        }
        return max;
    }
}
