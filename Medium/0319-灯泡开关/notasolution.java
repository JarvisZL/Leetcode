/*
*   测试样例可以通过 21/35.
*/

class Solution {
    public int bulbSwitch(int n) {
        long state = 0;
        for(int i = 1; i <= n; ++i){
            long sw = 1 << (i-1);
            long old = sw;
            for(int j = 2*i; j <= n; j += i){
                sw = (sw << i) + old;
            }
            state = state ^ sw;
        }    
        int ans = 0;
        while(state != 0){
            ans++;
            state = state & (state-1);
        }
        return ans;
    }
}