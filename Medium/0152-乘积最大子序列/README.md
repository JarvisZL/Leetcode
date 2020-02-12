# solution

使用**动态规划的方法**，如果没有负数，则很容易令dp[i]表示以第i个数结尾的连续子序列乘积的最大数值，则有 

```java
dp[i] = Math.max(dp[i-1]*nums[i],nums[i]);
```

考虑有负数，当第i个数为负数时，此时最大值变成了nums[i]以第i-1个数结尾的连续子序列乘积的**最小值**。所以我们利用两个dp数组dp_max和dp_min.则有

```java
if(nums[i] >= 0){
      dp_max[i] = Math.max(nums[i],dp_max[i-1]*nums[i]);
      dp_min[i] = Math.min(nums[i],dp_min[i-1]*nums[i]);
}
else{
      dp_max[i] = Math.max(nums[i],dp_min[i-1]*nums[i]);
      dp_min[i] = Math.min(nums[i],dp_max[i-1]*nums[i]);
}
```

