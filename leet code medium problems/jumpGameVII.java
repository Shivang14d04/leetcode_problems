
public class jumpGameVII {

    public static void main(String[] args) {
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        System.out.println(solution(s, minJump, maxJump));
    }

    public static Boolean solution(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') {
            return false;
        }
        boolean[] avaiable = new boolean[s.length()];
        avaiable[0] = true;
        int start;
        int end = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (!avaiable[i]) {
                continue;
            }
            start = Math.max(i + minJump, end + 1);
            end = Math.min(i + maxJump, s.length() - 1);
            for (int j = start; j <= end; ++j) {
                if (s.charAt(j) == '0') {
                    avaiable[j] = true;
                }
                if (avaiable[avaiable.length - 1]) {
                    return true;
                }
            }
        }
        return avaiable[s.length() - 1];
    }
}
