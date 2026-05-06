class Solution {
    public int maxProfit(int[] p) {
        int mp = 0;
        int[] rm = new int[p.length];
        rm[p.length-1] = 0;
        for(int i = p.length-2; i>= 0; i--){
            rm[i] = Math.max(rm[i+1], p[i+1]);
            int pr = rm[i] - p[i];
            mp = Math.max(pr, mp);
        }
        return mp;
        
    }
}
