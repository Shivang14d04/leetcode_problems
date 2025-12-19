class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
       int[] arr = new int[n];
       int s = 0;
       int e = 0;
       int i = 0;
       while(s<nums1.length && e<nums2.length){
        if(nums1[s]>=nums2[e]){
            arr[i] = nums2[e];
            e++;
            i++;
        }
        else{
            arr[i] = nums1[s];
            s++;
            i++;
        }
       }
       if(s==nums1.length){
        while(e<nums2.length){
            arr[i]=nums2[e];
            e++;
            i++;
        }
       }
        if(e==nums2.length){
        while(s<nums1.length){
            arr[i]=nums1[s];
            s++;
            i++;
        }
       }
        double ans = 0;
       if(n%2==0){
        ans = (arr[(n/2) - 1] + arr[n/2])/2.0;
       }
       else{
        ans = arr[n/2];
       }

        return ans;
    }
}