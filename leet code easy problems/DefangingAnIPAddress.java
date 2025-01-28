
public class DefangingAnIPAddress {

    public static void main(String[] args) {
        String address = "1.1.1.1";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c == '.') {
                result.append("[.]");
            } else {
                result.append(c);

            }

        }
        System.out.println(result.toString());


    }
}
