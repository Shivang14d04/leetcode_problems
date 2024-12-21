
import java.util.Arrays;

public class AssignCookies{
    public static void main(String[] args){
        int [] s = {1,1};
        int [] g = {1,2,3};
        System.out.println(solution(s, g));

    }
    public static int solution(int [] s , int [] g){
        int a = s.length-1;
        int b = g.length-1;
        int count = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        while(a>=0 && b >=0){
            if(s[a]>= g[b]){
                count++;
                a--;
                b--;
            }
            else{
                b--;
            }
        }
        return count;
    }
}