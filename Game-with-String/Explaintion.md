# Game with String Explanation and Solution for Java Code

## Problem Description
Given a string s of lowercase alphabets and a number k, the task is to print the minimum value of the string after removal of k characters. The value of a string is defined as the sum of squares of the count of each distinct character present in the string. 

### Example 1:
```Input: 
s = abccc, k = 1
Output: 
6
Explaination:
We remove c to get the value as 12 + 12 + 22
```

## Java Code
```java
class Solution {
    static int minValue(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        queue.addAll(map.values());

        while (k-- > 0) {
            queue.add(queue.poll() - 1);
        }

        int res = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res += (cur * cur);
        }
        return res;
    }
}
```

# Explanation
### HashMap Initialization:
A HashMap map is initialized to store the frequency of each character in the string s.
Loop through each character in the string, update its frequency in the map.
### PriorityQueue Initialization:
Initialize a PriorityQueue named queue with a reverse order comparator. This means the queue will be in descending order.
### Populate PriorityQueue:
Add all the values (character frequencies) from the map to the queue.
### Remove k Characters:
Using a loop, remove the top element from the queue (character with the highest frequency) and decrement its frequency by 1.
Repeat this process for 'k' iterations.
### Calculate Result:
Initialize a variable res to store the final result.
Iterate through the remaining elements in the queue and add the square of each frequency to res.
### Return Result:
Return the final result res.