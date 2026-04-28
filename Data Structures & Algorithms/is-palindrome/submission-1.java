class Solution {
    public boolean isPalindrome(String s) {
        
        int i = s.length();
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().trim();
        String s2 = new StringBuilder(s1).reverse().toString();
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }
}
