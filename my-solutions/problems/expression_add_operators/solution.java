class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    public void helper(List<String> result, StringBuilder path, String num, int target, int index, long value, long last) {
        if (index == num.length()) {
            if (value == target) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;

            String part = num.substring(index, i + 1);
            long curr = Long.parseLong(part);
            int len = path.length();

            if (index == 0) {
                // First number — don't add operator
                path.append(part);
                helper(result, path, num, target, i + 1, curr, curr);
                path.setLength(len); // backtrack
            } else {
                // +
                path.append('+').append(part);
                helper(result, path, num, target, i + 1, value + curr, curr);
                path.setLength(len);

                // -
                path.append('-').append(part);
                helper(result, path, num, target, i + 1, value - curr, -curr);
                path.setLength(len);

                // *
                path.append('*').append(part);
                helper(result, path, num, target, i + 1, value - last + last * curr, last * curr);
                path.setLength(len);
            }
        }
    }
}
