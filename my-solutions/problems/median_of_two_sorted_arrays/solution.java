class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        if (a > b)
          return   findMedianSortedArrays(nums2, nums1);
        int start = 0;
        int end = a;
        while (start <= end) {
            int mid1 = start + ((end - start) >> 1);
            int mid2 = ((a + b + 1) >> 1) - mid1;
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r1 = (mid1 == a) ? Integer.MAX_VALUE : nums1[mid1];

            int r2 = (mid2 == b) ? Integer.MAX_VALUE : nums2[mid2];

            if(l1<=r2 && l2<=r1){
                if((a+b)%2==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2);
                }

            }
            else if(l1>r2){
                end = mid1 -1;
            }
            else{
                start = mid1+1;
            }

        }
        return 0.0;
    }
}