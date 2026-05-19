class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(int i = 0; i< s1.length(); i++){
            f1[s1.charAt(i) -'a'] = f1[s1.charAt(i)-'a'] +1;
            f2[s2.charAt(i) -'a'] = f2[s2.charAt(i)-'a'] +1;
        }
        
        int matches = 0;
        for(int i = 0 ; i < 26; i++){
            if(f1[i] == f2[i] ) matches++;
        }

        int left = 0;
        for(int right = s1.length(); right < s2.length(); right++){
            if(matches == 26) return true;
            int i = s2.charAt(right) -'a';
            f2[i]++;

            if(f1[i] == f2[i]){ matches++;}
            else if(f1[i] + 1 == f2[i]){ matches--;}

            i = s2.charAt(left) -'a';
            f2[i]--;
            if(f1[i] == f2[i]) matches++;
            else if(f1[i]-1 == f2[i]){ matches--;}
            left++;
        }
        return matches == 26;
    }
}
