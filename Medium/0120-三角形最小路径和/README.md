# solution

**动态规划**：

- dp\[i\]\[j\]表示第i行第j列到达底部的最小距离，用visit数组来判断某一点是否之前已经保存了值。

- 递推表达式:

  **dp\[row\]\[col\] = triangle.get(row).get(col) + Math.min(dp\[row+1\]\[col\], dp\[row+1\]\[col+1\])** 

