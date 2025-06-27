public class ReversePrefixOfWord{
    public static void main(String[] args){
        String word = "abcdefd";
        String ch = "d";
        System.out.println(solution(word, ch));
    }
    public static String solution(String word , String ch){
        int a = word.indexOf(ch);
        if(a != -1){
            return new StringBuilder(word.substring(0,a+1)).reverse().toString() + word.substring(a+1);
        }
        return word;
    }
}