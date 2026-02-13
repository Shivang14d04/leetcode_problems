class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0,nums.length-1,nums);
        return nums;
    }

    public void mergeSort(int left, int right, int []nums){
        if(left>=right)return;
        int mid = (left+right)/2;
        mergeSort(left,mid,nums);
        mergeSort(mid+1,right,nums);
        merge(left,mid,right,nums);
    }

    public void merge(int left, int mid , int right, int[] nums){
        ArrayList<Integer> temp = new ArrayList<>();
        int i = left;
        int j = mid+1;
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp.add(nums[i]);
                i++;
            }
            else{
                temp.add(nums[j]);
                j++;
            }
        }

                while (i <= mid) {
            temp.add(nums[i]);
            i++;
        }

        while (j <= right) {
            temp.add(nums[j]);
            j++;
        }

        for(int k = left ; k<=right;k++){
            nums[k] = temp.get(k-left);
        }
        
    }
}