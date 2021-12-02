import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{
                -1, 0, 1, 2, -1, -4
        };
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int idx = Arrays.binarySearch(nums, j + 1, nums.length, -(nums[i] + nums[j]));
                if (idx >= 0)
                    res.add(Arrays.asList(nums[i], nums[j], nums[idx]));
            }
        }
        return res;
    }
}
