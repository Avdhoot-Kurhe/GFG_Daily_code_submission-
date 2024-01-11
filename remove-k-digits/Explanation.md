/**
 * Given a non-negative integer S represented as a string, remove K digits from the number so that the new number is the smallest possible.
 * Note: The given num does not contain any leading zero.
 * 
 * Example 1:
 * Input: S = "149811", K = 3
 * Output: 111
 * Explanation: Remove the three digits 4, 9, and 8 to form the new number 111 which is smallest.
 * 
 * Example 2:
 * Input: S = "1002991", K = 3
 * Output: 21
 * Explanation: Remove the three digits 1(leading one), 9, and 9 to form the new number 21 (Note that the output must not contain leading zeroes) which is the smallest.
 *
 * Approach:
 * - Use a StringBuilder to simulate a stack.
 * - Iterate through each digit in the input string.
 * - While K is greater than 0 and the current digit is smaller than the top of the stack, remove from the stack.
 * - Append the current digit to the stack.
 * - After the iteration, remove the remaining digits to meet the required length.
 * - Remove leading zeros from the stack.
 * - Build the result string from the modified stack.
 * - If the result is empty, return "0".
 */
```
class Solution {
    public String removeKdigits(String S, int K) {
        // Get the length of the input string
        int len = S.length();
        
        // If K is equal to the length of the string, there are no digits left after removal, so return "0"
        if (K == len) {
            return "0";
        }
        
        // Create a StringBuilder to simulate the stack
        StringBuilder stack = new StringBuilder();
        
        // Iterate through each digit of the input string
        int i = 0;
        while (i < len) {
            // While K is greater than 0 and the current digit is smaller than the top of the stack, remove from the stack
            while (K > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > S.charAt(i)) {
                stack.deleteCharAt(stack.length() - 1);
                K--;
            }
            
            // Append the current digit to the stack
            stack.append(S.charAt(i));
            i++;
        }
        
        // Remove remaining digits to meet the required length
        stack.setLength(stack.length() - K);
        
        // Remove leading zeros from the stack
        int startIndex = 0;
        while (startIndex < stack.length() && stack.charAt(startIndex) == '0') {
            startIndex++;
        }
        
        // Build the result string from the modified stack
        String result = stack.substring(startIndex);
        
        // If the result is empty, return "0"
        return result.isEmpty() ? "0" : result;
    }
}
```