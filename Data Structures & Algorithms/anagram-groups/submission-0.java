class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> m = new HashMap();
        
        for(int i = 0; i< strs.length; i++){
            String s = strs[i];
            int[] a = new int[26];
            for(int j = 0 ; j< s.length(); j++){
              a[s.charAt(j) -'a']++;
            }
            String key = Arrays.toString(a);
            m.putIfAbsent(key, new ArrayList());
            m.get(key).add(s);
        }

        return new ArrayList(m.values());
        
    }
}
