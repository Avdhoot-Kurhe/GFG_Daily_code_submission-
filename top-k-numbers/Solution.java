import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
