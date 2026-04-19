class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> res = new ArrayList<>(Collections.nCopies(nums.length,1));

        int prefix = 1;
        int postfix = 1;
        for(int i =0; i< nums.length; i++){
            int t = nums.length -1 -i;
            res.set(i, res.get(i)*prefix);
            res.set(t, res.get(t)*postfix);
            postfix *= nums[t];
            prefix *= nums[i];
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] productExceptSelfApprocah1(int[] nums) {
        List<Integer> il = new ArrayList<>();
        
        int nZM = 1;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == 0){
                il.add(i);
            }else{
                nZM *= nums[i];
            }
        }

        List<Integer> res = new ArrayList<>(Collections.nCopies(nums.length, 0));
        if(il.size()>= 1){
            if(il.size()== 1){
                res.set(il.get(0), nZM);
            }
        }else{
            for(int n = 0; n< nums.length; n++){
                res.set(n,nZM/nums[n]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
        
    }
}  
