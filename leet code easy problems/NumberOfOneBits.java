
import java.util.*;

public class NumberOfOneBits {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution(n));

    }

    public static int solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        while (n > 0) {
            int r = n % 2;
            n /= 2;
            answer.add(r);

        }
        int count = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == 1) {
                count++;
            }

        }
        return count;
    }

// ALTERNATE SOLUTION 
    // public static int solution2(int n){
    //     int count = 0;
    //     while(n>0){
    //         count += n&1;
    //         n>>=1;
    //     }
    //     return count;
    // }
}
