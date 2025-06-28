
import java.util.Scanner;

public class KthSymbolInGrammar {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();
        System.out.println(kthGrammar(n, k));

    }

    public static int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int length = 1 << (n - 2);
        if (k <= length) {
            return kthGrammar(n - 1, k); 
        }else {
            return 1 - kthGrammar(n - 1, k - length);
        }
    }
}
