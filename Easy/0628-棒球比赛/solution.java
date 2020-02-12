class Solution {
    public int calPoints(String[] ops) { 
        int sum = 0;
        int len = ops.length;
        List<Integer> nums = new ArrayList<>();
        
        for(int i = 0; i < len; ++i){
            if(ops[i].equals("+")){
                int now = nums.get(nums.size() - 1) + nums.get(nums.size() - 2);
                nums.add(now);
                sum += now;
            }
            else if(ops[i].equals("C")){
                sum -= nums.get(nums.size() - 1);
                nums.remove(nums.size() - 1);
            }
            else if(ops[i].equals("D")){
                int now = 2 * nums.get(nums.size() - 1);
                nums.add(now);
                sum += now;
            }
            else{
                nums.add(Integer.parseInt(ops[i]));
                sum += nums.get(nums.size()-1);
            }
        }

        return sum;
    }
}