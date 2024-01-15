# Max Courses

## Problem Statement

GeeksforGeeks has introduced a special offer where you can enroll in any course, and if you manage to complete 90% of the course within 90 days, you will receive a refund of 90%.

You are given the total number of days (`n`), the initial total amount (`total`), and an array `cost` where `cost[i]` represents the cost of the course available on the ith day.

Geek decided that if he buys a course on a specific day, he will complete that course on the same day itself and redeem `floor(0.9 * cost of the course)` amount back. The goal is to find the maximum number of courses that Geek can complete in the given `n` days.

Write a function `max_courses` to solve this problem.

### Example 1:

```
**Input:**
n = 2
total = 10
cost = [10, 9]
Output:
2
```
#### Explanation:
Geek can buy the first course for 10 amounts, complete it on the same day, and redeem 9 back. Next, he can buy and complete the 2nd course too.

### Example 2:
```
Input:
n = 11
total = 10
cost = [10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
Output:
10
```
#### Explanation:
Geek can buy and complete all the courses that cost 1.

# Approach

The problem is to maximize the number of courses that Geek can complete within a given set of constraints. The key considerations are the total number of days (`n`), the initial total amount (`total`), and an array `cost` representing the cost of courses available on each day.

## Sorting and Dynamic Programming

The approach involves sorting the `cost` array in ascending order. Dynamic programming is then used with memoization to avoid redundant calculations.

1. **Sort the `cost` array:** To optimize the solution, start by sorting the `cost` array in ascending order. This allows for a more efficient exploration of the available courses.

2. **Initialize memoization table:** Create a 2D array `dp` to memoize the results of subproblems. The dimensions of `dp` are `(n + 1) x (total + 1)`, and initialize all cells with `-1`.

3. **Recursive function `solve`:** Implement a recursive function `solve` that calculates the maximum number of courses that can be completed within the given constraints. This function considers two cases: either complete the current course or skip it, choosing the option with a higher count.

4. **Memoization:** Use the memoization table (`dp`) to store and retrieve previously calculated results. This helps avoid redundant computations and significantly improves the efficiency of the solution.

5. **Final result:** The final answer is obtained by calling the `solve` function with the appropriate parameters, starting with an initial index (`ind` set to 0), the total number of days (`n`), the remaining budget (`total`), and the sorted `cost` array.

By following this dynamic programming approach with memoization, the solution efficiently calculates the maximum number of courses that Geek can complete within the given constraints.



```
class Solution {
    int[][] dp;

    public int max_courses(int n, int total, int[] cost) {
        // Initialize memoization table
        dp = new int[n + 1][total + 1];
        
        // Fill the memoization table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start with the first course (ind = 0)
        int ind = 0;
        
        // Call the solve method with initial parameters
        return solve(ind, n, total, cost);
    }

    // Recursive function for dynamic programming
    int solve(int ind, int n, int total, int[] cost) {
        // Base case: If all courses are considered or total budget is exhausted
        if (ind == n || total == 0)
            return 0;

        // If the result for the current state is already calculated, return it
        if (dp[ind][total] != -1)
            return dp[ind][total];

        // Check if the current course is affordable
        if (cost[ind] <= total) {
            // Choose the maximum between completing the current course or skipping it
            return dp[ind][total] = Math.max(
                    1 + solve(ind + 1, n, total - cost[ind] + (int) (0.9 * cost[ind]), cost), // Complete the course
                    solve(ind + 1, n, total, cost) // Skip the course
            );
        } else {
            // If the current course is not affordable, skip it
            return dp[ind][total] = solve(ind + 1, n, total, cost);
        }
    }
}

```
This dynamic programming solution efficiently calculates the maximum number of courses Geek can complete within the given constraints.