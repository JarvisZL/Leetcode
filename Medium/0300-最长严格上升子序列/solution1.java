class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] ordered = new int[nums.length];
       ordered = nums.clone();
       Arrays.sort(ordered);
       int[][] dp = new int[nums.length + 1][nums.length + 1];
       for(int i = 0; i < nums.length; ++i){
           for(int j = 0; j < nums.length; ++j){
               if(nums[i] == ordered[j]){
                   if(i != 0 && j != 0){
                       if(ordered[j] == ordered[j-1]){
                           dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                           continue;
                       }
                   }
                   dp[i+1][j+1] = dp[i][j]+1;
               }
               else {
                   dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
               }
           }
       }
       return dp[nums.length][nums.length];
    }
}