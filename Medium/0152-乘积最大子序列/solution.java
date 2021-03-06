class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        int ans = dp_max[0];
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] >= 0){
                dp_max[i] = Math.max(nums[i],dp_max[i-1]*nums[i]);
                dp_min[i] = Math.min(nums[i],dp_min[i-1]*nums[i]);
            }
            else{
                dp_max[i] = Math.max(nums[i],dp_min[i-1]*nums[i]);
                dp_min[i] = Math.min(nums[i],dp_max[i-1]*nums[i]);
            }
            ans = Math.max(ans,dp_max[i]);
        }
        return ans;
    }
}