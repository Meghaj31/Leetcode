package dp._on_subsequences;

public class Array_partition_equal_sum {
    public static void main(String[] args) {
        int[] nums={2,3,3,5};
        int n=nums.length;
        System.out.println(solve(nums,n));

    }
    private static int solve(int[] nums,int n){
        int sum=0;
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum%2==1) return 0;
        int k=sum/2;

        return subset_sum_equals_K.solve(n-1,nums,k);
    }
}
