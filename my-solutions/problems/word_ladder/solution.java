class Pair{
    String first;
    int second;
    Pair(String _first , int _second){
        this.first  = _first;
        this.second = _second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        for(int i =0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int length = q.peek().second;
            q.remove();
            if(word.equals(endWord)) return length;
            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char [] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        q.offer(new Pair(replacedWord,length+1));
                        set.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }
}