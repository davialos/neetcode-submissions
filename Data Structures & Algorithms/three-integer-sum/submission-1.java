class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i< nums.length -2; i++){
            if(nums[i] > 0) break; //all positives ahead
            int n = nums[i];
            //check for duplicates
            if( i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length -1;
            while(right > left){
                int s = n + nums[left] + nums[right];
                
                if(s == 0){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    res.add(l);
                    while (left < right && nums[left] == nums[left + 1]) left++; 
                      // skip duplicates for left pointers
                    while (left < right && nums[right] == nums[right - 1]) right--;
                     // skip duplicates for tight pointers
                    left++;
                    right--;
                } else if(s > 0){
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return res;
    }
}
