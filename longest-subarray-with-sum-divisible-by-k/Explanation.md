# Longest Subarray with Sum Divisible by K

## Problem Statement

Given an array `arr` containing `N` integers and a positive integer `K`, find the length of the longest subarray with the sum of the elements divisible by the given value `K`.

### Example 1

**Input:**
N = 6, K = 3
arr[] = {2, 7, 6, 1, 4, 5}
**Output:**
4

**Explanation:**
The subarray is {7, 6, 1, 4} with a sum of 18, which is divisible by 3.

### Example 2

**Input:**
N = 7, K = 3
arr[] = {-2, 2, -5, 12, -11, -1, 7}

**Output:**
5

**Explanation:**
The subarray is {2,-5,12,-11,-1} with a sum of -3, which is divisible by 3.

## Solution

```java
import java.util.HashMap;

class Solution {
    int longSubarrWthSumDivByK(int a[], int n, int k) {
        // Initialize a HashMap to store remainder and its corresponding index
        HashMap<Integer, Integer> remainderMap = new HashMap<>();

        // Initialize variables to store current sum and length of the longest subarray
        int currentSum = 0;
        int maxLength = 0;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Calculate the current sum
            currentSum += a[i];

            // Calculate the remainder when dividing the current sum by k
            int remainder = (currentSum % k + k) % k; // Handle negative remainder

            // Check if the remainder is 0, update maxLength directly
            if (remainder == 0) {
                maxLength = i + 1;
            } else {
                // Check if the remainder is already in the map
                if (remainderMap.containsKey(remainder)) {
                    // Update maxLength if a subarray with the same remainder is found
                    maxLength = Math.max(maxLength, i - remainderMap.get(remainder));
                } else {
                    // Store the index of the first occurrence of the remainder
                    remainderMap.put(remainder, i);
                }
            }
        }

        return maxLength;
    }
}
```

## Approach Explanation
- HashMap for Remainders: We use a HashMap to store the remainder of the cumulative sum at each index along with its corresponding index.

- Initialization: Initialize variables for the current sum (currentSum) and the length of the longest subarray (maxLength). Also, handle the remainder calculation for negative values.

- Iterate Through the Array: Loop through the given array and update the currentSum at each index.

- Remainder Calculation: Calculate the remainder when dividing the currentSum by k. Ensure that the remainder is positive by adding k and then taking the modulus again.

- Check for Zero Remainder: If the remainder is 0, update maxLength directly, as the subarray from the beginning to the current index is divisible by k.

- Check for Existing Remainder: If the remainder is not 0, check if the remainder is already in the HashMap. If yes, update maxLength by comparing with the length of the subarray with the same remainder.

- Store or Update HashMap: If the remainder is not in the HashMap, store it with its current index. If it already exists, update its index.

- Return Result: The final maxLength represents the length of the longest subarray with a sum divisible by k. Return this value.

## Time Complexity
The time complexity of this solution is O(N), where N is the size of the input array, as we only iterate through the array once. The space complexity is O(N) due to the HashMap used to store remainders and their indices.