class Search_in_a_rotated_sorted_array_second{
    public static void main(String[] args){
        int [] nums = {1,0,1,1,1};
        int target = 0;
        Boolean answer = solution(nums, target);
        System.out.println(answer);
    }
    public static Boolean solution(int [] nums  , int target){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start +(end -start)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[start]== nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;

            }
            else if(nums[mid]>=nums[start]){
             if(target>=nums[start] && target<=nums[mid]){
                end = mid-1;
            }
            else{
                start = mid +1;
            }                
            }
            else{
                if(target<=nums[end] && target>=nums[mid]){
                    start =mid+1;
                }
                else{
                    end = mid -1;
                }
            }


            
        }
        return false;
    }

}