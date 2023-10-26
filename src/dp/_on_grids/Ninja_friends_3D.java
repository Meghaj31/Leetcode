package dp._on_grids;

public class Ninja_friends_3D {
    public static void main(String[] args) {
        int[][] grid={{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        int n= grid.length;
        int m=grid[0].length;
        System.out.println(solve(n,m,grid));
    }
    public static int solve(int n, int m, int grid[][]){
        int[][][] dp=new int[n][m][m];
        //RECURSION + MEMOIZATION
//        return helper(n,m,0,0,m-1,grid,dp);
//    }
//    private static int helper(int n,int m,int row,int col1,int col2,int[][] grid,int[][][] dp){
//        if(col1<0 || col1>m-1 || col2<0 || col2>m-1) return 0;
//        if(row==n-1){
//            if(col1==col2) return grid[row][col1];
//            else return grid[row][col1]+grid[row][col2];
//        }
//        if(dp[row][col1][col2]!=0) return dp[row][col1][col2];
//        int max=0;
//        for(int c1=-1;c1<=1;c1++){
//            for(int c2=-1;c2<=1;c2++){
//                if(col1==col2) max= Math.max(max,grid[row][col1]+helper(n,m,row+1,col1+c1,col2+c2,grid,dp));
//                else max= Math.max(max,grid[row][col1]+grid[row][col2]+helper(n,m,row+1,col1+c1,col2+c2,grid,dp));
//            }
//        }
//        return dp[row][col1][col2] = max;
        // TABULATION
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j) dp[n-1][i][j]=grid[n-1][i];
                else dp[n-1][i][j]=grid[n-1][i] + grid[n-1][j];
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int col1=0;col1<m;col1++){
                for(int col2=0;col2<m;col2++){
                    int max=0;
                    for(int c1=-1;c1<=1;c1++) {
                        for (int c2 = -1; c2 <= 1; c2++) {
                            if(col1+c1>=0 && col1+c1 < m && col2+c2>=0 && col2+c2 < m) {

                                if (col1 == col2) max = Math.max(max, dp[i + 1][col1 + c1][col2 + c2] + grid[i][col1]);
                                else max = Math.max(max, dp[i + 1][col1 + c1][col2 + c2] + grid[i][col1] + grid[i][col2]);
                            }
                        }
                    }
                    dp[i][col1][col2]=max;
                }
            }
        }
        return dp[0][0][m-1];
    }
}
