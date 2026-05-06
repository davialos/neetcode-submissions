class Solution {
    public int trap(int[] h) {
        int l = h.length;
        int[] lm = new int[l];
        int[] rm = new int[l];
        for(int i = 0; i<l; i++){
            if(i == 0){
                lm[i] = 0;
                rm[l-1-i] = 0;
            } else{
                lm[i] = Math.max(h[i-1],lm[i-1]);
                rm[l-1-i] = Math.max(h[l-i],rm[l-i]);
            }
        }
        int mw = 0;
        for(int i = 0; i< l ; i++){
            int cw = Math.min(lm[i], rm[i]) - h[i];
            if(cw > 0){
                mw += cw;
            }
        }
        return mw;
    }
}
