class Solution {
    public String compressString(String S) {
        String ret = "";
        if(S.length() == 0) return ret;
        String old = S.substring(0,1);
        int cnt = 1;
        for(int i = 1; i < S.length(); ++i){
            if(old.equals(S.substring(i,i+1))){
                cnt++;
            }
            else{
                ret = ret + old + String.valueOf(cnt);
                old = S.substring(i,i+1);
                cnt = 1;
            }
        }
        ret = ret + old + String.valueOf(cnt);
        if(ret.length() >= S.length())
            return S;
        else
            return ret;
    }
}