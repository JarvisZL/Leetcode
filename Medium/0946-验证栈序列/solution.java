/*
*   用栈来模拟整个push和pop的过程。 最后检测栈是否为空，即可
*
*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushlen = pushed.length;
        int poplen = popped.length;
        Stack<Integer> st = new Stack<>();
        int ptr1 = 0, ptr2 = 0;

        while(true){
            if(st.empty() || st.peek() != popped[ptr2]){
                if(ptr1 == pushlen) break;
                st.push(pushed[ptr1++]);
            }
            else if(st.peek() == popped[ptr2]){
                st.pop();
                ptr2++;
            }
            if(ptr2 == poplen) break;
        }
        
        if(st.empty())
            return true;
        else
            return false;
    }
}