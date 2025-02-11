
public class RemoveAllOccurencesOfAsubString {

    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";
        while (s.contains(part)) {
            int partStartIndex = s.indexOf(part);

            s = s.substring(0, partStartIndex) + s.substring(partStartIndex + part.length());

        }
        System.out.println(s);
    }
}
