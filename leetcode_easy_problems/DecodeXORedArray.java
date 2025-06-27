
import java.util.*;

public class DecodeXORedArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int b = input.nextInt();
        int first = input.nextInt();
        int[] encoded = new int[b];
        for (int i = 0; i < b; i++) {
            encoded[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(solution(encoded, first)));

    }

    public static int[] solution(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            arr[i + 1] = arr[i] ^ encoded[i];
        }
        return arr;
    }
}
