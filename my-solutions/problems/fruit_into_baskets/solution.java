class Solution {
    public int totalFruit(int[] fruits) {
        int Max = 0;
        int left = 0;
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            Max = Math.max(i-left+1, Max);

        }
        return Max;
    }
}