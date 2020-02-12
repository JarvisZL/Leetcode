class Solution {
    public int fast(int n){
        int ret = 1;
        int base = 10;
        while(n != 0){
            if((n&1) != 0){
                ret *= base;
            }
            base *= base;
            n = n >> 1;
        }
        return ret;
    }
    public int[] printNumbers(int n) {
        int limit = fast(n);
        int[] ans = new int[limit - 1];
        for(int i = 0; i < limit - 1; ++i){
            ans[i] = i+1;
        }
        return ans;
    }
}