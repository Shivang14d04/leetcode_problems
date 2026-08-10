class Solution {
    public String longestPalindrome(String s) {
        HashMap<Integer, String> map = new HashMap<>();
        int n = s.length();
        int max  = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                String sub  = s.substring(i,j+1);
                if(isValid(sub)){
                    map.put(sub.length(),sub);
                }
            }
        }
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            max = Math.max(entry.getKey(),max);
        }
        return map.get(max);
    }

    public boolean isValid(String s){
        int i =0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!= s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}