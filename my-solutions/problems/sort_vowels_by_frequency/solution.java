class Solution {
    public String sortVowels(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> ind = new HashMap<>();
        int i =0;
        for(char ch : s.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch  == 'o' || ch == 'u'){
             freq.put(ch, freq.getOrDefault(ch ,0)+1);  
                ind.putIfAbsent(ch,i);
            } 
            i++;
            
        }
        List<Character> list = new ArrayList<>();
        for(char ch : s.toCharArray()){
          if(ch == 'a' || ch == 'e' || ch == 'i' || ch  == 'o' || ch == 'u'){
              list.add(ch);
          }  
        }
        Collections.sort(list,(a,b)->{
            if(!freq.get(b).equals(freq.get(a))){
                return freq.get(b)- freq.get(a);
            }
            return ind.get(a)- ind.get(b);
        });
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch  == 'o' || ch == 'u'){
                if(j<list.size()){
                ans.append(list.get(j));
                j++;                    
                }

            }
            else{
                
            
                ans.append(ch);
            }
            
        }

        return ans.toString();
        
        
    }
}