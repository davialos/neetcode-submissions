class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> s = new HashMap();
        int[] res = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            int key = nums[i];
            if(s.containsKey(key)){
                res[0] = s.get(key);
                res[1] = i;
            }
            s.put(target-nums[i], i);
        }
        return res;
    }
}
