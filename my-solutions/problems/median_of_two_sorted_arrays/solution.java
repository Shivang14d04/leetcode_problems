class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int total = n1+n2;
        int left = (total+1)/2;
        int low = 0, high = n1;
        while(low <= high){
            int i = (low+high)/2;
            int j = left - i;

            int Aleft = i>0 ? nums1[i-1] :Integer.MIN_VALUE;
            int Aright = i<n1 ? nums1[i] :Integer.MAX_VALUE;
            int Bleft = j>0 ? nums2[j-1]:Integer.MIN_VALUE;
            int Bright = j<n2 ? nums2[j] :Integer.MAX_VALUE;
            if(Aleft <= Bright && Bleft <= Aright){
                if(total%2 ==0){
                    return (Math.max(Aleft, Bleft) + Math.min(Aright,Bright))/2.0;
                }
                else{
                    return Math.max(Aleft,Bleft);
                }
            }
             else if (Aleft > Bright) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        return -1;
    }
}