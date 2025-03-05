
public class BinarySearch {

    public static void main(String[] args) {

        int start = 0;
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int taget = 9;
        int end = nums.length - 1;
        System.out.println(RecursiveSolution(start, end, nums, taget));
    }

    public static int solution1(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }

    public static int RecursiveSolution(int start, int end, int[] nums, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid; 
        }else if (nums[mid] > target) {
            return RecursiveSolution(start, mid - 1, nums, target);
        } else {
            return RecursiveSolution(mid + 1, end, nums, target);

        }
    }
}
