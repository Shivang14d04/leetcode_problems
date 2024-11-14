import java.util.*;
class IntersectionOfTwoArrays{
    public static void main (String[] args){
        int [] nums1  = {1,2,2,1};
        int [] nums2 = {2,2};
        System.out.println(Arrays.toString(answer(nums1, nums2)));

    }
    public  static int [] answer(int [] nums1, int[] nums2){
    ArrayList<Integer> list = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    for(int num : nums1){
        set.add(num);
    }
    for(int num :nums2){
        if(set.contains(num)){
            list.add(num);
            set.remove(num);
        }
    }
    int [] arr  = new int [list.size()];
    for(int i =0;i<list.size();i++){
        arr[i] = list.get(i);
    }
    return arr;

    } 
}