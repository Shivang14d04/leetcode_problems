public class MaximumProductOfTwoElementsInAnArray{
    public static void main(String[] args) {
        int [] nums = {1,5,4,5};
        System.out.println(solution(nums));
    }
    public static int solution(int [] nums){
        int max = 0;
    for(int i = 0;i<nums.length;i++){
        for(int j = 0;j<nums.length;j++){
            int k = (nums[i]-1)*(nums[j]-1);
            if(i!=j && max<k){
                max =k; 
            }
        }
    }
    return max;        
        

    }
}