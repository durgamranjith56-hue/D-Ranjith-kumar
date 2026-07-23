import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);

        // Initialize with the first possible sum
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int currentSum = nums[i] + nums[left] + nums[right];

                // If current sum is closer to target
                if (Math.abs(currentSum - target) <
                    Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Exact match
                if (currentSum == target) {
                    return currentSum;
                }

                // Need a larger sum
                if (currentSum < target) {
                    left++;
                }
                // Need a smaller sum
                else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}
