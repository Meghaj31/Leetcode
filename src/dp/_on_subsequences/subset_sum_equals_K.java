package dp._on_subsequences;
import java.util.*;

public class subset_sum_equals_K {
    public static void main(String[] args) {
        int[] nums={1,3,3,5};
        int target=4;
        boolean[][] dp=new boolean[nums.length][target+1];
//        for(int[] num:dp){
//            Arrays.fill(num,-1);
//        }
//        System.out.print(solve(nums.length-1,nums,4,dp));
        for(int i=0;i<target+1;i++){
            if(nums[0]==i) dp[0][i]=true;
            else dp[0][i]=false;
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<target+1;j++){
                boolean take=false;
                if(target>=nums[i]) take=dp[i-1][target-nums[i]];
                boolean notake=dp[i-1][target];
                dp[i][target]=(take || notake);
            }
        }
        System.out.println(dp[nums.length-1][target]);
    }
    public static int solve(int ind,int[] nums,int target){
        if(ind==0){
            if(nums[ind]==target) return 1;
            else return 0;
        }
        //if(dp[ind][target]!=-1) return dp[ind][target];
        int take=0;
        if(target>=nums[ind]) take=solve(ind-1,nums,target-nums[ind]);
        int notake=solve(ind-1,nums,target);
        if(take==1 || notake==1) return 1;
        else return 0;
    }
}
