//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
         int MOD = 1000000007;

        // dp[i][0] represents the count of ways when there is an empty space at position i
        // dp[i][1] represents the count of ways when there is a building at position i
        long[][] dp = new long[N + 1][2];

        // Initialize base cases
        dp[1][0] = 1;
        dp[1][1] = 1;

        // Calculate the count of ways for each position
        for (int i = 2; i <= N; i++) {
            // Calculate count when there is an empty space at position i
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;

            // Calculate count when there is a building at position i
            dp[i][1] = dp[i - 1][0];

            // Take the modulo to avoid overflow
            dp[i][0] %= MOD;
            dp[i][1] %= MOD;
        }

        // Calculate the total number of ways by summing the product of counts on both sides
        long totalWays = (dp[N][0] + dp[N][1]) % MOD;
        totalWays = (totalWays * totalWays) % MOD;

        return (int) totalWays;
    }
}