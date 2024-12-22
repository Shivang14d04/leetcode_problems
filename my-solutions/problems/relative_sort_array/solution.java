class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
       List<Integer> List = new ArrayList<>();
       int [] ans = new int[arr1.length];
       for(int i =0 ; i< arr2.length ;i++){
         for(int j = 0;j< arr1.length;j++){
            if(arr2[i] == arr1[j]){
                List.add(arr1[j]);
                arr1[j] = -1;
            }
        }
    
       }
       Arrays.sort(arr1);
       for(int i =0;i< arr1.length;i++){
        if(arr1[i]!=-1){
            List.add(arr1[i]);
        }
       }
       for(int i =0;i<arr1.length;i++){
        ans[i] = List.get(i);
       }
       return ans;
    }
}