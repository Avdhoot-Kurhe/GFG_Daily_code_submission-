
### Explanation

Possible ways for one side are BSS, BSB, SSS, SBS, SSB where B represents a building and S represents an empty space. Pairing up with possibilities on the other side of the road, the total possible ways are 25.

## Approach

The solution uses dynamic programming to calculate the count of ways for each position on one side of the road. The total number of ways is then calculated by multiplying the counts on both sides.

## Code Explanation

```java
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
```

## Time Complexity
O(N)

## Space Complexity
O(N)