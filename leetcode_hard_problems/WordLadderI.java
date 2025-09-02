import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

 class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first = first;
        this.second = second;
    }
}
public class WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        Set<String> set = new HashSet<>();
        int n = wordList.size();
        for(int i = 0;i<n;i++){
            set.add(wordList.get(i));
        }

        set.remove(beginWord);

        while(!q.isEmpty()){

            String word = q.peek().first;
            int steps  = q.peek().second;
            q.remove();


            if(word.equals(endWord)){
                return steps;
            }

            for(int i = 0;i<beginWord.length();i++){
                for(char ch = 'a' ; ch<='z';ch++){
                    char [] replacedword = word.toCharArray();
                    replacedword[i] = ch;
                    String replacedWord = new String(replacedword);

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.offer(new Pair(replacedWord, steps+1));
                    }
                }
            }

        }
        return 0;
        
    }
}