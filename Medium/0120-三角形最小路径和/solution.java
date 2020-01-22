class Solution {
    int[][] dp;
    boolean[][] visit;
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        dp = new int[length][];
        visit = new boolean[length][];
        for(int i = 0; i < length; ++i){
            int ll = triangle.get(i).size();
            dp[i] = new int[ll];
            visit[i] = new boolean[ll];
        }
        for(int i = 0; i < triangle.get(length-1).size(); ++i){
            dp[length-1][i] = triangle.get(length-1).get(i);
            visit[length-1][i] = true;
        }
        return DP(0,0,triangle);
    }

    public int DP(int row,int col,List<List<Integer>> triangle){
        if(visit[row][col] == true) return dp[row][col];
        List<Integer> R = triangle.get(row);
        int left = col, right = col+1;
        dp[row][col] = R.get(col)+ Math.min(DP(row+1,left,triangle),DP(row+1,right,triangle));
        visit[row][col] = true;
        return dp[row][col];
    }
}