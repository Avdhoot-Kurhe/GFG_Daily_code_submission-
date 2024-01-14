# Problem: Find Repeated Rows in Boolean Matrix

## Problem Description:

Given a boolean matrix of size RxC where each cell contains either 0 or 1, find the row numbers (0-based) of rows that already exist or are repeated.

### Example 1:

**Input:**
R = 2, C = 2
matrix[][] = {{1, 0},
              {1, 0}}

**Output:** 
[1]

**Explanation:**
Row 1 is a duplicate of Row 0.

### Example 2:

**Input:**
R = 4, C = 3
matrix[][] = {{1, 0, 0},
              {1, 0, 0},
              {0, 0, 0},
              {0, 0, 0}}

**Output:**
[1, 3]

**Explanation:**
Row 1 and Row 3 are duplicates of Row 0 and 2 respectively.

## Approach:

1. Create a HashSet to store the string representation of each row.
2. For each row in the matrix:
   - Convert the row to a string.
   - Check if the string representation is already in the HashSet.
   - If it is, add the row index to the result list.
   - If it's not, add the string representation to the HashSet.
3. Return the result list containing the row indices of the repeated rows.

## Code Explanation:

```java
// Java code for the repeatedRows function

import java.util.ArrayList;
import java.util.HashSet;

class Solution
{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        // HashSet to store the string representation of rows
        HashSet<String> set = new HashSet<>();
        
        // ArrayList to store the indices of repeated rows
        ArrayList<Integer> result = new ArrayList<>();

        // Iterate through each row in the matrix
        for (int i = 0; i < m; i++) {
            StringBuilder rowString = new StringBuilder();

            // Convert the row to a string
            for (int j = 0; j < n; j++) {
                rowString.append(matrix[i][j]);
            }
            String rowHash = rowString.toString();

            // Check if the string representation is already in the HashSet
            if (set.contains(rowHash)) {
                // If yes, add the row index to the result list
                result.add(i);
            } else {
                // If not, add the string representation to the HashSet
                set.add(rowHash);
            }
        }

        // Return the list containing the indices of repeated rows
        return result;
    }
}
