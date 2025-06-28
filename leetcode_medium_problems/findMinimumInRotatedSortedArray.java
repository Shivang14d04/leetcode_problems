public class findMinimumInRotatedSortedArray{
    public static void main(String[] args){
        int [] nums = {4,5,6,7,0,1,2};
        int answer = solution(nums);
        System.out.println(answer);

    }
    public static int solution(int[] nums){
        int start =0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start +(end - start)/2;
            if(nums[mid]<nums[end]){
                end = mid;
            }
            else{
                start  = mid +1;
            }
        }
        return nums[end];

    }
}