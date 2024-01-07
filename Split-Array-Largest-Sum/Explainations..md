# Split Array into K Subarrays

## Problem Statement

Given an array `arr[]` of N elements and a number K, split the given array into K subarrays such that the maximum subarray sum achievable out of K subarrays formed is minimum possible. The task is to find that possible subarray sum.

### Example 1:

Input:
N = 4, K = 3
arr[] = {1, 2, 3, 4}
Output: 4

Explanation:
Optimal Split is {1, 2}, {3}, {4}.
Maximum sum of all subarrays is 4, which is the minimum possible for 3 splits.

### Example 2:

Input:
N = 3, K = 2
arr[] = {1, 1, 2}
Output: 2

Explanation:
Splitting the array as {1,1} and {2} is optimal.
This results in a maximum sum subarray of 2.

## Approach

To solve this problem, we can use binary search to find the minimum possible maximum subarray sum. The idea is to perform a binary search on the possible range of maximum subarray sums and check if it is possible to split the array into K subarrays such that the maximum subarray sum is less than or equal to the mid value of the binary search range. If it is possible, then we move to the left half of the search space; otherwise, we move to the right half.

Here is the java code for the solution:

```java
class Solution {
    static int splitArray(int[] arr, int N, int K) {
        int low = Integer.MIN_VALUE, high = 0;
        
        // Find the possible range for the maximum subarray sum
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }
        
        int result = -1;

        // Perform binary search on the range
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(mid, arr, K)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    static boolean isValid(int mid, int[] arr, int K) {
        int count = 0;
        int currentSum = 0;

        for (int num : arr) {
            currentSum += num;

            if (currentSum > mid) {
                count++;
                currentSum = num;
            }
        }

        return count + 1 <= K;
    }

    public static void main(String[] args) {
        // Example 1
        int N1 = 4, K1 = 3;
        int[] arr1 = {1, 2, 3, 4};
        System.out.println(splitArray(arr1, N1, K1));  // Output: 4

        // Example 2
        int N2 = 3, K2 = 2;
        int[] arr2 = {1, 1, 2};
        System.out.println(splitArray(arr2, N2, K2));  // Output: 2
    }
}
```
The splitArray function uses binary search to find the minimum possible maximum subarray sum, and the isValid function checks if it is possible to split the array into K subarrays with the given maximum subarray sum. The result is the minimum possible maximum subarray sum that satisfies the conditions.

Time Complexity
The expected time complexity is O(N*log(sum(arr))), and the expected auxiliary space is O(1).

Constraints
1 ≤ N ≤ 105
1 ≤ K ≤ N
1 ≤ arr[i] ≤ 104
