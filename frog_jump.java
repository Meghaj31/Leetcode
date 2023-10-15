package dp;

import java.util.Arrays;

public class frog_jump {
    public static void main(String[] args) {
        int[] nums=new int[] {10,30,20,30,30,15,25,20};
        int n=nums.length;
        int[] dp=new int[nums.length];
        int k=3;
        Arrays.fill(dp,-1);
        //System.out.println(min_energy(nums.length-1,nums,dp));  // to solve basic frog jump

        //frog jump with k steps
        System.out.println(with_k(n-1,nums,k,dp));

    }
    // MEMOIZATION APPROACH

//    private static int min_energy(int i,int[] nums,int[] dp){
//        if(i==0) return 0;
//        if(dp[i]!=-1) return dp[i];
//        int left=min_energy(i-1,nums,dp) + Math.abs(nums[i]-nums[i-1]);
//        int right=Integer.MAX_VALUE;
//        if(i>1){
//            right=min_energy(i-2,nums,dp) + Math.abs(nums[i]-nums[i-2]);
//        }
//        dp[i] = Math.min(left,right);
//        return dp[i];
//    }

    //TABULATION APPROACH

//    private static int min_energy(int index,int[] nums,int[]dp){
//        dp[0]=0;
//        for(int i=1;i<nums.length;i++){
//            int left=dp[i-1] + Math.abs(nums[i]-nums[i-1]);
//            int right=Integer.MAX_VALUE;
//            if(i>1) right=dp[i-2] + Math.abs(nums[i]-nums[i-2]);
//            dp[i]=Math.min(left,right);
//        }
//        return dp[nums.length-1];
//    }

    //SPACE OPTIMIZATION
    private static int min_energy(int index,int[] nums,int[] dp){
        int prev2=0;
        int prev=0;
        return prev;
    }





    // frog jump with k steps

    private static int with_k(int index,int[] nums,int k,int[] dp){
//        if(index==0) return 0;
//        if(dp[index]!=-1) return dp[index];
//        int left= Integer.MAX_VALUE;
//        for(int i=1;i<=k;i++){
//
//            if(index>=i) {
//                left = Math.min(left, with_k(index - i, nums, k,dp) + Math.abs(nums[index] - nums[index - i]));
//            }
//        }
//        dp[index] = left;
//        return dp[index];

        // tabulation approach
        dp[0]=0;
        for (int i=1;i<=index;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0) dp[i]=Math.min(dp[i],dp[i-j] + Math.abs(nums[i]-nums[i-j]));
            }
        }
        return dp[index];
    }


}
