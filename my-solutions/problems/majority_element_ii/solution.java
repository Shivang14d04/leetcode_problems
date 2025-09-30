class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int times = n/3;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int it: map.keySet()){
            if(map.containsKey(it) && map.get(it)>times){
                list.add(it);
            }
        }
        return list;
        
    }
}