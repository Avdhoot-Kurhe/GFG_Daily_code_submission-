# Top K Frequent Elements

Given an array of N numbers, the task is to keep at most the top K numbers with respect to their frequency.

## Problem Description

You are given an array of N numbers and your task is to iterate over the array. After each index, determine the top K most frequent numbers until that iteration and store them in an array in decreasing order of frequency. An array will be formed for each iteration and stored in an array of arrays. If the total number of distinct elements is less than K, then keep all the distinct numbers in the array. If two numbers have equal frequency, place the smaller number first in the array.

### Example

#### Input
- N=5, K=4
- arr[] = {5, 2, 1, 3, 2}

#### Output
5
2 5
1 2 5
1 2 3 5
2 1 3 5

### Constraints
- 1 ≤ N ≤ 10^4
- 1 ≤ K ≤ 10^2
- 1 ≤ a[i] ≤ 10^2

# Solutions

## 1. PriorityQueue Solution
// Implementation in the Solution class
// Time Complexity: O(N * K * log K)
// Space Complexity: O(N)
## code
```
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // Map to store frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Priority Queue to store numbers based on their frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey()
        );
        
        for (int i = 0; i < N; i++) {
            // Update frequency map
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
            
            // Add entries to the priority queue
            pq.clear();
            pq.addAll(frequencyMap.entrySet());
            
            // Create the array for the current iteration
            ArrayList<Integer> currentArray = new ArrayList<>();
            int count = Math.min(K, pq.size());
            
            for (int j = 0; j < count; j++) {
                currentArray.add(pq.poll().getKey());
            }
            
            // Add the array to the result
            result.add(new ArrayList<>(currentArray));
        }
        
        return result;
    }
}

```
## 2. List of Lists Solution
// Implementation in the Solution class
// Time Complexity: O(N * K)
// Space Complexity: O(N)
## code
```
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] frequencyList = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            frequencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
            int frequency = frequencyMap.get(arr[i]);
            frequencyList[frequency - 1].remove(Integer.valueOf(arr[i])); // Remove from the previous frequency
            frequencyList[frequency].add(arr[i]); // Add to the current frequency

            // Create the array for the current iteration
            ArrayList<Integer> currentArray = new ArrayList<>();

            // Iterate from highest frequency to lowest
            for (int j = N; j >= 0; j--) {
                for (int num : frequencyList[j]) {
                    currentArray.add(num);
                    if (currentArray.size() == K) {
                        break;
                    }
                }
                if (currentArray.size() == K) {
                    break;
                }
            }

            // Add the array to the result
            result.add(new ArrayList<>(currentArray));
        }

        return result;
    }
}

```