class Solution {
    public String toGoatLatin(String S) {
        char[] temp = {'a','e','i','o','u','A','E','I','O','U'};
        String[] words = new String[150];
        int cnt = 0;
        int head = 0;
        for(int i = 1; i < S.length(); ++i){
            if(S.charAt(i) == ' '){
                words[cnt++] = S.substring(head,i);
                head = i+1;
                i = head;
            }
            if(i == S.length()-1){
                words[cnt++] = S.substring(head,i+1);
            }
        }

        for(int i = 0; i < cnt; ++i){
            boolean flag = false;
            for(int j = 0; j < temp.length; ++j){
                if(words[i].charAt(0) == temp[j]){
                    words[i] = words[i].concat("ma");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                String ss = words[i].substring(0,1);
                words[i] = words[i].substring(1);
                words[i] = words[i].concat(ss);
                words[i] = words[i].concat("ma");
            }
            for(int j = 0; j < i+1; ++j){
                words[i] = words[i].concat("a");
            }
        }
        
        String res = "";
        for(int i = 0; i < cnt; ++i){
            res = res.concat(words[i]);
            if(i != cnt - 1)
                res = res.concat(" ");
        }
        return res;
    }
}