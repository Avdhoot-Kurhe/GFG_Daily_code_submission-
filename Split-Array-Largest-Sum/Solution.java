//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
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
};