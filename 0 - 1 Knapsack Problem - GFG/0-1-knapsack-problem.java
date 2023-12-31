//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp=new int[n][W+1];
        //  for(int[] num:dp) Arrays.fill(num,-1);
        //  return helper(n-1,W,wt,val,dp);
        for(int i=wt[0];i<W+1;i++) dp[0][i]=val[0];
        
        for(int ind=1;ind<n;ind++){
            for(int w=0;w<W+1;w++){
                int take=0;
                if(wt[ind]<=w) take=dp[ind-1][w-wt[ind]]+val[ind];
                int notake=dp[ind-1][w];
                dp[ind][w] = Math.max(take,notake);
            }
        }
        return dp[n-1][W];
    } 
    private static int helper(int ind,int w,int[] wt,int[] val,int[][] dp){
        if(w==0) return 0;
        if(ind==0){
            if(wt[ind]<=w) return val[ind];
            else return 0;
        }
        if(dp[ind][w]!=-1) return dp[ind][w];
        int take=0;
        if(wt[ind]<=w) take=helper(ind-1,w-wt[ind],wt,val,dp)+val[ind];
        int notake=helper(ind-1,w,wt,val,dp);
        return dp[ind][w] = Math.max(take,notake);
    }
}


