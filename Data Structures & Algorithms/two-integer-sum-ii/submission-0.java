class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookupMap = new HashMap<>();
        lookupMap.put(nums[0],1);
        int[] res = new int[2];
        int left = 0; 
        for(int right = 1 ; right < nums.length; right++){
            if(lookupMap.containsKey(target-nums[right])){
                res[0] = lookupMap.get(target-nums[right]);
                res[1] = right + 1;
                break;
            }
            lookupMap.put(nums[right], right + 1);
        }
        return res;
    }
}
