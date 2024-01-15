//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    
    public class GFG {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            while(t-- > 0)
            {
                int n = scanner.nextInt();
                int total = scanner.nextInt();
                int[] cost = new int[n];
                for (int i = 0; i < n; i++) {
                    cost[i] = scanner.nextInt();
                }
                Solution solution = new Solution();
                int result = solution.max_courses(n, total, cost);
                System.out.println(result);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    //User function Template for Java
    class Solution {
        int[][] dp;
        public int max_courses(int n, int total, int[] cost) {
            dp = new int[n + 1][total + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
    
            int ind = 0;
            return solve(ind, n, total, cost);
        }
        
    
        int solve(int ind, int n, int total, int[] cost) {
            if (ind == n || total == 0)
                return 0;
    
            if (dp[ind][total] != -1)
                return dp[ind][total];
    
            if (cost[ind] <= total) {
                return dp[ind][total] = Math.max(1 + solve(ind + 1, n, total - cost[ind] + (int) (0.9 * cost[ind]), cost),
                        solve(ind + 1, n, total, cost));
            } else {
                return dp[ind][total] = solve(ind + 1, n, total, cost);
            }
        }
    }
    
    