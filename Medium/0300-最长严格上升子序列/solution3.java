class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        List<Integer> tails = new ArrayList<>();
        tails.add(nums[0]);
        for(int i = 1; i < nums.length; ++i){
            int l = 0, r = tails.size() - 1;
            int pos = -1;
            while(l <= r){
                int mid = (l+r) >> 1;
                if(tails.get(mid) < nums[i])
                    l = mid + 1;
                else{
                    pos = mid;
                    r = mid - 1;
                }
            }
            if(pos == -1){
                tails.add(nums[i]);
            }
            else{
                tails.set(pos,nums[i]);
            }
        }
        return tails.size();
    }
}