//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}



// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> res=new ArrayList<>();
        int i1=0,i2=0;
        while(i1<n && i2<m){
            if(arr1[i1]<=arr2[i2]){
                if(res.size()==0 || res.get(res.size()-1)!=arr1[i1]) res.add(arr1[i1]);
                i1++;
            }
            else{
                if(res.size()==0 || res.get(res.size()-1)!=arr2[i2]) res.add(arr2[i2]);
                i2++;
            }
        }
        while(i1<n){
            if(res.size()==0 || res.get(res.size()-1)!=arr1[i1]) res.add(arr1[i1]);
            i1++;
        }
        while(i2<m){
            if(res.size()==0 || res.get(res.size()-1)!=arr2[i2]) res.add(arr2[i2]);
            i2++;
        }
        return res;
    }
}



