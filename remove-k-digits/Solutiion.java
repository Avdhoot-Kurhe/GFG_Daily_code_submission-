//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        int len = S.length();
        
        // If K is equal to the length of the string, return "0"
        if (K == len) {
            return "0";
        }
        
        // Create a StringBuilder to simulate the stack
        StringBuilder stack = new StringBuilder();
        
        int i = 0;
        
        // Iterate through each digit of the input string
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
        
        // Remove leading zeros
        int startIndex = 0;
        while (startIndex < stack.length() && stack.charAt(startIndex) == '0') {
            startIndex++;
        }
        
        // Build the result string
        String result = stack.substring(startIndex);
        
        return result.isEmpty() ? "0" : result;
    }
}