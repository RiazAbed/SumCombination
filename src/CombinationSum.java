import java.util.ArrayList;

public class CombinationSum {
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> nums, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> currentList = new ArrayList<>();
        findCombinations(nums, target, result, currentList, 0);
        return result;
    }

    private static void findCombinations(ArrayList<Integer> nums, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentList, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = startIndex; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num <= target) {
                currentList.add(num);
                findCombinations(nums, target - num, result, currentList, i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(6);
        nums.add(7);
        int target = 7;
        ArrayList<ArrayList<Integer>> result = combinationSum(nums, target);
        System.out.println(result);
    }
}