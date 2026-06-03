import java.util.HashMap;

public class TwoSum {

    /*
     * LeetCode 1 - Two Sum
     * Approach: HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {-1, -1}; // better than empty array
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = obj.twoSum(nums, target);

        System.out.println("Index 1: " + result[0]);
        System.out.println("Index 2: " + result[1]);
    }
}