import java.util.*;
class length_LIS{
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,4,2,3,6,7};
        int len=length_LIS(nums);
        System.err.println(len);
    }
    private static int length_LIS(int[] nums){
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        // for(int[] num:dp) Arrays.fill(num,-1);
        // return helper(0,n,-1,nums,dp);
        // dp[n-1][0]=1;
        // for(int i=1;i<=n;i++){
        //     if(nums[n-1]>nums[i-1]) dp[n-1][i]=1;
        // }
        for(int i=n-1;i>=0;i--){
            for(int j=i;j>=0;j--){
                int take=0;
                if(j==0) take = 1 + dp[i+1][i];
                else if(nums[i]>nums[j-1]) take = 1+dp[i+1][i];
                int notake=dp[i+1][j];
                dp[i][j]=Math.max(take,notake);
            }
            
        }
        return dp[0][0];
    }
    private static int helper(int ind,int n,int prev,int[] nums,int[][] dp){
        if(ind==n-1){
            if(prev==-1) return 1;
            else if(nums[ind]>nums[prev]) return 1;
            return 0;
        }
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int take=0;
        if(prev==-1) take=1+helper(ind+1,n,ind,nums,dp);
        else if(nums[ind]>nums[prev]) take=1+helper(ind+1,n,ind,nums,dp);

        int notake=helper(ind+1,n,prev,nums,dp);
        return dp[ind][prev+1] = Math.max(take,notake);
    }
}