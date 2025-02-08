public class Solution {
    public boolean isValid(String s) {
        int prevLength;
        do {
            prevLength = s.length();
            s = s.replace("()", "")
                 .replace("[]", "")
                 .replace("{}", "");
        } while (s.length() != prevLength); // Continue until no changes are made

        return s.isEmpty(); // If fully removed, it's valid
    }


}
